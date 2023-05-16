package de.my.tcg.game.mate.card.textparser.effect.effect;

import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.nextturn.NextTurnEffects;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.EffectTerm;
import de.my.tcg.game.mate.card.textparser.effect.effect.executed.ExecutedEffect;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.EffectTarget;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.MultipleEffectTarget;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.PlayerEffectTarget;
import de.my.tcg.game.mate.card.textparser.effect.effect.target.SingleEffectTarget;
import lombok.Getter;
import lombok.Setter;

public class BasicEffectTerm implements EffectTerm {


    @Setter
    private EffectTarget effectTarget;
    @Getter
    @Setter
    private ExecutedEffect executedEffect;

    public void runEffectOnPokemon(PokemonCard thisPokemonCard) {
        if (executedEffect != null && (isEffectFeasible(thisPokemonCard))) {
            executedEffect.executeEffect(thisPokemonCard);

        }
    }

    @Override
    public void runEffect(int compliedTimes) {
        if (compliedTimes == 1) {
            if (effectTarget instanceof SingleEffectTarget) {
                runEffectOnPokemon(((SingleEffectTarget) effectTarget).getTarget());
            } else if (effectTarget instanceof MultipleEffectTarget) {
                ((MultipleEffectTarget) effectTarget).getTargets().forEach(this::runEffectOnPokemon);
            } else if (effectTarget instanceof PlayerEffectTarget) {
                executedEffect.executeEffect(null);
            }
        }
    }

    private boolean isEffectFeasible(PokemonCard pokemonCard) {
        boolean feasible = true;
        NextTurnEffects nextTurnEffects = pokemonCard.getNextTurnEffects();
        if (nextTurnEffects != null) {
            feasible = nextTurnEffects.isEffectFeasible();
        }
        return feasible;
    }
}
