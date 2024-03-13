package technobel.formation.pip_backend.bll.services;

import technobel.formation.pip_backend.dal.entities.Group;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.pl.models.DTOs.AuthDTO;
import technobel.formation.pip_backend.pl.models.forms.*;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    void create(GroupForm form);

    Optional<Group> getById(Integer id);

    List<Group> getAll();

    void delete(Integer id);
}
