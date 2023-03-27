package de.my.tcg.interfaces;

import java.util.List;

public interface TCGDeck {
    List<TCGCard> getCards();
    int getDecksize();
}
