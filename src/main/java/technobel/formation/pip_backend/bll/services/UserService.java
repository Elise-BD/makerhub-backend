package technobel.formation.pip_backend.bll.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.pl.models.DTOs.AuthDTO;
import technobel.formation.pip_backend.pl.models.forms.LoginForm;
import technobel.formation.pip_backend.pl.models.forms.RegisterForm;
import technobel.formation.pip_backend.pl.models.forms.UserForm;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void register(RegisterForm form);

    AuthDTO login(LoginForm form);

    Optional<User> getById(Integer id);

    Optional<User> findByUsername(String username);

    List<User> getAll();

    void update(UserForm form, Integer id);

    void delete(Integer id);
}
