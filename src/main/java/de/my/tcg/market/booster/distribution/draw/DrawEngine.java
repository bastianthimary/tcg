package de.my.tcg.market.booster.distribution.draw;

import de.my.tcg.domain.card.Card;
import de.my.tcg.domain.rarity.Rarity;
import de.my.tcg.market.booster.Booster;
import de.my.tcg.market.booster.distribution.*;

import java.util.*;

public class DrawEngine {
    private final Map<Rarity, List<Card>> drawMapOfLists;

    public DrawEngine(Map<Rarity, List<Card>> drawMapOfLists) {
        this.drawMapOfLists = drawMapOfLists;
    }

    public void runDrawForDistributetSetting(RarityAppearance appearance, Booster booster) {
        for (int i = 0; i < appearance.getAppearance(); i++) {
            booster.addCard(drawCardsFromSlot(appearance.getSlot()));
        }
    }

    private Card drawCardsFromSlot(BoosterSlot slot) {
        Card drawedCard;
        if (BoosterSlot.RARE_SLOT.equals(slot)) {
            drawedCard = drawRareCard(true);
        } else if (BoosterSlot.REVERSE_SLOT.equals(slot)) {
            drawedCard = drawRareCard(false);
        } else {
            drawedCard = drawNotRareCard(slot);
        }
        return drawedCard;
    }


    private Card drawRareCard(boolean isRareSlot) {
        Rarity rarity = determineRarityOfDrawedCard(isRareSlot);
        return drawCard(rarity);
    }

    private Rarity determineRarityOfDrawedCard(boolean isRareSlot) {
        List<RarityTicket> lotteryWheel = new ArrayList<>();
        Set<Rarity> raritiesOfSet = new HashSet<>(drawMapOfLists.keySet());
        if (isRareSlot) {
            raritiesOfSet.remove(Rarity.COMMON);
            raritiesOfSet.remove(Rarity.UNCOMMON);
        }
        raritiesOfSet.forEach(rarity -> addTicketsForRarity(rarity, lotteryWheel));
        int size = lotteryWheel.size();
        int drawIndex = new Random().nextInt(size);
        return lotteryWheel.get(drawIndex).getRarity();
    }

    private void addTicketsForRarity(Rarity rarity, List<RarityTicket> lotteryWheel) {
        for (int i = 0; i < BoosterRarityQuote.quoteOfTousandBooster(rarity); i++) {
            lotteryWheel.add(new RarityTicket(rarity));
        }
    }

    private Card drawNotRareCard(BoosterSlot slot) {
        Rarity rarity = RarityInBoosterClassification.mapBoosterSlotToRarity(slot);
        return drawCard(rarity);

    }

    private Card drawCard(Rarity rarity) {
        List<Card> drawList = drawMapOfLists.get(rarity);
        int size = drawList.size();
        int drawIndex = new Random().nextInt(size);
        return drawList.get(drawIndex);
    }
}
