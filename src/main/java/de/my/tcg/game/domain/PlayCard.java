package de.my.tcg.game.domain;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.interfaces.TCGCard;
import lombok.Getter;


public class PlayCard implements TCGCard {
    @Getter
    private final Card card;

    public PlayCard(Card card) {
        this.card = card;
    }
}
