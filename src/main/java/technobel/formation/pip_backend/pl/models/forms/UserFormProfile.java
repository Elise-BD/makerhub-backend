package technobel.formation.pip_backend.pl.models.forms;

public record UserFormProfile(
        String username,
        String password,
        String firstname,
        String lastname
) {
}
