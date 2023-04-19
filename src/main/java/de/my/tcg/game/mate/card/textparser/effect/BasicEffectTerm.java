package de.my.tcg.game.mate.card.textparser.effect;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.condition.EffectTerm;
import lombok.Setter;

public class BasicEffectTerm implements EffectTerm {


    @Setter
    private EffectTarget effectTarget;

    @Setter
    private ExecutedEffect executedEffect;

    public void runEffectOnPokemon(PokemonCard thisPokemonCard) {
        if (executedEffect != null) {
            executedEffect.executeEffect(thisPokemonCard);
        }
    }

    @Override
    public void runEffect(int compliedTimes) {
        if (compliedTimes == 1) {
            runEffectOnPokemon(effectTarget.getTarget());
        }
    }
}
