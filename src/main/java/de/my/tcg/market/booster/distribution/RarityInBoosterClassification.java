package de.my.tcg.market.booster.distribution;

import de.my.tcg.basedata.rarity.Rarity;

public class RarityInBoosterClassification {
    private RarityInBoosterClassification() {

    }

    public static BoosterSlot classificateRarityAsBoosterSlot(Rarity rarity) {
        return switch (rarity) {
            case UNCOMMON -> BoosterSlot.UNCOMMON_SLOT;
            case COMMON -> BoosterSlot.COMMON_SLOT;
            default -> BoosterSlot.RARE_SLOT;
        };
    }

    public static Rarity mapBoosterSlotToRarity(BoosterSlot boosterSlot) {
        return switch (boosterSlot) {
            case COMMON_SLOT -> Rarity.COMMON;
            case UNCOMMON_SLOT -> Rarity.UNCOMMON;
            default -> throw new RuntimeException();
        };
    }
}
