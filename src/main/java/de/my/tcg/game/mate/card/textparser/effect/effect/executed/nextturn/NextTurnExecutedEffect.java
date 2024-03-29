package de.my.tcg.game.mate.card.textparser.effect.effect.executed.nextturn;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.nextturn.TurnEffect;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.ExecutedEffect;

public class NextTurnExecutedEffect implements ExecutedEffect {
    private final TurnEffect turnEffect;

    public NextTurnExecutedEffect(TurnEffect turnEffect) {
        this.turnEffect = turnEffect;
    }

    @Override
    public void executeEffect(PokemonCard thisPokemonCard) {
        thisPokemonCard.getNextTurnEffects().setTurnEffect(turnEffect);
    }
}
