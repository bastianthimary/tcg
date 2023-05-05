package de.my.tcg.game.mate.card.retreat;

import de.my.tcg.TestCardFactory;
import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.mate.card.status.SpecialCondition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RetreatCheckerTest {
    @Test
    void fieldCanNotRetreatDueEmptyBench() {

        FieldSide playMate = mock(FieldSide.class);
        when(playMate.getBenchMons()).thenReturn(new ArrayList<>());

        PerformRetreatState retreatResponse = RetreatChecker.checkFieldHasNegativeResponse(playMate, null);
        assertThat(retreatResponse).isEqualTo(PerformRetreatState.CAN_NOT_RETREAT_DUE_TO_EMPTY_BENCH);
    }

    @Test
    void selectedBenchMonIsNotThere() {
        Card card = new Card();
        card.setSupertype(CardTypes.POKEMON);
        card.setName("notInBench");
        card.setHp("10");
        card.setConvertedRetreatCost(1);
        PokemonCard pokemonCard = new PokemonCard(new PlayCard(card));
        FieldSide playMate = mock(FieldSide.class);
        when(playMate.getBenchMons()).thenReturn(TestCardFactory.createANumberOfPokemonPlayCards(5).stream().
                map(PokemonCard::new).toList());

        PerformRetreatState retreatResponse = RetreatChecker.checkFieldHasNegativeResponse(playMate, pokemonCard);
        assertThat(retreatResponse).isEqualTo(PerformRetreatState.SELECTED_BENCHMON_IS_NOT_THERE);
    }

    @Test
    void canNotRetreatDueToStatusCondition() {
        Card card = new Card();
        card.setSupertype(CardTypes.POKEMON);
        card.setName("InBench");
        card.setHp("10");
        card.setConvertedRetreatCost(1);
        PokemonCard benchMonToExchange = new PokemonCard(new PlayCard(card));

        PokemonCard activeMon = TestCardFactory.createPokemonCard("30");
        activeMon.getPokemonStatusCondition().setSpecialCondition(SpecialCondition.ASLEEP);
        FieldSide playMate = mock(FieldSide.class);

        when(playMate.getBenchMons()).thenReturn(new ArrayList<>(List.of(benchMonToExchange)));
        when(playMate.getActiveMon()).thenReturn(activeMon);

        PerformRetreatState retreatResponse = RetreatChecker.checkFieldHasNegativeResponse(playMate, benchMonToExchange);
        assertThat(retreatResponse).isEqualTo(PerformRetreatState.CAN_NOT_RETREAT_DUE_TO_STATUSCONDITION);
    }

    @Test
    void checkFieldHasNoNegativeResponse() {
        Card card = new Card();
        card.setSupertype(CardTypes.POKEMON);
        card.setName("InBench");
        card.setHp("10");
        card.setConvertedRetreatCost(1);
        PokemonCard benchMonToExchange = new PokemonCard(new PlayCard(card));

        PokemonCard activeMon = TestCardFactory.createPokemonCard("30");
        FieldSide playMate = mock(FieldSide.class);

        when(playMate.getBenchMons()).thenReturn(new ArrayList<>(List.of(benchMonToExchange)));
        when(playMate.getActiveMon()).thenReturn(activeMon);

        PerformRetreatState retreatResponse = RetreatChecker.checkFieldHasNegativeResponse(playMate, benchMonToExchange);
        assertThat(retreatResponse).isNull();
    }
}