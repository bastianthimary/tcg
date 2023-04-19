package de.my.tcg.game.mate.card.textparser.effect;

import de.my.tcg.game.mate.card.textparser.effect.condition.EffectTerm;
import lombok.Getter;

public abstract class DmgEffectTerm implements EffectTerm {
    @Getter
    protected int dmg;

    @Override
    public abstract void runEffect(int compliedTimes);
}
