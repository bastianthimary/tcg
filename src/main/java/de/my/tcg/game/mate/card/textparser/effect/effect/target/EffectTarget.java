package de.my.tcg.game.mate.card.textparser.effect.effect.target;

import de.my.tcg.game.mate.card.PokemonCard;
import lombok.Getter;

public class EffectTarget {

    @Getter
    private final PokemonCard target;

    public EffectTarget(PokemonCard target) {
        this.target = target;
    }
}
