package de.my.tcg.game.mate.card;

import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;

import java.util.List;

public class FieldUtils {
    private FieldUtils() {
    }

    public static void discardEnergyFromPokemon(List<EnergyCard> costs, PokemonCard activeMon, FieldSide fieldSide) {
        EnergyTotal energyTotal = activeMon.getEnergyTotal();
        energyTotal.removeListOfEnergyCards(costs);
        fieldSide.addCardToDiscardPile(costs.stream().map(FieldCard::getCurrentCard).toList());
    }
}
