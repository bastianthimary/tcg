package de.my.tcg.game.mate.card;

import de.my.tcg.game.domain.PlayCard;
import lombok.Getter;

public abstract class FieldCard {
    @Getter
    protected PlayCard currentCard;
}
