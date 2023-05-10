package de.my.tcg.game.mate.card.textparser.effect.effect.executed.nothing;

import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.DmgEffectTerm;

public class DoNothingTerm extends DmgEffectTerm {


    @Override
    public void runEffect(int compliedTimes) {
        if (compliedTimes == 1) {
            throw new DoNothingException();
        }
    }
}
