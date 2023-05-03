package de.my.tcg.game.mate.card.retreat;

import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;

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
        if (!playMate.getActiveMon().getStatusCondition().statusAllowsRetreat()) {
            return PerformRetreatState.CAN_NOT_RETREAT_DUE_TO_STATUSCONDITION;
        }

        return null;
    }
}
