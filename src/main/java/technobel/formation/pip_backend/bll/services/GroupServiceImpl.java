package technobel.formation.pip_backend.bll.services;

import org.springframework.stereotype.Service;
import technobel.formation.pip_backend.dal.entities.Group;
import technobel.formation.pip_backend.dal.repositories.GroupRepository;
import technobel.formation.pip_backend.pl.models.forms.GroupForm;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void create(GroupForm form) {

    }

    @Override
    public Optional<Group> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll().stream().filter(g -> !g.getDisabled()).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

    }
}
