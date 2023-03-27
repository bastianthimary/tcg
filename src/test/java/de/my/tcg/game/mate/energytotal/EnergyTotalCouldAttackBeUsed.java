package de.my.tcg.game.mate.energytotal;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.EnergyTotal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnergyTotalCouldAttackBeUsed {

    @Test
    void emptyAttack() {
        EnergyTotal energyTotal= new EnergyTotal();
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fighting));
        assertThat(energyTotal.couldAttackBeUsed(null)).isFalse();
    }
}