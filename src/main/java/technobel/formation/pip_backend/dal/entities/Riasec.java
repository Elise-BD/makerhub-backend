package technobel.formation.pip_backend.dal.entities;

import jakarta.persistence.*;
import technobel.formation.pip_backend.dal.enums.RiasecResult;

@Entity
@Table(name = "riasec")
public class Riasec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "result1")
    private RiasecResult result1;

    @Column(name = "result2")
    private RiasecResult result2;

    @Column(name = "result3")
    private RiasecResult result3;

    @Column(name = "id_text")
    private String idText;

}