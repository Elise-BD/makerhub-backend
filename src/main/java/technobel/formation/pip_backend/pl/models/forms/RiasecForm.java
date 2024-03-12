package technobel.formation.pip_backend.pl.models.forms;

import technobel.formation.pip_backend.dal.enums.RiasecResult;

import java.util.Set;

public record RiasecForm(
        RiasecResult riasec1,
        RiasecResult riasec2,
        RiasecResult riasec3
) {
}
