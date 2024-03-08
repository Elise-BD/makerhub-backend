package technobel.formation.pip_backend.pl.models.DTOs;

import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.enums.PersonalityResult;
import technobel.formation.pip_backend.dal.enums.RiasecResult;

import java.util.Set;

public record UserDTO(
        Integer id,
        String username,
        String firstname,
        String lastname,
        PersonalityResult personality,
        Set<RiasecResult> riasec
) {
    public static UserDTO fromEntityToDTO(User entity){
        return new UserDTO(entity.getId(), entity.getUsername(), entity.getFirstname(), entity.getLastname(), entity.getPersonality(), entity.getRiasec());
    }
}
