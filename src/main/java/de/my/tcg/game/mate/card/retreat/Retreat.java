package de.my.tcg.game.mate.card.retreat;

import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.EnergyCard;
import de.my.tcg.game.mate.card.FieldCard;
import de.my.tcg.game.mate.card.PokemonCard;

import java.util.List;
import java.util.stream.Collectors;

public class Retreat {
    private boolean retreatCostsPayed = false;

    private final FieldSide fieldSide;
    private final PokemonCard activeMon;
    private final int retreatCosts;

    public Retreat(FieldSide fieldSide) {
        this.fieldSide = fieldSide;
        activeMon = fieldSide.getActiveMon();
        retreatCosts = activeMon.getRetreatCosts();
    }

    public PaymentResponse payEasyRetreatCostsOrGetSelectionOfEnergycards() {
        EnergyTotal energyTotal = activeMon.getEnergyTotal();

        if (checkLowerEnergy(energyTotal)) {
            return new PaymentResponse(PaymentState.CAN_NOT_AFFORT_RETREAT);
        }
        if (checkIsPayable()) {
            retreatCostsPayed = true;
            return new PaymentResponse(PaymentState.PAID);
        }
        return new PaymentResponse(PaymentState.SELECTION_NEEDED, energyTotal.getAllEnergyCard(), retreatCosts);
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

    public void payRetreatCosts(List<EnergyCard> costs) {
        EnergyTotal energyTotal = activeMon.getEnergyTotal();
        energyTotal.removeListOfEnergyCards(costs);
        fieldSide.addCardToDiscardPile(costs.stream().map(FieldCard::getCurrentCard).collect(Collectors.toList()));
    }


}
