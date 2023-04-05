package de.my.tcg.game.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.my.tcg.TestCardFactory;
import de.my.tcg.collector.Person;
import de.my.tcg.collector.TradingDeck;
import de.my.tcg.dataimport.json.JSONCardMapper;
import de.my.tcg.game.mate.card.NoLegalActionException;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.rules.Competition;
import de.my.tcg.game.rules.GameEndsException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/domain/player/drawSeveralCardsFromDeckToHand.csv", numLinesToSkip = 1)
    void drawSeveralCardsFromDeckToHand(String stringDeckCardDistribution, int expectedDeckSize, int drawNumberOfCards, int expectedDeckSizeAfterDraw, boolean gameLost) {
        final boolean[] isTestLost = {false};
        Competition competition = new Competition() {
            @Override
            public void winTheGame(Player player) {
            }

            @Override
            public void lostTheGame(Player player) {
                isTestLost[0] = true;
                if (!gameLost) {
                    fail("game was wrongly lost");
                }
            }
        };
        Person person = mock(Person.class);
        List<PlayCard> deck = TestCardFactory.generateAPlayDeckFromDistributionString(stringDeckCardDistribution);
        when(person.getChoosenDeck()).thenReturn(new TradingDeck(deck));
        Player player = new Player(person);
        player.setCompetition(competition);
        player.convertPersonsDeckToPlayDeck();
        assertThat(player.getDeckSize()).isEqualTo(expectedDeckSize);
        try {
            player.drawSeveralCardsFromDeckToHand(drawNumberOfCards);
        } catch (GameEndsException e) {
            if (!gameLost) {
                fail("game was wrongly lost");
            }
        }
        assertThat(player.getHandCards().size()).isEqualTo(drawNumberOfCards);
        assertThat(player.getDeckSize()).isEqualTo(expectedDeckSizeAfterDraw);
        assertThat(gameLost).isEqualTo(isTestLost[0]);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/domain/player/evolveActiveMon.csv", numLinesToSkip = 1, delimiter = ';')
    public void evolveActiveMon(boolean isInHand, boolean canEvolve, int expectedHandCardsAfter, String nameAfterEvolution, String jsonHandCard, String jsonActiveMon) throws JsonProcessingException, NoLegalActionException {
        //Setup
        PlayCard handCard = new PlayCard(JSONCardMapper.jsonStringToCard(jsonHandCard));
        PlayCard activeCard = new PlayCard(JSONCardMapper.jsonStringToCard(jsonActiveMon));
        Person person = mock(Person.class);
        Player player = new Player(person);
        player.setHandCards(new ArrayList<>(List.of(activeCard)));
        player.playActiveMonFromHand(activeCard);

        if (isInHand) {
            player.setHandCards(new ArrayList<>(List.of(handCard)));
        }
        try {
            player.evolveActiveMon(handCard);
        } catch (NoLegalActionException e) {
            if (isInHand) {
                if (canEvolve) {
                    fail("");
                } else {
                    assertThat(e.getMessage()).isEqualTo(NoLegalActionException.POKEMON_CANT_EVOLVE_TO_CHOOSEN_POKEMON);
                }

            } else {
                assertThat(e.getMessage()).isEqualTo(NoLegalActionException.CARD_NOT_IN_HAND);
            }
        }

        assertThat(player.getHandCards().size()).isEqualTo(expectedHandCardsAfter);
        assertThat(player.getPlayMate().getActiveMon().getName()).isEqualTo(nameAfterEvolution);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/domain/player/playBenchMonFromHand.csv", numLinesToSkip = 1, delimiter = ';')
    public void playBenchMonFromHand(boolean isInHand, boolean canEvolve, int expectedHandCardsAfter, String nameAfterEvolution, String jsonHandCard, String jsonActiveMon) throws JsonProcessingException, NoLegalActionException {
        //Setup
        PlayCard handCard = new PlayCard(JSONCardMapper.jsonStringToCard(jsonHandCard));
        PlayCard activeCard = new PlayCard(JSONCardMapper.jsonStringToCard(jsonActiveMon));
        Person person = mock(Person.class);
        Player player = new Player(person);
        player.setHandCards(new ArrayList<>(List.of(activeCard)));
        player.playBenchMonFromHand(activeCard);
        PokemonCard benchMon = player.getPlayMate().getBenchMons().get(0);
        if (isInHand) {
            player.setHandCards(new ArrayList<>(List.of(handCard)));

        }
        try {
            player.evolveBenchMon(benchMon, handCard);
        } catch (NoLegalActionException e) {
            if (isInHand) {
                if (canEvolve) {
                    fail("");
                } else {
                    assertThat(e.getMessage()).isEqualTo(NoLegalActionException.POKEMON_CANT_EVOLVE_TO_CHOOSEN_POKEMON);
                }

            } else {
                assertThat(e.getMessage()).isEqualTo(NoLegalActionException.CARD_NOT_IN_HAND);
            }
        }

        assertThat(player.getHandCards().size()).isEqualTo(expectedHandCardsAfter);
        PokemonCard benchMonAfter = player.getPlayMate().getBenchMons().get(0);
        assertThat(benchMonAfter.getName()).isEqualTo(nameAfterEvolution);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/domain/player/playBenchMonFromHand.csv", numLinesToSkip = 1, delimiter = ';')
    public void performRetreat() {

    }

}