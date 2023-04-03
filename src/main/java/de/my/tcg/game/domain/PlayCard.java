package de.my.tcg.game.domain;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.interfaces.TCGCard;
import lombok.Getter;
import lombok.Setter;


public class PlayCard implements TCGCard {
    @Getter
    @Setter
    private Card card;

    public PlayCard(Card card) {
        this.card = card;
    }
}
