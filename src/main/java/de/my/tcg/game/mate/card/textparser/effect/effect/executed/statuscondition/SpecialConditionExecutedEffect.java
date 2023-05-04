package de.my.tcg.game.mate.card.textparser.effect.effect.executed.statuscondition;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.status.SpecialCondition;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.ExecutedEffect;

public class SpecialConditionExecutedEffect implements ExecutedEffect {
    private final SpecialCondition specialCondition;

    public SpecialConditionExecutedEffect(SpecialCondition specialCondition) {
        this.specialCondition = specialCondition;
    }

    @Override
    public void executeEffect(PokemonCard thisPokemonCard) {
        thisPokemonCard.getStatusCondition().setSpecialCondition(specialCondition);
    }
}
