package technobel.formation.pip_backend.pl.models.forms;

import technobel.formation.pip_backend.dal.enums.PersonalityResult;
import technobel.formation.pip_backend.dal.enums.RiasecResult;

import java.util.Set;

public record UserForm(
        String username,
        String password,
        String firstname,
        String lastname,
        PersonalityResult personality,
        Set<RiasecResult> riasec
) {
}
