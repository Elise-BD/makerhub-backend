package technobel.formation.pip_backend.pl.models.DTOs;

import technobel.formation.pip_backend.dal.entities.Group;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.enums.PersonalityResult;
import technobel.formation.pip_backend.dal.enums.RiasecResult;
import technobel.formation.pip_backend.dal.enums.Role;

import java.util.Set;
import java.util.stream.Collectors;

public record UserDTO(
        Integer id,
        String username,
        String firstname,
        String lastname,
        PersonalityResult personality,
        Set<RiasecResult> riasec,
        Set<Integer> groups
) {
    public static UserDTO fromEntityToDTO(User entity){
        return new UserDTO(
                entity.getId(),
                entity.getUsername(),
                entity.getFirstname(),
                entity.getLastname(),
                entity.getPersonality(),
                entity.getRiasec(),
                entity.getGroups().stream().map(Group::getId).collect(Collectors.toSet())
        );
    }
}
