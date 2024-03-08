package technobel.formation.pip_backend.pl.models.DTOs;

import lombok.Builder;
import technobel.formation.pip_backend.dal.enums.Role;

import java.util.Set;
@Builder
public record AuthDTO(
        String username,
        String token,
        Set<Role> roles
) {
}
