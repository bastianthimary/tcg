package de.my.tcg.game.mate.card.status;

public class StatusConditionTextParser {
    private static final String POISON = "POISONED";
    private static final String BURNED = "BURNED";

    private StatusConditionTextParser() {

    }

    public static Status parseStatusFromString(String statusAsString) {
        if (POISON.equals(statusAsString)) {
            return PoisonCondition.SINGLE;
        } else if (BURNED.equals(statusAsString)) {
            return FireCondition.SINGLE;
        } else {
            return SpecialCondition.valueOf(statusAsString);
        }
    }
}
