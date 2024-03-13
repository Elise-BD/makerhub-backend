package technobel.formation.pip_backend.pl.models.DTOs;

import technobel.formation.pip_backend.dal.entities.Group;
import technobel.formation.pip_backend.dal.entities.User;

import java.util.Set;
import java.util.stream.Collectors;

public record GroupDTO(
        Integer id,
        String name,
        Set<UserDTO> users
) {
    public static GroupDTO fromEntityToDTO(Group entity){
        return new GroupDTO(entity.getId(), entity.getName(), entity.getUsers().stream().map(UserDTO::fromEntityToDTO).collect(Collectors.toSet()));
    }
}
