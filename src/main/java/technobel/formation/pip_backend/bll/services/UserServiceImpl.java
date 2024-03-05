package technobel.formation.pip_backend.bll.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.repositories.UserRepository;
import technobel.formation.pip_backend.pl.models.DTOs.AuthDTO;
import technobel.formation.pip_backend.pl.models.forms.LoginForm;
import technobel.formation.pip_backend.pl.models.forms.RegisterForm;
import technobel.formation.pip_backend.pl.models.forms.UserForm;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void register(RegisterForm form) {

    }

    @Override
    public AuthDTO login(LoginForm form) {
        return null;
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void update(UserForm form, Integer id) {
        if(form == null) throw new IllegalArgumentException("Le formulaire est vide.");

        User u = getById(id).orElseThrow(() -> new EntityNotFoundException("Aucune entité trouvée pour cet ID : " +id));
        u.setUsername(form.username());
        u.setPassword(form.password());
        u.setFirstname(form.firstname());
        u.setLastname(form.lastname());
        u.setPersonality(form.personality());
        u.setRiasec(form.riasec());
        userRepository.save(u);
    }

    @Override
    public void delete(Integer id) {

    }
}
