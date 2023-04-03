package de.my.tcg.market.booster.distribution;

import java.util.Set;

import static de.my.tcg.market.booster.distribution.BoosterSlot.*;


public enum BoosterDistributionSetting {
    STANDARD(new RarityAppearance(COMMON_SLOT,5),new RarityAppearance(UNCOMMON_SLOT,3),new RarityAppearance(RARE_SLOT)),
    PROMO(new RarityAppearance(RARE_SLOT,5));

    final Set<RarityAppearance> appearances;
    BoosterDistributionSetting(RarityAppearance ... rarAppearance){
        appearances=Set.of(rarAppearance);
    }

    public Set<RarityAppearance> getAppearances() {
        return appearances;
    }
}
