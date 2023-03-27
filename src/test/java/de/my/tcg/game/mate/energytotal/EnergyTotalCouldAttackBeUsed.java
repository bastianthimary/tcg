package de.my.tcg.game.mate.energytotal;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.EnergyTotal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnergyTotalCouldAttackBeUsed {

    @Test
    void emptyAttack() {
        EnergyTotal energyTotal = new EnergyTotal();
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fighting));
        assertThat(energyTotal.couldAttackBeUsed(null)).isFalse();
    }

    @Test
    void attackWith2Fire() {
        Cost fireCost = new Cost();
        fireCost.setType(PokeType.Fire);
        fireCost.setQuantity(2);
        Attack attack = TestCardFactory.createAttack("FireAttack", fireCost);
        EnergyTotal energyTotal = new EnergyTotal();
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));

        assertThat(energyTotal.couldAttackBeUsed(attack)).isTrue();
        //Test 2 Attacks in a Row
        assertThat(energyTotal.couldAttackBeUsed(attack)).isTrue();
    }

    @Test
    void attackWith2FireButNotRightCosts() {
        Cost fireCost = new Cost();
        fireCost.setType(PokeType.Fire);
        fireCost.setQuantity(2);
        Attack attack = TestCardFactory.createAttack("FireAttack", fireCost);
        EnergyTotal energyTotal = new EnergyTotal();
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Water));
        assertThat(energyTotal.couldAttackBeUsed(attack)).isFalse();
    }

    @Test
    void attackWith2DiffentCosts() {
        Cost fireCost = new Cost();
        fireCost.setType(PokeType.Fire);
        fireCost.setQuantity(1);
        Cost waterCost = new Cost();
        waterCost.setType(PokeType.Water);
        waterCost.setQuantity(1);

        Attack attack = TestCardFactory.createAttack("FireWaterAttack", fireCost, waterCost);
        EnergyTotal energyTotal = new EnergyTotal();
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Water));
        assertThat(energyTotal.couldAttackBeUsed(attack)).isTrue();
    }
    @Test
    void attackWith2ColorlessCosts() {
        Cost colorlessCost = new Cost();
        colorlessCost.setType(PokeType.Colorless);
        colorlessCost.setQuantity(2);

        Attack attack = TestCardFactory.createAttack("ColorlessAttack", colorlessCost);
        EnergyTotal energyTotal = new EnergyTotal();
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Water));
        assertThat(energyTotal.couldAttackBeUsed(attack)).isTrue();
    }
    @Test
    void attackWith2ColorlessCannotAffortCosts() {
        Cost colorlessCost = new Cost();
        colorlessCost.setType(PokeType.Colorless);
        colorlessCost.setQuantity(2);
        Attack attack = TestCardFactory.createAttack("ColorlessAttack", colorlessCost);
        EnergyTotal energyTotal = new EnergyTotal();
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        assertThat(energyTotal.couldAttackBeUsed(attack)).isFalse();
    }


}