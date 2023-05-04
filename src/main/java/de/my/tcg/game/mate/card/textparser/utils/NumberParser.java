package de.my.tcg.game.mate.card.textparser.utils;

public class NumberParser {
    private static final String SECOND = "2nd";
    private NumberParser() {

    }

    public static int parseNumberOrStringToInteger(String numberOrString) {
        if (numberOrString.matches("\\d+")) {
            return Integer.parseInt(numberOrString);
        }
        if (SECOND.equals(numberOrString)) {
            return 2;
        }
        //Wert sollte  'a' sein daher 1
        return 1;
    }
}
