package technobel.formation.pip_backend.pl.models.forms;

import technobel.formation.pip_backend.dal.entities.Personality;
import technobel.formation.pip_backend.dal.entities.Riasec;

public record UserForm(
        String username,
        String password,
        String firstname,
        String lastname,
        Personality personality,
        Riasec riasec
) {
}
