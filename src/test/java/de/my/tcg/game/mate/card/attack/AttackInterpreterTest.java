package de.my.tcg.game.mate.card.attack;

import de.my.tcg.game.coin.Coin;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class AttackInterpreterTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/card/attack/attackinterpreter/stringToActualDmg.csv", numLinesToSkip = 1)
    void stringToActualDmg(String dmgAsString, String attackString, int dmgPer, boolean expectCoinFlip) {

        int dmg = new AttackInterpreter().stringToActualDmg(dmgAsString, attackString);
        if (expectCoinFlip) {
            assertThat(dmg).isEqualTo(Coin.headcount * dmgPer);
        }


    }
}