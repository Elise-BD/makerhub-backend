package technobel.formation.pip_backend.pl.models.forms;

import technobel.formation.pip_backend.dal.enums.PersonalityResult;
import technobel.formation.pip_backend.dal.enums.RiasecResult;
import technobel.formation.pip_backend.dal.enums.Role;

public record UserFormAdmin(
        String username,
        String password,
        String firstname,
        String lastname,
        Role role,
        PersonalityResult personality,
        RiasecResult riasec1,
        RiasecResult riasec2,
        RiasecResult riasec3
) {
}
