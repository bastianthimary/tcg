package de.my.tcg.game.mate.card.textparser.effect.effect.executed.draw;

import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.ExecutedEffect;

public class DrawCardsExecution implements ExecutedEffect {

    private final int numberOfCards;
    private final FieldSide fieldSide;

    public DrawCardsExecution(int numberOfCards, FieldSide fieldSide) {
        this.numberOfCards = numberOfCards;
        this.fieldSide = fieldSide;
    }

    @Override
    public void executeEffect(PokemonCard thisPokemonCard) {
        fieldSide.getPlayer().drawSeveralCardsFromDeckToHand(numberOfCards);
    }
}
