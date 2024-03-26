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
            admin.setPassword(passwordEncoder.encode("aaaaaaaa"));
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


        //GROUPES DEMO
        if(!groupRepository.existsById(1)){
            Group g1 = new Group();
            g1.setName("Groupe1");
            g1.setDisabled(false);
            g1.setUsers(new HashSet<>());
            groupRepository.save(g1);
        }

        if(!groupRepository.existsById(2)){
            Group g2 = new Group();
            g2.setName("Java Arlon");
            g2.setDisabled(false);
            groupRepository.save(g2);

            User u1 = new User();
            u1.setUsername("alinea");
            u1.setPassword(passwordEncoder.encode("Test1234="));
            u1.setFirstname("Aline");
            u1.setLastname("Héa");
            u1.setRole(Role.UTILISATEUR);
            u1.setPersonality(PersonalityResult.INFP);
            u1.setDisabled(false);
            u1.getGroups().add(g2);
            userRepository.save(u1);

            User u2 = new User();
            u2.setUsername("nathan");
            u2.setPassword(passwordEncoder.encode("Test1234="));
            u2.setFirstname("Nathan");
            u2.setLastname("Pas");
            u2.setRole(Role.UTILISATEUR);
            u2.setPersonality(PersonalityResult.ISTJ);
            u2.setDisabled(false);
            u2.getGroups().add(g2);
            userRepository.save(u2);

            User u3 = new User();
            u3.setUsername("gitForever");
            u3.setPassword(passwordEncoder.encode("Test1234="));
            u3.setFirstname("Pascal");
            u3.setLastname("Bocal");
            u3.setRole(Role.UTILISATEUR);
            u3.setPersonality(PersonalityResult.ISTJ);
            u3.setDisabled(false);
            u3.getGroups().add(g2);
            userRepository.save(u3);

            User u4 = new User();
            u4.setUsername("samysam");
            u4.setPassword(passwordEncoder.encode("Test1234="));
            u4.setFirstname("Samuel");
            u4.setLastname("Mutuel");
            u4.setRole(Role.UTILISATEUR);
            u4.setPersonality(PersonalityResult.ENFP);
            u4.setDisabled(false);
            u4.getGroups().add(g2);
            userRepository.save(u4);

            User u5 = new User();
            u5.setUsername("GBDR");
            u5.setPassword(passwordEncoder.encode("Test1234="));
            u5.setFirstname("Geoffrey");
            u5.setLastname("Pafrais");
            u5.setRole(Role.UTILISATEUR);
            u5.setPersonality(PersonalityResult.ENFP);
            u5.setDisabled(false);
            u5.getGroups().add(g2);
            userRepository.save(u5);

            User u6 = new User();
            u6.setUsername("speedy");
            u6.setPassword(passwordEncoder.encode("Test1234="));
            u6.setFirstname("Ismaïl");
            u6.setLastname("Sprint");
            u6.setRole(Role.UTILISATEUR);
            u6.setPersonality(PersonalityResult.ISTJ);
            u6.setDisabled(false);
            u6.getGroups().add(g2);
            userRepository.save(u6);

            User u7 = new User();
            u7.setUsername("yapock");
            u7.setPassword(passwordEncoder.encode("Test1234="));
            u7.setFirstname("Gaëtan");
            u7.setLastname("Content");
            u7.setRole(Role.UTILISATEUR);
            u7.setPersonality(PersonalityResult.INTP);
            u7.setDisabled(false);
            u7.getGroups().add(g2);
            userRepository.save(u7);

            User u8 = new User();
            u8.setUsername("luckyluka");
            u8.setPassword(passwordEncoder.encode("Test1234="));
            u8.setFirstname("Lucas");
            u8.setLastname("Ducas");
            u8.setRole(Role.UTILISATEUR);
            u8.setPersonality(PersonalityResult.ISFP);
            u8.setDisabled(false);
            u8.getGroups().add(g2);
            userRepository.save(u8);

            User u9 = new User();
            u9.setUsername("loroutan");
            u9.setPassword(passwordEncoder.encode("Test1234="));
            u9.setFirstname("Laurent");
            u9.setLastname("Outan");
            u9.setRole(Role.UTILISATEUR);
            u9.setPersonality(PersonalityResult.INFJ);
            u9.setDisabled(false);
            u9.getGroups().add(g2);
            userRepository.save(u9);

            User u10 = new User();
            u10.setUsername("pixeliz");
            u10.setPassword(passwordEncoder.encode("Test1234="));
            u10.setFirstname("Elise");
            u10.setLastname("Émoi");
            u10.setRole(Role.ENCADRANT);
            u10.setPersonality(PersonalityResult.ENFP);
            u10.setDisabled(false);
            u10.getGroups().add(g2);
            userRepository.save(u10);

            User u11 = new User();
            u11.setUsername("javaKing");
            u11.setPassword(passwordEncoder.encode("Test1234="));
            u11.setFirstname("Yann");
            u11.setLastname("Advisor");
            u11.setRole(Role.ENCADRANT);
            u11.setPersonality(PersonalityResult.ENFP);
            u11.setDisabled(false);
            u11.getGroups().add(g2);
            userRepository.save(u11);
        }

        if(!groupRepository.existsById(3)){
            Group g3 = new Group();
            g3.setName(".NET Ciney");
            g3.setDisabled(false);
            g3.setUsers(new HashSet<>());
            groupRepository.save(g3);
        }

        if(!groupRepository.existsById(4)){

            Group g4 = new Group();
            g4.setName("Anglais Forem");
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

            User u5 = new User();
            u5.setUsername("soph");
            u5.setPassword(passwordEncoder.encode("Test1234="));
            u5.setFirstname("Sophie");
            u5.setLastname("Stiquée");
            u5.setRole(Role.UTILISATEUR);
            u5.setPersonality(PersonalityResult.ISTJ);
            u5.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.CONVENTIONNEL, RiasecResult.INVESTIGATEUR, RiasecResult.REALISTE)));
            u5.setDisabled(false);
            u5.getGroups().add(g4);
            userRepository.save(u5);

            User u6 = new User();
            u6.setUsername("jess");
            u6.setPassword(passwordEncoder.encode("Test1234="));
            u6.setFirstname("Jean");
            u6.setLastname("Sérien");
            u6.setRole(Role.UTILISATEUR);
            u6.setRiasec(new HashSet<>(Arrays.asList(RiasecResult.ENTREPRENANT, RiasecResult.REALISTE, RiasecResult.SOCIAL)));
            u6.setDisabled(false);
            userRepository.save(u6);

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
