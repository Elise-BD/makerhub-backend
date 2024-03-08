package technobel.formation.pip_backend.dal.enums;

import lombok.Getter;

public enum PersonalityResult {
    INTJ(FirstLetter.I, MiddleLetters.NT, LastLetter.J, Family.ANALYSTES, PersonalityColor.VIOLET, Type.ARCHITECTE),
    INTP(FirstLetter.I, MiddleLetters.NT, LastLetter.P, Family.ANALYSTES, PersonalityColor.VIOLET, Type.LOGICIEN),
    ENTJ(FirstLetter.E, MiddleLetters.NT, LastLetter.J, Family.ANALYSTES, PersonalityColor.VIOLET, Type.COMMANDANT),
    ENTP(FirstLetter.E, MiddleLetters.NT, LastLetter.P, Family.ANALYSTES, PersonalityColor.VIOLET, Type.INNOVATEUR),
    INFJ(FirstLetter.I, MiddleLetters.NF, LastLetter.J, Family.DIPLOMATES, PersonalityColor.GREEN, Type.AVOCAT),
    INFP(FirstLetter.I, MiddleLetters.NF, LastLetter.P, Family.DIPLOMATES, PersonalityColor.GREEN, Type.MEDIATEUR),
    ENFJ(FirstLetter.E, MiddleLetters.NF, LastLetter.J, Family.DIPLOMATES, PersonalityColor.GREEN, Type.PROTAGONISTE),
    ENFP(FirstLetter.E, MiddleLetters.NF, LastLetter.P, Family.DIPLOMATES, PersonalityColor.GREEN, Type.INSPIRATEUR),
    ISTJ(FirstLetter.I, MiddleLetters.ST, LastLetter.J, Family.SENTINELLES, PersonalityColor.TEAL, Type.LOGISTICIEN),
    ISFJ(FirstLetter.I, MiddleLetters.SF, LastLetter.J, Family.SENTINELLES, PersonalityColor.TEAL, Type.DEFENSEUR),
    ESTJ(FirstLetter.E, MiddleLetters.ST, LastLetter.J, Family.SENTINELLES, PersonalityColor.TEAL, Type.DIRECTEUR),
    ESFJ(FirstLetter.E, MiddleLetters.SF, LastLetter.J, Family.SENTINELLES, PersonalityColor.TEAL, Type.CONSUL),
    ISTP(FirstLetter.I, MiddleLetters.ST, LastLetter.P, Family.SENTINELLES, PersonalityColor.YELLOW, Type.VIRTUOSE),
    ISFP(FirstLetter.I, MiddleLetters.SF, LastLetter.P, Family.SENTINELLES, PersonalityColor.YELLOW, Type.AVENTURIER),
    ESTP(FirstLetter.E, MiddleLetters.ST, LastLetter.P, Family.SENTINELLES, PersonalityColor.YELLOW, Type.ENTREPRENEUR),
    ESFP(FirstLetter.E, MiddleLetters.SF, LastLetter.P, Family.SENTINELLES, PersonalityColor.YELLOW, Type.AMUSEUR)
    ;

    @Getter
    final FirstLetter firstLetter;
    @Getter
    final MiddleLetters middleLetters;
    @Getter
    final LastLetter lastLetter;
    @Getter
    final Family family;
    @Getter
    final PersonalityColor color;
    @Getter
    final Type type;

    PersonalityResult(FirstLetter firstLetter, MiddleLetters middleLetters, LastLetter lastLetter, Family family, PersonalityColor color, Type type) {
        this.firstLetter = firstLetter;
        this.middleLetters = middleLetters;
        this.lastLetter = lastLetter;
        this.family = family;
        this.color = color;
        this.type = type;
    }


}
