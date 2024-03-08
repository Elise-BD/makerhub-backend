package technobel.formation.pip_backend.dal.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.enums.PersonalityResult;
import technobel.formation.pip_backend.dal.enums.RiasecResult;
import technobel.formation.pip_backend.dal.enums.Role;
import technobel.formation.pip_backend.dal.repositories.TextRepository;
import technobel.formation.pip_backend.dal.repositories.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataInit implements InitializingBean {

    private final UserRepository userRepository;
    private final TextRepository textRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInit(UserRepository userRepository,
                    TextRepository textRepository,
                    PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.textRepository = textRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        if(!userRepository.existsById(1)){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("Test1234="));
            admin.setFirstname("Admin");
            admin.setRole(Role.ADMIN);
            admin.setDisabled(false);
            userRepository.save(admin);
        }

        if(!userRepository.existsById(2)) {
            User u1 = new User();
            u1.setUsername("jeannot");
            u1.setPassword(passwordEncoder.encode("Test1234="));
            u1.setFirstname("Jean");
            u1.setLastname("Neymar");
            u1.setRole(Role.UTILISATEUR);
            u1.setPersonality(PersonalityResult.ENFJ);
            u1.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.ENTREPRENANT, RiasecResult.SOCIAL, RiasecResult.CONVENTIONNEL)));
            u1.setDisabled(false);
            userRepository.save(u1);
        }




    }
}
