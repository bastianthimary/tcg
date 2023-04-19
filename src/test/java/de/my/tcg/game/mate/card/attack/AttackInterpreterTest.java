package de.my.tcg.game.mate.card.attack;

import de.my.tcg.basedata.Attack;
import de.my.tcg.game.TestFieldSideFactory;
import de.my.tcg.game.coin.Coin;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.status.SpecialCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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
        }


    }
}