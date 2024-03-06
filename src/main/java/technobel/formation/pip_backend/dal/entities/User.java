package technobel.formation.pip_backend.dal.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import technobel.formation.pip_backend.dal.enums.Role;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user_")
public class User {

    @Id @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Getter @Setter
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
    @NotNull
    @Column(name = "lastname")
    private String lastname;

    @Getter @Setter
    @Column(name = "role")
    private Role role;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personality")
    private Personality personality;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_riasec")
    private Riasec riasec;

    @Getter @Setter
    @Column(name = "disabled")
    private Boolean disabled;

    @Getter @Setter
    @ManyToMany
    @JoinTable(name = "User_join_group",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Group> groups = new LinkedHashSet<>();

}