package de.my.tcg.game.mate.card.status;

import de.my.tcg.TestCardFactory;
import de.my.tcg.game.mate.card.MonIsDefeatedException;
import de.my.tcg.game.mate.card.PokemonCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class StatusConditionTest {

    @Test
    void healAllStates() {
        PokemonCard pokemonCard = mock(PokemonCard.class);
        StatusCondition statusCondition = new StatusCondition(pokemonCard);
        statusCondition.setSpecialCondition(SpecialCondition.PARALYZED);
        statusCondition.setFireConditionState(FireCondition.SINGLE);
        statusCondition.setPoisonConditionState(PoisonCondition.SINGLE);
        assertThat(statusCondition.getSpecialCondition()).isEqualTo(SpecialCondition.PARALYZED);
        statusCondition.healAllStates();
        assertThat(statusCondition.getSpecialCondition()).isEqualTo(SpecialCondition.NO_STATUS);


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/status/statuscondition/turnEnds.csv", numLinesToSkip = 1)
    void turnEnds(SpecialCondition specialConditionBefore, SpecialCondition specialConditionAfter,
                  FireCondition fireCondition, PoisonCondition poisonCondition, String hpBefore, int expectedDmg, boolean exceptionExpected) {
        PokemonCard pokemonCard = TestCardFactory.createPokemonCard(hpBefore);
        StatusCondition statusCondition = new StatusCondition(pokemonCard);
        statusCondition.setSpecialCondition(specialConditionBefore);
        statusCondition.setFireConditionState(fireCondition);
        statusCondition.setPoisonConditionState(poisonCondition);
        try {
            statusCondition.turnEnds();
            assertThat(exceptionExpected).isFalse();
        } catch (MonIsDefeatedException e) {
            assertThat(exceptionExpected).isTrue();
        }
        assertThat(statusCondition.getSpecialCondition()).isEqualTo(specialConditionAfter);
        assertThat(statusCondition.getPoisonConditionState()).isEqualTo(poisonCondition);
        assertThat(pokemonCard.getDmgCounter()).isEqualTo(expectedDmg);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/status/statuscondition/statusAllowsAttack.csv", numLinesToSkip = 1)
    void statusAllowsAttack(SpecialCondition specialCondition, FireCondition fireCondition, PoisonCondition poisonCondition, boolean expected) throws MonIsDefeatedException {

        PokemonCard pokemonCard = mock(PokemonCard.class);
        StatusCondition statusCondition = new StatusCondition(pokemonCard);
        statusCondition.setSpecialCondition(specialCondition);
        statusCondition.setFireConditionState(fireCondition);
        statusCondition.setPoisonConditionState(poisonCondition);
        assertThat(statusCondition.statusAllowsAttack()).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/status/statuscondition/statusAllowsRetreat.csv", numLinesToSkip = 1)
    void statusAllowsRetreat(SpecialCondition specialCondition, FireCondition fireCondition, PoisonCondition poisonCondition, boolean expected) {
        PokemonCard pokemonCard = mock(PokemonCard.class);
        StatusCondition statusCondition = new StatusCondition(pokemonCard);
        statusCondition.setSpecialCondition(specialCondition);
        statusCondition.setFireConditionState(fireCondition);
        statusCondition.setPoisonConditionState(poisonCondition);
        assertThat(statusCondition.statusAllowsRetreat()).isEqualTo(expected);
    }
}