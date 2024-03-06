package technobel.formation.pip_backend.pl.models.DTOs;

import technobel.formation.pip_backend.dal.entities.Personality;
import technobel.formation.pip_backend.dal.entities.Riasec;
import technobel.formation.pip_backend.dal.entities.User;

public record UserDTO(
        Integer id,
        String username,
        String firstname,
        String lastname,
        Personality personality,
        Riasec riasec
) {
    public static UserDTO fromEntityToDTO(User entity){
        return new UserDTO(entity.getId(), entity.getUsername(), entity.getFirstname(), entity.getLastname(), entity.getPersonality(), entity.getRiasec());
    }
}
