package de.my.tcg.collector;

import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.interfaces.TCGDeck;

import java.io.Serializable;
import java.util.List;

public class TradingDeck implements TCGDeck, Serializable {
    private final List<PlayCard> cardList;

    public TradingDeck(List<PlayCard> cardList) {
        this.cardList = cardList;
    }

    @Override
    public List<PlayCard> getCards() {
        return cardList;
    }

    @Override
    public int getDecksize() {
        return cardList.size();
    }
}
