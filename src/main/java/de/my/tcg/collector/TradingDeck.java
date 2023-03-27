package de.my.tcg.collector;

import de.my.tcg.interfaces.TCGCard;
import de.my.tcg.interfaces.TCGDeck;

import java.util.List;

public class TradingDeck implements TCGDeck {
    List<TCGCard> cardList;

    @Override
    public List<TCGCard> getCards() {
        return cardList;
    }

    @Override
    public int getDecksize() {
        return cardList.size();
    }
}
