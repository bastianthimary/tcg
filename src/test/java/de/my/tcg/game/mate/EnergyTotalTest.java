package de.my.tcg.game.mate;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.card.EnergyCard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnergyTotalTest {
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

    @Test
    public void removeAllEnergyCards() {
        EnergyTotal energyTotal = new EnergyTotal();
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Grass));
        assertThat(energyTotal.getTotalEnergy()).isEqualTo(3);
        assertThat(energyTotal.removeAllEnergys().size()).isEqualTo(3);
        assertThat(energyTotal.getTotalEnergy()).isEqualTo(0);
    }

    @Test
    public void removeNumberOfEnergytype() {
        EnergyTotal energyTotal = new EnergyTotal();
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Fire));
        energyTotal.addEnergyCard(TestCardFactory.createEnergyCard(PokeType.Grass));

        energyTotal.removeNumberOfEnergytype(2, PokeType.Fire);
        assertThat(energyTotal.getTotalEnergy()).isEqualTo(3);
    }
}