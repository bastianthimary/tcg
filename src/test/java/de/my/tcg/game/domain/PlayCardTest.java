package de.my.tcg.game.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.dataimport.json.JSONCardMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayCardTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/domain/playcard/twoPlayCards.csv", numLinesToSkip = 1, delimiter = ';')

    public void twoPlayCards(String json) throws JsonProcessingException {
        Card card = JSONCardMapper.jsonStringToCard(json);
        PlayCard playCard1 = new PlayCard(card);
        PlayCard playCard2 = new PlayCard(card);

        assertThat(playCard1).isNotEqualTo(playCard2);
    }

}