package de.my.tcg.market.booster.distribution;

import de.my.tcg.basedata.rarity.Rarity;

public class RarityTicket {
    private final Rarity rarity;

    public RarityTicket(Rarity rarity) {
        this.rarity = rarity;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
