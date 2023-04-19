package de.my.tcg.game.mate.card.textparser.utils;

public class NumberParser {
    public static int parseNumberOrStringToInteger(String numberOrString) {
        if (numberOrString.matches("[0-9]+")) {
            return Integer.parseInt(numberOrString);
        }
        //Wert sollte  'a' sein daher 1
        return 1;
    }
}
