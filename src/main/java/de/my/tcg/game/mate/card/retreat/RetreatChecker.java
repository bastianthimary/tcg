package de.my.tcg.game.mate.card.retreat;

import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.nextturn.TurnEffectState;

public class RetreatChecker {
    private RetreatChecker() {

    }

    public static PerformRetreatState checkFieldHasNegativeResponse(FieldSide playMate, PokemonCard benchMonToExchange) {
        if (playMate.getBenchMons().isEmpty()) {
            return PerformRetreatState.CAN_NOT_RETREAT_DUE_TO_EMPTY_BENCH;
        }
        if (!playMate.getBenchMons().contains(benchMonToExchange)) {
            return PerformRetreatState.SELECTED_BENCHMON_IS_NOT_THERE;
        }
        if (!playMate.getActiveMon().getPokemonStatusCondition().statusAllowsRetreat()) {
            return PerformRetreatState.CAN_NOT_RETREAT_DUE_TO_STATUSCONDITION;
        }
        if (checkTurnEffects(playMate)) {
            return PerformRetreatState.CAN_NOT_RETREAT_DUE_TO_TURNEFFECT;
        }

        return null;
    }

    private static boolean checkTurnEffects(FieldSide playMate) {
        var activeMon = playMate.getActiveMon();
        if (activeMon.getNextTurnEffects() == null || activeMon.getNextTurnEffects().getTurnEffect() == null) {
            return false;
        }
        return TurnEffectState.NO_RETREAT.equals(activeMon.getNextTurnEffects().getTurnEffect().getTurnEffectState());
    }
}
