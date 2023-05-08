package de.my.tcg.game.mate.card.nextturn;

import lombok.Getter;
import lombok.Setter;

import static de.my.tcg.game.mate.card.nextturn.TurnEffectState.*;

public class NextTurnEffects {

    @Getter
    @Setter
    private TurnEffect turnEffect;

    public void startTurn() {
        turnEffect = null;
    }

    public int calcDmgAfterTurnEffects(int dmgBefore) {
        if (turnEffect == null) {
            return dmgBefore;
        }
        if (isANoDmgState(turnEffect.getTurnEffectState())) {
            return 0;
        }
        if (isDmgReductionState()) {
            return calcReductionDmg(dmgBefore);
        }
        return dmgBefore;
    }

    public boolean isEffectFeasible() {
        if (turnEffect == null) {
            return true;
        }
        TurnEffectState turnEffectState = turnEffect.getTurnEffectState();
        return !(NO_EFFECT.equals(turnEffectState) || NO_DMG_AND_NO_EFFECT.equals(turnEffectState));
    }

    private int calcReductionDmg(int dmgBefore) {
        int reduction = turnEffect.getReduction();
        if (dmgBefore < reduction) {
            return 0;
        } else {
            return dmgBefore - reduction;
        }
    }


    private static boolean isANoDmgState(TurnEffectState effectState) {
        return NO_DMG.equals(effectState) ||
                NO_DMG_AND_NO_EFFECT.equals(effectState);
    }

    private boolean isDmgReductionState() {
        return DMG_REDUCTION.equals(turnEffect.getTurnEffectState());
    }
}
