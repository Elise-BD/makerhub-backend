package technobel.formation.pip_backend.pl.models.forms;

public record RegisterForm(
        String username,
        String password,
        String firstname,
        String lastname
) {
}
