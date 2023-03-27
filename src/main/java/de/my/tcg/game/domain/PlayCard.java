package de.my.tcg.game.domain;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.interfaces.TCGCard;


public class PlayCard implements TCGCard {
    public PlayCard(Card card) {
        this.card = card;
    }

    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
