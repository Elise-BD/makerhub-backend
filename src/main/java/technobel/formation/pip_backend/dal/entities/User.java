package technobel.formation.pip_backend.dal.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import technobel.formation.pip_backend.dal.enums.PersonalityResult;
import technobel.formation.pip_backend.dal.enums.RiasecResult;
import technobel.formation.pip_backend.dal.enums.Role;
import technobel.formation.pip_backend.pl.models.DTOs.UserDTO;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "user_")
public class User implements UserDetails {

    @Id @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Getter @Setter
    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Getter @Setter
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Getter @Setter
    @NotNull
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Getter @Setter
    @Column(name = "lastname", nullable = true)
    private String lastname;

    @Getter @Setter
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private PersonalityResult personality;

    @Getter @Setter
    private Set<RiasecResult> riasec;

    @Getter @Setter
    @Column(name = "disabled", columnDefinition = "boolean default false")
    private Boolean disabled;

    @Getter @Setter
    @ManyToMany
    @JoinTable(name = "User_join_group",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Group> groups = new LinkedHashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = new ArrayList<>();
        roles.add(role);

        return roles.stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return !getDisabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !getDisabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !getDisabled();
    }

    @Override
    public boolean isEnabled() {
        return !getDisabled();
    }

}