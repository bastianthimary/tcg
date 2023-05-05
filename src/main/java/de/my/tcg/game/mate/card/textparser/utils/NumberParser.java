package de.my.tcg.game.mate.card.textparser.utils;

public class NumberParser {
    private static final String SECOND = "2nd";
    private static final String ALL_STRING = "all";
    public static final int ALL = -200;

    private NumberParser() {

    }

    public static int parseNumberOrStringToInteger(String numberOrString) {
        if (numberOrString.matches("\\d+")) {
            return Integer.parseInt(numberOrString);
        }
        if (SECOND.equals(numberOrString)) {
            return 2;
        } else if (ALL_STRING.equals(numberOrString)) {
            return ALL;
        }
        //Wert sollte  'a' sein daher 1
        return 1;
    }
}
