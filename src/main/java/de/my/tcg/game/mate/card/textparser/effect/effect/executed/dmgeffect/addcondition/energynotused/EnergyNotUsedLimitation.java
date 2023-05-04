package de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.energynotused;

import de.my.tcg.game.mate.card.textparser.effect.effect.executed.dmgeffect.addcondition.Limitation;

public class EnergyNotUsedLimitation implements Limitation {
    private final int dmgLimit;
    private final int dmgPer;

    public EnergyNotUsedLimitation(int dmgLimit, int dmgPer) {
        this.dmgLimit = dmgLimit;
        this.dmgPer = dmgPer;
    }

    @Override
    public int getLimitTimes() {
        return dmgLimit / dmgPer;
    }
}
