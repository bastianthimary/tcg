package de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect;

import de.my.tcg.game.mate.card.textparser.effect.effect.executed.EffectTerm;
import lombok.Getter;

public abstract class DmgEffectTerm implements EffectTerm {
    @Getter
    protected int dmg;

    @Override
    public abstract void runEffect(int compliedTimes);
}
