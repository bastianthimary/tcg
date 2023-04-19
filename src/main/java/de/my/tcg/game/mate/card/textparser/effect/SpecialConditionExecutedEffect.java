package de.my.tcg.game.mate.card.textparser.effect;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.status.SpecialCondition;

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
