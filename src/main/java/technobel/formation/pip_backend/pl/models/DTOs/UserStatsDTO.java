package technobel.formation.pip_backend.pl.models.DTOs;

import technobel.formation.pip_backend.dal.entities.Group;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.enums.PersonalityResult;
import technobel.formation.pip_backend.dal.enums.RiasecResult;

import java.util.Set;
import java.util.stream.Collectors;

public record UserStatsDTO(
        Integer id,
        String username,
        String firstname,
        String lastname,
        String personality,
        String family,
        String type,
        String firstLetter,
        String middleLetters,
        String lastLetter,
        Set<RiasecResult> riasec
) {
    public static UserStatsDTO fromEntityToDTO(User entity){
        String personality = "";
        String family = "";
        String type = "";
        String firstLetter = "";
        String middleLetters = "";
        String lastLetter = "";

        if(entity.getPersonality() != null){
            personality = entity.getPersonality().toString();

            if(entity.getPersonality().getFamily() != null){
                family = entity.getPersonality().getFamily().toString();
            }


            if(entity.getPersonality().getType() != null){
                type = entity.getPersonality().getType().toString();
            }


            if(entity.getPersonality().getFirstLetter() != null){
                firstLetter = entity.getPersonality().getFirstLetter().toString();
            }


            if(entity.getPersonality().getMiddleLetters() != null){
                middleLetters = entity.getPersonality().getMiddleLetters().toString();
            }


            if(entity.getPersonality().getLastLetter() != null){
                lastLetter = entity.getPersonality().getLastLetter().toString();
            }
        }


        return new UserStatsDTO(
                entity.getId(),
                entity.getUsername(),
                entity.getFirstname(),
                entity.getLastname(),
                personality,
                family,
                type,
                firstLetter,
                middleLetters,
                lastLetter,
                entity.getRiasec()
        );
    }
}
