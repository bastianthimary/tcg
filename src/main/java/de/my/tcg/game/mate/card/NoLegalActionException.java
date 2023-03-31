package de.my.tcg.game.mate.card;

public class NoLegalActionException extends Exception {
    public NoLegalActionException(String messages) {
        super(messages);
    }

    public final static String CARD_CANT_PLAYED_AS_POKEMON = "Card can't played as Pokemon";
    public final static String POKEMON_CANT_EVOLVE_TO_CHOOSEN_POKEMON = "Pokemon cannot evolve to the Choosen Pokemon";
    public final static String BENCH_IS_FULL = "Your Bench is full";
}
