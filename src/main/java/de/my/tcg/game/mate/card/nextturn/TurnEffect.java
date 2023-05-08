package de.my.tcg.game.mate.card.nextturn;

import lombok.Getter;

public class TurnEffect {

    @Getter
    private final TurnEffectState turnEffectState;
    @Getter
    private final int reduction;

    public TurnEffect(TurnEffectState turnEffectState) {
        this.turnEffectState = turnEffectState;
        reduction = 0;
    }

    public TurnEffect(int reduction) {
        this.reduction = reduction;
        turnEffectState = TurnEffectState.DMG_REDUCTION;
    }
}
