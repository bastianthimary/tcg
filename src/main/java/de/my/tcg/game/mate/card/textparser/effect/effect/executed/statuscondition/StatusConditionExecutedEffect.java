package de.my.tcg.game.mate.card.textparser.effect.effect.executed.statuscondition;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.status.Status;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.ExecutedEffect;

public class StatusConditionExecutedEffect implements ExecutedEffect {
    private final Status status;

    public StatusConditionExecutedEffect(Status status) {
        this.status = status;
    }

    @Override
    public void executeEffect(PokemonCard thisPokemonCard) {
        thisPokemonCard.getPokemonStatusCondition().setStatus(status);
    }
}
