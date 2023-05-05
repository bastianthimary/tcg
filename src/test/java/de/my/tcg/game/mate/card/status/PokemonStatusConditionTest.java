package de.my.tcg.game.mate.card.status;

import de.my.tcg.TestCardFactory;
import de.my.tcg.game.mate.card.MonIsDefeatedException;
import de.my.tcg.game.mate.card.PokemonCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class PokemonStatusConditionTest {

    @Test
    void healAllStates() {
        PokemonCard pokemonCard = mock(PokemonCard.class);
        PokemonStatusCondition pokemonStatusCondition = new PokemonStatusCondition(pokemonCard);
        pokemonStatusCondition.setSpecialCondition(SpecialCondition.PARALYZED);
        pokemonStatusCondition.setFireConditionState(FireCondition.SINGLE);
        pokemonStatusCondition.setPoisonConditionState(PoisonCondition.SINGLE);
        assertThat(pokemonStatusCondition.getSpecialCondition()).isEqualTo(SpecialCondition.PARALYZED);
        pokemonStatusCondition.healAllStates();
        assertThat(pokemonStatusCondition.getSpecialCondition()).isEqualTo(SpecialCondition.NO_STATUS);


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/status/statuscondition/turnEnds.csv", numLinesToSkip = 1)
    void turnEnds(SpecialCondition specialConditionBefore, SpecialCondition specialConditionAfter,
                  FireCondition fireCondition, PoisonCondition poisonCondition, String hpBefore, int expectedDmg, boolean exceptionExpected) {
        PokemonCard pokemonCard = TestCardFactory.createPokemonCard(hpBefore);
        PokemonStatusCondition pokemonStatusCondition = new PokemonStatusCondition(pokemonCard);
        pokemonStatusCondition.setSpecialCondition(specialConditionBefore);
        pokemonStatusCondition.setFireConditionState(fireCondition);
        pokemonStatusCondition.setPoisonConditionState(poisonCondition);
        try {
            pokemonStatusCondition.turnEnds();
            assertThat(exceptionExpected).isFalse();
        } catch (MonIsDefeatedException e) {
            assertThat(exceptionExpected).isTrue();
        }
        assertThat(pokemonStatusCondition.getSpecialCondition()).isEqualTo(specialConditionAfter);
        assertThat(pokemonStatusCondition.getPoisonConditionState()).isEqualTo(poisonCondition);
        assertThat(pokemonCard.getDmgCounter()).isEqualTo(expectedDmg);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/status/statuscondition/statusAllowsAttack.csv", numLinesToSkip = 1)
    void statusAllowsAttack(SpecialCondition specialCondition, FireCondition fireCondition, PoisonCondition poisonCondition, boolean expected) throws MonIsDefeatedException {

        PokemonCard pokemonCard = mock(PokemonCard.class);
        PokemonStatusCondition pokemonStatusCondition = new PokemonStatusCondition(pokemonCard);
        pokemonStatusCondition.setSpecialCondition(specialCondition);
        pokemonStatusCondition.setFireConditionState(fireCondition);
        pokemonStatusCondition.setPoisonConditionState(poisonCondition);
        assertThat(pokemonStatusCondition.statusAllowsAttack()).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/card/status/statuscondition/statusAllowsRetreat.csv", numLinesToSkip = 1)
    void statusAllowsRetreat(SpecialCondition specialCondition, FireCondition fireCondition, PoisonCondition poisonCondition, boolean expected) {
        PokemonCard pokemonCard = mock(PokemonCard.class);
        PokemonStatusCondition pokemonStatusCondition = new PokemonStatusCondition(pokemonCard);
        pokemonStatusCondition.setSpecialCondition(specialCondition);
        pokemonStatusCondition.setFireConditionState(fireCondition);
        pokemonStatusCondition.setPoisonConditionState(poisonCondition);
        assertThat(pokemonStatusCondition.statusAllowsRetreat()).isEqualTo(expected);
    }
}