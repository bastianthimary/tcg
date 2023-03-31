package de.my.tcg.game.mate.card.retreat;

import de.my.tcg.TestCardFactory;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RetreatTest {


    @Mock
    FieldSide fieldSide = mock(FieldSide.class);

    @Mock
    PokemonCard activeMon = mock(PokemonCard.class);


    EnergyTotal energyTotal;


    @ParameterizedTest
    @CsvFileSource(resources = "/card/retreat/retreat/payEasyRetreatCostsOrGetSelectionOfEnergycards.csv", numLinesToSkip = 1)
    void payEasyRetreatCostsOrGetSelectionOfEnergycards(int retreatCosts, PaymentState expectedState, String energyCardsAsString, int expecedEnergyCardsAfter) {


        energyTotal = new EnergyTotal();
        TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                forEach(energy -> energyTotal.addEnergyCard(energy));
        when(fieldSide.getActiveMon()).thenReturn(activeMon);
        when(activeMon.getRetreatCosts()).thenReturn(retreatCosts);
        when(activeMon.getEnergyTotal()).thenReturn(energyTotal);

        Retreat retreat = new Retreat(fieldSide);
        assertThat(retreat.payEasyRetreatCostsOrGetSelectionOfEnergycards().getPaymentState()).isEqualTo(expectedState);
        assertThat(energyTotal.getTotalEnergy()).isEqualTo(expecedEnergyCardsAfter);
    }

    @Test
    void payRetreatCosts() {
    }
}