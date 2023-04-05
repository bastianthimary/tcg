package de.my.tcg.interfaces;

import java.util.List;

public interface TCGDeck {
    List<? extends TCGCard> getCards();

    int getDecksize();
}
