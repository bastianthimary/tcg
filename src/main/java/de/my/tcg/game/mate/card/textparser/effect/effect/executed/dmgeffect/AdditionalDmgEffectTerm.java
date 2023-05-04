package de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect;

import lombok.Getter;

public class AdditionalDmgEffectTerm extends DmgEffectTerm {
    @Getter
    private int baseDmg;
    @Getter
    private final int additionalDmg;


    public AdditionalDmgEffectTerm(int baseDmg, int additionalDmg) {
        this.baseDmg = baseDmg;
        this.additionalDmg = additionalDmg;
    }

    @Override
    public void runEffect(int compliedTimes) {
        dmg = baseDmg + additionalDmg * compliedTimes;
    }
}
