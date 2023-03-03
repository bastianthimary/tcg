package de.my.tcg.market.booster.distribution;

import de.my.tcg.domain.rarity.Rarity;

public class RarityTicket {
    private Rarity rarity;

    public RarityTicket(Rarity rarity) {
        this.rarity = rarity;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
