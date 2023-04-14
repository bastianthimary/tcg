package de.my.tcg.game.mate.card;

public class NoLegalActionException extends Exception {
    public NoLegalActionException(String messages) {
        super(messages);
    }

    public static final String DECK_IS_NOT_VALID = "Deck ist nicht Spielbar";
    public static final String CARD_NOT_IN_HAND = "Die Karte ist nicht in der Hand";
    public final static String CARD_CANT_PLAYED_AS_POKEMON = "Die ausgewählte Karte kann nicht als Pokemon gespielt werden";
    public final static String POKEMON_CANT_EVOLVE_TO_CHOOSEN_POKEMON = "Pokemon cannot evolve to the Choosen Pokemon";
    public final static String BENCH_IS_FULL = "Your Bench is full";
    public final static String POKEMON_DO_NOT_KNOW_ATTACK = "Das Aktive Pokemon kennt den ausgewählten Angriff nicht";
    public final static String POKEMON_HAVE_TO_LOW_ENERGY_FOR_ATTACK = "Das Aktive Pokemon hat zu wenig Energykarten um den Angriff auszuführen";
    public final static String POKEMON_CAN_NOT_ATTACK_DUE_TO_STATUS_CONDITION = "Pokemon kann wegen der Statusveränderung nicht angreifen ";

}
