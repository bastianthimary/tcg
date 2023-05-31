package de.my.tcg.interfaces;

import de.my.tcg.collector.TradingCard;

import java.util.List;

public interface TCGDeck {
    List<TradingCard> getCards();

    int getDecksize();
}
