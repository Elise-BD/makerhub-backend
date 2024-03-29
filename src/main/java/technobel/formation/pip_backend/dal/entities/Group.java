package technobel.formation.pip_backend.dal.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "group_")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Setter
    @Column(name = "disabled")
    private Boolean disabled;

    @Setter
    @ManyToMany(mappedBy = "groups")
    private Set<User> users = new LinkedHashSet<>();

}