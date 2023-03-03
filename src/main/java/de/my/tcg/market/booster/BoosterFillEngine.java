package de.my.tcg.market.booster;

import de.my.tcg.domain.card.Card;
import de.my.tcg.domain.rarity.Rarity;
import de.my.tcg.market.booster.distribution.*;
import de.my.tcg.market.booster.distribution.draw.DrawEngine;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Collectors;

public class BoosterFillEngine {
    private final String cardSetName;
    private BoosterDistributionSetting distributionSetting;
    private Map<Rarity, List<Card>> drawMapOfLists;

    DrawEngine drawEngine;

    public BoosterFillEngine(List<Card> cardsFromSet, String cardSetName) {
        this.cardSetName = cardSetName;
        doDistributionSetting();
        generateDrawLists(cardsFromSet.stream().filter(card -> card.getRarity() != null).
                collect(Collectors.groupingBy(Card::getRarity)));
    }

    private void doDistributionSetting() {
        if ("Wizards Black Star Promos".equals(cardSetName)) {
            distributionSetting = BoosterDistributionSetting.PROMO;
        } else {
            distributionSetting = BoosterDistributionSetting.STANDARD;
        }
    }

    private void generateDrawLists(Map<Rarity, List<Card>> cardsGroupedByRaritiy) {
        initDrawLists(cardsGroupedByRaritiy);
        cardsGroupedByRaritiy.keySet().forEach(rarity -> copyCardsFromRarityMapToDrawList(cardsGroupedByRaritiy, rarity));
    }

    private void copyCardsFromRarityMapToDrawList(Map<Rarity, List<Card>> cardsGroupedByRaritiy, Rarity rarity) {

        List<Card> rarityDrawList = drawMapOfLists.get(rarity);
        rarityDrawList.addAll(cardsGroupedByRaritiy.get(rarity));
    }

    private void initDrawLists(Map<Rarity, List<Card>> cardsGroupedByRaritiy) {
        drawMapOfLists = new HashMap<>();
        cardsGroupedByRaritiy.keySet().forEach(rarity -> drawMapOfLists.put(rarity, new ArrayList<>()));
        drawEngine = new DrawEngine(drawMapOfLists);
    }

    @Bean
    public Booster fillABooster() {
        Booster booster = new Booster();
        addCards(booster);

        return booster;
    }

    private void addCards(Booster booster) {
        addCardsByRarity(booster);
    }

    private void addCardsByRarity(Booster booster) {
        distributionSetting.getAppearances().forEach(a -> drawEngine.runDrawForDistributetSetting(a, booster));
    }
}
