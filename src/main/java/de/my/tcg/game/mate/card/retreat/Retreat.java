package de.my.tcg.game.mate.card.retreat;

import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.EnergyCard;
import de.my.tcg.game.mate.card.FieldCard;
import de.my.tcg.game.mate.card.PokemonCard;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class Retreat {
    private boolean retreatCostsPayed = false;

    private final FieldSide fieldSide;
    private final PokemonCard activeMon;
    private final int retreatCosts;
    @Getter
    private PaymentResponse lastPaymentResponse;

    public Retreat(FieldSide fieldSide) {
        this.fieldSide = fieldSide;
        activeMon = fieldSide.getActiveMon();
        retreatCosts = activeMon.getRetreatCosts();
    }

    public PaymentResponse payEasyRetreatCostsOrGetSelectionOfEnergycards() {
        EnergyTotal energyTotal = activeMon.getEnergyTotal();

        if (checkLowerEnergy(energyTotal)) {
            lastPaymentResponse = new PaymentResponse(PaymentState.CAN_NOT_AFFORT_RETREAT);
            return lastPaymentResponse;
        }
        if (checkIsPayable()) {
            retreatCostsPayed = true;
            lastPaymentResponse = new PaymentResponse(PaymentState.PAID);
            return lastPaymentResponse;
        }
        lastPaymentResponse = new PaymentResponse(PaymentState.SELECTION_NEEDED, energyTotal.getAllEnergyCard(), retreatCosts);
        return lastPaymentResponse;
    }

    private boolean checkIsPayable() {
        return retreatCosts == 0 || payIfEasyPayable();
    }

    private boolean checkLowerEnergy(EnergyTotal energyTotal) {
        return energyTotal.getTotalEnergy() < retreatCosts;
    }

    private boolean payIfEasyPayable() {
        EnergyTotal energyTotal = activeMon.getEnergyTotal();
        if (payIfTotalEnergyAndRetreatCostsAreEqual(energyTotal)) return true;
        return payIfAllEnergyCardsHaveSameType(energyTotal);
    }

    private boolean payIfTotalEnergyAndRetreatCostsAreEqual(EnergyTotal energyTotal) {
        if (energyTotal.getTotalEnergy() == retreatCosts) {
            payRetreatCosts(energyTotal.getAllEnergyCard());
            return true;
        }
        return false;
    }

    private boolean payIfAllEnergyCardsHaveSameType(EnergyTotal energyTotal) {
        if (energyTotal.allCardsHaveSameType()) {
            payRetreatCosts(energyTotal.getAllEnergyCard().subList(0, retreatCosts));
            return true;
        }
        return false;
    }

    private void payRetreatCosts(List<EnergyCard> costs) {
        retreatCostsPayed = true;
        EnergyTotal energyTotal = activeMon.getEnergyTotal();
        energyTotal.removeListOfEnergyCards(costs);
        fieldSide.addCardToDiscardPile(costs.stream().map(FieldCard::getCurrentCard).collect(Collectors.toList()));
    }

    public PaymentResponse payRetreatCostsWithSelectedEnergyCards(List<EnergyCard> costs) {
        EnergyTotal energyTotal = activeMon.getEnergyTotal();
        PaymentResponse easyPaymentResponse = payEasyRetreatCostsOrGetSelectionOfEnergycards();
        if (!PaymentState.SELECTION_NEEDED.equals(easyPaymentResponse.getPaymentState())) {
            return easyPaymentResponse;
        }
        if (!energyTotal.contains(costs)) {
            lastPaymentResponse = new PaymentResponse(PaymentState.ENERGY_NOT_IN_ENERGY_TOTAL, energyTotal.getAllEnergyCard(), retreatCosts);
            return lastPaymentResponse;
        }
        energyTotal.removeListOfEnergyCards(costs);
        lastPaymentResponse = new PaymentResponse(PaymentState.PAID);
        return lastPaymentResponse;
    }


}
