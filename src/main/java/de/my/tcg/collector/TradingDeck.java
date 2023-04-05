package de.my.tcg.collector;

import de.my.tcg.interfaces.TCGCard;
import de.my.tcg.interfaces.TCGDeck;

import java.util.List;

public class TradingDeck implements TCGDeck {
    private final List<? extends TCGCard> cardList;

    public TradingDeck(List<? extends TCGCard> cardList) {
        this.cardList = cardList;
    }

    @Override
    public List<? extends TCGCard> getCards() {
        return cardList;
    }

    @Override
    public int getDecksize() {
        return cardList.size();
    }
}
