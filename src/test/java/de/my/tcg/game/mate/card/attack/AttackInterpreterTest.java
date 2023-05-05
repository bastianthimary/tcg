package de.my.tcg.game.mate.card.attack;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.game.TestFieldSideFactory;
import de.my.tcg.game.coin.Coin;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.status.SpecialCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class AttackInterpreterTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/MultiplyDmg.csv", numLinesToSkip = 1)
    void MultiplyDmg(String dmgAsString, String attackString, int dmgPer, boolean expectCoinFlip,
                     String myPokemonName, SpecialCondition myCondition, SpecialCondition defendingPokemonCondition) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        if (expectCoinFlip) {
            assertThat(defendingPokemon.getDmgCounter()).isEqualTo(Coin.headcount * dmgPer);
            Coin.headcount = 0;
        }
        assertThat(attackingPokemon.getStatusCondition().getSpecialCondition()).isEqualTo(myCondition);
        assertThat(defendingPokemon.getStatusCondition().getSpecialCondition()).isEqualTo(defendingPokemonCondition);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/attackWithEffect.csv", numLinesToSkip = 1)
    void attackWithEffect(String dmgAsString, String attackString, int dmgPer, boolean expectCoinFlipForMy,
                          String myPokemonName, SpecialCondition myCondition, boolean expectCoinFlipForDefending, SpecialCondition defendingPokemonCondition) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmgPer);
        if (expectCoinFlipForMy) {
            if (Coin.headcount == 1) {
                assertThat(attackingPokemon.getStatusCondition().getSpecialCondition()).isEqualTo(myCondition);
            } else {

                assertThat(attackingPokemon.getStatusCondition().getSpecialCondition()).isEqualTo(SpecialCondition.NO_STATUS);
            }
            Coin.headcount = 0;
        } else {
            assertThat(attackingPokemon.getStatusCondition().getSpecialCondition()).isEqualTo(myCondition);
        }
        if (expectCoinFlipForDefending) {
            if (Coin.headcount == 1) {
                System.out.println("was head");
                assertThat(defendingPokemon.getStatusCondition().getSpecialCondition()).isEqualTo(defendingPokemonCondition);
            } else {
                System.out.println("was tails");
                assertThat(defendingPokemon.getStatusCondition().getSpecialCondition()).isEqualTo(SpecialCondition.NO_STATUS);
            }
            Coin.headcount = 0;
        } else {
            assertThat(defendingPokemon.getStatusCondition().getSpecialCondition()).isEqualTo(defendingPokemonCondition);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/hurtEffect.csv", numLinesToSkip = 1)
    void hurtEffect(String dmgAsString, String attackString, int dmgTo, int hurtDmg, boolean expectCoinFlipForMy, String myPokemonName) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmgTo);
        if (expectCoinFlipForMy) {
            if (Coin.headcount == 1) {
                System.out.println("was head");
                assertThat(attackingPokemon.getDmgCounter()).isZero();
            } else {
                System.out.println("was tails");
                assertThat(attackingPokemon.getDmgCounter()).isEqualTo(hurtDmg);
            }
            Coin.headcount = 0;
        } else {
            assertThat(attackingPokemon.getDmgCounter()).isEqualTo(hurtDmg);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/benchDmgEffect.csv", numLinesToSkip = 1)
    void benchDmgEffect(String dmgAsString, String attackString, int dmgTo, int hurtDmg, String myPokemonName, int benchDmg) {
        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");


        List<PlayCard> myBenchMons = TestCardFactory.createANumberOfPokemonPlayCards(5);
        myBenchMons.forEach(myFieldSide::playBenchMonFromHand);
        List<PlayCard> opponentBenchMons = TestCardFactory.createANumberOfPokemonPlayCards(5);
        opponentBenchMons.forEach(opponentFieldSide::playBenchMonFromHand);
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(dmgTo);
        assertThat(attackingPokemon.getDmgCounter()).isEqualTo(hurtDmg);

        myFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isEqualTo(benchDmg));
        opponentFieldSide.getBenchMons().forEach(pokemonCard -> assertThat(pokemonCard.getDmgCounter()).isEqualTo(benchDmg));

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/additionalDmg.csv", numLinesToSkip = 1)
    void additionalDmg(String dmgAsString, String attackString, int expectedDmg, String energyCardsAsString,
                       String costtype, int costqty, String myPokemonName) {


        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        PokemonCard myPokemon = myFieldSide.getActiveMon();
        EnergyTotal energyTotal = myPokemon.getEnergyTotal();
        TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                forEach(energyTotal::addEnergyCard);
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage(dmgAsString);
        Cost cost1 = new Cost(costtype, costqty);
        attack.setCost(Set.of(cost1));
        attack.setConvertedEnergyCost(costqty);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();

        PokemonCard defendingPokemon = opponentFieldSide.getActiveMon();
        assertThat(defendingPokemon.getDmgCounter()).isEqualTo(expectedDmg);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/discardEnergy.csv", numLinesToSkip = 1)
    void discardEnergy(String attackString, String energyCardsAsString, int energyBefore, int energyAfter, String myPokemonName) {

        FieldSide myFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon(myPokemonName);
        FieldSide opponentFieldSide = TestFieldSideFactory.createFieldSideWithActiveMon("opponent");
        Attack attack = new Attack();
        attack.setText(attackString);
        attack.setDamage("20");
        PokemonCard attackingPokemon = myFieldSide.getActiveMon();
        EnergyTotal energyTotal = attackingPokemon.getEnergyTotal();
        TestCardFactory.convertStringToEnergyCardList(energyCardsAsString).
                forEach(energyTotal::addEnergyCard);
        assertThat(attackingPokemon.getEnergyTotal().getTotalEnergy()).isEqualTo(energyBefore);
        AttackInterpreter attackInterpreter = new AttackInterpreter(attack, myFieldSide, opponentFieldSide);
        attackInterpreter.performAttack();
        assertThat(attackingPokemon.getEnergyTotal().getTotalEnergy()).isEqualTo(energyAfter);
    }

}