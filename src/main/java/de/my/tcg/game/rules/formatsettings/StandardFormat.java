package de.my.tcg.game.rules.formatsettings;

public class StandardFormat implements FormatSettings{
    private final int startHand=7;
    private final int prices=6;
    @Override
    public int numberStartHand() {
        return startHand;
    }

    @Override
    public int prices() {
        return prices;
    }
}
