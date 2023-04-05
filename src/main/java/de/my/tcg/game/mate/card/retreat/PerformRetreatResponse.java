package de.my.tcg.game.mate.card.retreat;

import lombok.Getter;

public class PerformRetreatResponse {
    @Getter
    private final PerformRetreatState retreatState;
    @Getter
    private PaymentResponse paymentResponse;

    public PerformRetreatResponse(PerformRetreatState retreatState) {
        this.retreatState = retreatState;
    }

    public PerformRetreatResponse(PerformRetreatState retreatState, PaymentResponse paymentResponse) {
        this.retreatState = retreatState;
        this.paymentResponse = paymentResponse;
    }
}
