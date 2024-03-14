package technobel.formation.pip_backend.bll.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import technobel.formation.pip_backend.dal.entities.Group;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.repositories.GroupRepository;
import technobel.formation.pip_backend.dal.repositories.UserRepository;
import technobel.formation.pip_backend.pl.models.forms.GroupForm;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(GroupForm form) {
        Group g = new Group();
        g.setName(form.name());
        g.setDisabled(false);
        groupRepository.save(g);
    }

    @Override
    public Optional<Group> getById(Integer id) {
        return groupRepository.findById(id);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll().stream().filter(g -> !g.getDisabled()).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Group g = getById(id).orElseThrow(() -> new EntityNotFoundException("Aucune entité GROUPE trouvée pour cet ID : " +id));
        g.setDisabled(true);
        groupRepository.save(g);
    }

    @Override
    public void join(Integer groupId, String username) {
        Group g = groupRepository.findById(groupId).orElseThrow(() -> new EntityNotFoundException("Aucune entité GROUPE trouvée pour cet ID : " +groupId));
        User u = userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("Aucune entité USER trouvée pour cet username : " +username));

        g.getUsers().add(u);
        u.getGroups().add(g);
        groupRepository.save(g);
        userRepository.save(u);
    }

    @Override
    public void leave(Integer groupId, String username) {
        Group g = groupRepository.findById(groupId).orElseThrow(() -> new EntityNotFoundException("Aucune entité GROUPE trouvée pour cet ID : " +groupId));
        User u = userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("Aucune entité USER trouvée pour cet username : " +username));

        g.getUsers().remove(u);
        u.getGroups().remove(g);
        groupRepository.save(g);
        userRepository.save(u);
    }


}
