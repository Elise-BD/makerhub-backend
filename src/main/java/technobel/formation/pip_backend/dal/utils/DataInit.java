package technobel.formation.pip_backend.dal.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import technobel.formation.pip_backend.dal.entities.Group;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.enums.PersonalityResult;
import technobel.formation.pip_backend.dal.enums.RiasecResult;
import technobel.formation.pip_backend.dal.enums.Role;
import technobel.formation.pip_backend.dal.repositories.GroupRepository;
import technobel.formation.pip_backend.dal.repositories.TextRepository;
import technobel.formation.pip_backend.dal.repositories.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataInit implements InitializingBean {

    private final UserRepository userRepository;
    private final TextRepository textRepository;

    private final GroupRepository groupRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInit(UserRepository userRepository,
                    TextRepository textRepository,
                    GroupRepository groupRepository,
                    PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.textRepository = textRepository;
        this.groupRepository = groupRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void afterPropertiesSet() throws Exception {


        //ADMIN
        if(!userRepository.existsById(1)){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("Test1234="));
            admin.setFirstname("Admin");
            admin.setLastname("Istrator");
            admin.setRole(Role.ADMIN);
            admin.setDisabled(false);
            userRepository.save(admin);
        }

        //UTILISATEURS DEMO
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

        if(!userRepository.existsById(3)) {
            User u2 = new User();
            u2.setUsername("JPP");
            u2.setPassword(passwordEncoder.encode("Test1234="));
            u2.setFirstname("Jean");
            u2.setLastname("Peuplus");
            u2.setRole(Role.UTILISATEUR);
            u2.setDisabled(false);
            userRepository.save(u2);
        }

        if(!userRepository.existsById(4)) {
            User u3 = new User();
            u3.setUsername("kami");
            u3.setPassword(passwordEncoder.encode("Test1234="));
            u3.setFirstname("Camille");
            u3.setLastname("Onette");
            u3.setRole(Role.UTILISATEUR);
            u3.setPersonality(PersonalityResult.ISFP);
            u3.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.ARTISTE, RiasecResult.SOCIAL, RiasecResult.REALISTE)));
            u3.setDisabled(false);
            userRepository.save(u3);
        }

        if(!userRepository.existsById(5)) {
            User u4 = new User();
            u4.setUsername("maryone");
            u4.setPassword(passwordEncoder.encode("Test1234="));
            u4.setFirstname("Marie");
            u4.setLastname("Onette");
            u4.setRole(Role.UTILISATEUR);
            u4.setDisabled(false);
            userRepository.save(u4);
        }

        if(!userRepository.existsById(6)) {
            User u5 = new User();
            u5.setUsername("saraf");
            u5.setPassword(passwordEncoder.encode("Test1234="));
            u5.setFirstname("Sarah");
            u5.setLastname("Fréchi");
            u5.setRole(Role.ENCADRANT);
            u5.setDisabled(false);
            userRepository.save(u5);
        }

        if(!userRepository.existsById(7)) {
            User u6 = new User();
            u6.setUsername("jess");
            u6.setPassword(passwordEncoder.encode("Test1234="));
            u6.setFirstname("Jean");
            u6.setLastname("Sérien");
            u6.setRole(Role.UTILISATEUR);
            u6.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.ENTREPRENANT, RiasecResult.REALISTE, RiasecResult.SOCIAL)));
            u6.setDisabled(false);
            userRepository.save(u6);
        }


        //GROUPES DEMO
        if(!groupRepository.existsById(1)){
            Group g1 = new Group();
            g1.setName("Groupe demo");
            g1.setDisabled(false);
            g1.setUsers(new HashSet<>(Arrays.asList()));
            groupRepository.save(g1);
        }

        if(!groupRepository.existsById(2)){
            Group g2 = new Group();
            g2.setName("Java Arlon");
            g2.setDisabled(false);
            g2.setUsers(new HashSet<>(Arrays.asList()));
            groupRepository.save(g2);
        }

        if(!groupRepository.existsById(3)){
            Group g3 = new Group();
            g3.setName(".NET Ciney");
            g3.setDisabled(false);
            g3.setUsers(new HashSet<>(Arrays.asList()));
            groupRepository.save(g3);
        }

        if(!groupRepository.existsById(4)){

            Group g4 = new Group();
            g4.setName("Test Stats");
            g4.setDisabled(false);
            groupRepository.save(g4);

            User u1 = new User();
            u1.setUsername("JB");
            u1.setPassword(passwordEncoder.encode("Test1234="));
            u1.setFirstname("Jean");
            u1.setLastname("Bonneau");
            u1.setRole(Role.UTILISATEUR);
            u1.setPersonality(PersonalityResult.ENFJ);
            u1.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.ENTREPRENANT, RiasecResult.SOCIAL, RiasecResult.CONVENTIONNEL)));
            u1.setDisabled(false);
            u1.getGroups().add(g4);
            userRepository.save(u1);

            User u3 = new User();
            u3.setUsername("samy");
            u3.setPassword(passwordEncoder.encode("Test1234="));
            u3.setFirstname("Sam");
            u3.setLastname("Dépasse");
            u3.setRole(Role.UTILISATEUR);
            u3.setPersonality(PersonalityResult.ISFP);
            u3.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.ARTISTE, RiasecResult.SOCIAL, RiasecResult.REALISTE)));
            u3.setDisabled(false);
            u3.getGroups().add(g4);
            userRepository.save(u3);

            User u7 = new User();
            u7.setUsername("ellie");
            u7.setPassword(passwordEncoder.encode("Test1234="));
            u7.setFirstname("Ella");
            u7.setLastname("Faim");
            u7.setRole(Role.ENCADRANT);
            u7.setPersonality(PersonalityResult.ENTJ);
            u7.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.ENTREPRENANT, RiasecResult.REALISTE, RiasecResult.INVESTIGATEUR)));
            u7.setDisabled(false);
            u7.getGroups().add(g4);
            userRepository.save(u7);

            User u8 = new User();
            u8.setUsername("sarak");
            u8.setPassword(passwordEncoder.encode("Test1234="));
            u8.setFirstname("Sarah");
            u8.setLastname("Kroche");
            u8.setRole(Role.UTILISATEUR);
            u8.setPersonality(PersonalityResult.ISFP);
            u8.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.INVESTIGATEUR, RiasecResult.SOCIAL, RiasecResult.ARTISTE)));
            u8.setDisabled(false);
            u8.getGroups().add(g4);
            userRepository.save(u8);

            User u2 = new User();
            u2.setUsername("marco");
            u2.setPassword(passwordEncoder.encode("Test1234="));
            u2.setFirstname("Marc");
            u2.setLastname("Hassin");
            u2.setRole(Role.ENCADRANT);
            u2.setPersonality(PersonalityResult.ENTJ);
            u2.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.ENTREPRENANT, RiasecResult.REALISTE, RiasecResult.INVESTIGATEUR)));
            u2.setDisabled(false);
            u2.getGroups().add(g4);
            userRepository.save(u2);

            User u4 = new User();
            u4.setUsername("anako");
            u4.setPassword(passwordEncoder.encode("Test1234="));
            u4.setFirstname("Anna");
            u4.setLastname("Konda");
            u4.setRole(Role.UTILISATEUR);
            u4.setPersonality(PersonalityResult.ISFP);
            u4.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.INVESTIGATEUR, RiasecResult.SOCIAL, RiasecResult.ARTISTE)));
            u4.setDisabled(false);
            u4.getGroups().add(g4);
            userRepository.save(u4);

        }
    }
}
