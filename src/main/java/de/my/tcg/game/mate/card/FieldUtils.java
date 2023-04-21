package de.my.tcg.game.mate.card;

import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;

import java.util.List;
import java.util.stream.Collectors;

public class FieldUtils {
    public static void discardEnergyFromPokemon(List<EnergyCard> costs, PokemonCard activeMon, FieldSide fieldSide) {
        EnergyTotal energyTotal = activeMon.getEnergyTotal();
        energyTotal.removeListOfEnergyCards(costs);
        fieldSide.addCardToDiscardPile(costs.stream().map(FieldCard::getCurrentCard).collect(Collectors.toList()));
    }
}
