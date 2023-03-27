package de.my.tcg.game.mate.energytotal;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.card.EnergyCard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddEnergyCardTest {
    @Test
    public void addEnergyCardTest() {
        EnergyTotal energyTotal = new EnergyTotal();
        EnergyCard energyCard = TestCardFactory.createEnergyCard(PokeType.Darkness);
        energyTotal.addEnergyCard(energyCard);
        assertThat(energyTotal.getTotalEnergy()).isEqualTo(1);
    }
    @Test
    public void addTwoEnergyCardTest() {
        EnergyTotal energyTotal = new EnergyTotal();
        EnergyCard energyCard = TestCardFactory.createEnergyCard(PokeType.Darkness);
        energyTotal.addEnergyCard(energyCard);
        EnergyCard energyCard2 = TestCardFactory.createEnergyCard(PokeType.Darkness);
        energyTotal.addEnergyCard(energyCard2);
        assertThat(energyTotal.getTotalEnergy()).isEqualTo(2);
    }
    @Test
    public void addTwoDifferentEnergyCardTest() {
        EnergyTotal energyTotal = new EnergyTotal();
        EnergyCard energyCard = TestCardFactory.createEnergyCard(PokeType.Darkness);
        energyTotal.addEnergyCard(energyCard);
        EnergyCard energyCard2 = TestCardFactory.createEnergyCard(PokeType.Fire);
        energyTotal.addEnergyCard(energyCard2);
        assertThat(energyTotal.getTotalEnergy()).isEqualTo(2);
    }

}