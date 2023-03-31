package de.my.tcg.game.mate.card.retreat;

import de.my.tcg.game.mate.card.EnergyCard;
import lombok.Getter;

import java.util.List;

public class PaymentResponse {

    @Getter
    private List<EnergyCard> listOfSection;
    @Getter
    private int retreatCosts;
    @Getter
    private final PaymentState paymentState;

    public PaymentResponse(PaymentState paymentState) {
        if (PaymentState.SELECTION_NEEDED.equals(paymentState)) {
            throw new IllegalArgumentException();
        }
        this.paymentState = paymentState;
    }

    public PaymentResponse(PaymentState paymentState, List<EnergyCard> listOfSection, int retreatCosts) {
        this.listOfSection = listOfSection;
        this.retreatCosts = retreatCosts;
        this.paymentState = paymentState;
    }
}
