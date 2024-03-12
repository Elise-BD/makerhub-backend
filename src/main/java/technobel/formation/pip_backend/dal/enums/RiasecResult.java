package technobel.formation.pip_backend.dal.enums;

import lombok.Getter;

public enum RiasecResult {
    REALISTE("R"),
    INVESTIGATEUR("I"),
    ARTISTE("A"),
    SOCIAL("S"),
    ENTREPRENANT("E"),
    CONVENTIONNEL("C");

    @Getter
    final String letter;

    RiasecResult(String letter) {
        this.letter = letter;
    }
}
