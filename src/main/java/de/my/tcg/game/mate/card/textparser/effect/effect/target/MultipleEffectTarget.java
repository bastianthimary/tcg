package de.my.tcg.game.mate.card.textparser.effect.effect.target;

import de.my.tcg.game.mate.card.PokemonCard;
import lombok.Getter;

import java.util.List;

public class MultipleEffectTarget implements EffectTarget {

    @Getter
    private final List<PokemonCard> targets;

    public MultipleEffectTarget(List<PokemonCard> targets) {
        this.targets = targets;
    }
}
