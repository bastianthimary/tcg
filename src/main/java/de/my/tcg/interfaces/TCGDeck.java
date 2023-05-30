package de.my.tcg.interfaces;

import de.my.tcg.game.domain.PlayCard;

import java.util.List;

public interface TCGDeck {
    List<PlayCard> getCards();

    int getDecksize();
}
