package technobel.formation.pip_backend.bll.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.enums.RiasecResult;
import technobel.formation.pip_backend.dal.enums.Role;
import technobel.formation.pip_backend.dal.repositories.UserRepository;
import technobel.formation.pip_backend.pl.config.security.JWTProvider;
import technobel.formation.pip_backend.pl.models.DTOs.AuthDTO;
import technobel.formation.pip_backend.pl.models.forms.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTProvider jwtProvider;
    private final AuthenticationManager authenticationManager;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JWTProvider jwtProvider, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public void register(RegisterForm form) {
        if(form == null) throw new IllegalArgumentException("Le formulaire est vide.");

        User u = new User();
        u.setUsername(form.username());
        u.setPassword(passwordEncoder.encode(form.password()));
        u.setFirstname(form.firstname());
        u.setLastname(form.lastname());
        u.setRole(Role.UTILISATEUR);
        u.setDisabled(false);
        userRepository.save(u);
    }

    @Override
    public AuthDTO login(LoginForm form) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.username(), form.password()));

        User user = userRepository.findByUsername(form.username())
                .orElseThrow(() -> new EntityNotFoundException("No player entity corresponding to this login (username)."));

        String token = jwtProvider.generateToken(user.getUsername(), user.getRole());
        List<Role> roles = new ArrayList<>();
        roles.add(user.getRole());

        return AuthDTO.builder()
                .token(token)
                .username(user.getUsername())
                .roles(new HashSet<>(roles))
                .build();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll().stream().filter(u -> !u.getDisabled()).collect(Collectors.toList());
    }

    @Override
    public void update(UserFormAdmin form, Integer id) {
        if(form == null) throw new IllegalArgumentException("Le formulaire est vide.");

        User u = getById(id).orElseThrow(() -> new EntityNotFoundException("Aucune entité trouvée pour cet ID : " +id));
        u.setUsername(form.username());
        u.setPassword(form.password());
        u.setFirstname(form.firstname());
        u.setLastname(form.lastname());
        u.setRole(form.role());
        u.setPersonality(form.personality());
        Set<RiasecResult> riasec = Set.of(form.riasec1(), form.riasec2(), form.riasec3());
        u.setRiasec(riasec);
        userRepository.save(u);
    }

    @Override
    public void update(UserFormProfile form, Integer id) {
        if(form == null) throw new IllegalArgumentException("Le formulaire est vide.");

        User u = getById(id).orElseThrow(() -> new EntityNotFoundException("Aucune entité trouvée pour cet ID : " +id));
        u.setUsername(form.username());
        u.setPassword(form.password());
        u.setFirstname(form.firstname());
        u.setLastname(form.lastname());
        userRepository.save(u);
    }

    public void updatePersonality(PersonalityForm form, Integer id){
        if(form == null) throw new IllegalArgumentException("Le formulaire est vide.");

        User u = getById(id).orElseThrow(() -> new EntityNotFoundException("Aucune entité trouvée pour cet ID : " +id));
        u.setPersonality(form.personality());
        userRepository.save(u);
    }

    public void updateRiasec(RiasecForm form, Integer id){
        if(form == null) throw new IllegalArgumentException("Le formulaire est vide.");

        User u = getById(id).orElseThrow(() -> new EntityNotFoundException("Aucune entité trouvée pour cet ID : " +id));
        Set<RiasecResult> riasec = Set.of(form.riasec1(), form.riasec2(), form.riasec3());
        u.setRiasec(riasec);
        userRepository.save(u);
    }

    @Override
    public void delete(Integer id) {
        User u = getById(id).orElseThrow(() -> new EntityNotFoundException("Aucune entité trouvée pour cet ID : " +id));

        u.setDisabled(true);
        userRepository.save(u);
    }
}
