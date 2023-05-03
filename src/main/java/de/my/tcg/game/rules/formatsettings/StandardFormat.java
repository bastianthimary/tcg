package de.my.tcg.game.rules.formatsettings;

public class StandardFormat implements FormatSettings {
    private static final int STARTHAND = 7;
    private static final int PRICES = 6;


    @Override
    public int numberStartHand() {
        return STARTHAND;
    }

    @Override
    public int prices() {
        return PRICES;
    }



}
