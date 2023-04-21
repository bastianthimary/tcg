package de.my.tcg.game.mate.card.textparser.effect.effect;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.EffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.ExecutedEffect;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.EffectTarget;
import lombok.Getter;
import lombok.Setter;

public class BasicEffectTerm implements EffectTerm {


    @Setter
    private EffectTarget effectTarget;
    @Getter
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
