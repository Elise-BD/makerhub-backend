package technobel.formation.pip_backend.pl.models.DTOs;

import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.enums.RiasecResult;

import java.util.HashSet;
import java.util.Set;

public record UserStatsShortDTO(
        String personality,
        String family,
        String type,
        String firstLetter,
        String middleLetters,
        String lastLetter,
        Set<RiasecResult> riasec
) {
    public static UserStatsShortDTO fromEntityToDTO(User entity){
        String personality = "";
        String family = "";
        String type = "";
        String firstLetter = "";
        String middleLetters = "";
        String lastLetter = "";
        Set<RiasecResult> riasec = new HashSet<>();

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

        if(entity.getRiasec() != null){
            riasec = entity.getRiasec();
        }

        return new UserStatsShortDTO(
                personality,
                family,
                type,
                firstLetter,
                middleLetters,
                lastLetter,
                riasec
        );
    }
}
