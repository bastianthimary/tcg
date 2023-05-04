package de.my.tcg.game.mate.card.textparser.utils;

import de.my.tcg.game.mate.card.PokemonCard;

public class CardTextUtil {
    private CardTextUtil() {
    }

    public static final String PLUS_SYMBOL = "+";
    public static final String MULTIPLY_SYMBOL = "×";

    public static String normalizeString(String parseString, PokemonCard thisPokemonCard) {
        if (parseString.contains(thisPokemonCard.getName())) {
            parseString = parseString.replace(thisPokemonCard.getName(), "this Pokemon");
        }
        parseString = parseString.replace("'", "");
        parseString = parseString.replace(" a ", " 1 ");
        return parseString;
    }
}
