package technobel.formation.pip_backend.dal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "text")
public class Text {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "body")
    private String body;

}