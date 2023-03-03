package de.my.tcg.market.booster.distribution;

import de.my.tcg.domain.rarity.Rarity;

public class BoosterRarityQuote {

    public static int quoteOfTousandBooster(Rarity rarity){
       return switch (rarity){
           case COMMON -> 5000;
           case UNCOMMON -> 3000;
           case RARE -> 1000;
           case RARE_HOLO -> 500;
           case RARE_ULTRA,RARE_SECRET,RARE_SHINIY -> 100;
           default -> 0;

       };
    }
}
