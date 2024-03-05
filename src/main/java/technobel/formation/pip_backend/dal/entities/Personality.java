package technobel.formation.pip_backend.dal.entities;

import jakarta.persistence.*;
import lombok.Data;
import technobel.formation.pip_backend.dal.enums.*;

@Entity
@Table(name = "personality")
public class Personality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "result", nullable = false)
    private PersonalityResult result;

    @Column(name = "personality_family")
    private PersonalityFamily personalityFamily;

    @Column(name = "personality_type")
    private PersonalityType personalityType;

    @Column(name = "personality_color")
    private PersonalityColor personalityColor;

    @Column(name = "first_letter")
    private FirstLetter firstLetter;

    @Column(name = "middle_letters")
    private MiddleLetters middleLetters;

    @Column(name = "last_letter")
    private LastLetter lastLetter;

    @Column(name = "extra_letter")
    private ExtraLetter extraLetter;

    @Column(name = "id_text")
    private String idText;

}