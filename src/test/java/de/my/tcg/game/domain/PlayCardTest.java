package de.my.tcg.game.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.dataimport.json.JSONCardMapper;
import de.my.tcg.mapper.CardPlayCardMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class PlayCardTest {
    private final CardPlayCardMapper cardPlayCardMapper = Mappers.getMapper(CardPlayCardMapper.class);

    @ParameterizedTest
    @CsvFileSource(resources = "/domain/playcard/twoPlayCards.csv", numLinesToSkip = 1, delimiter = ';')
    void twoPlayCards(String json) throws JsonProcessingException {
        Card card = JSONCardMapper.jsonStringToCard(json);
        PlayCard playCard1 = cardPlayCardMapper.cardToPlayCard(card);
        PlayCard playCard2 = cardPlayCardMapper.cardToPlayCard(card);

        assertThat(playCard1).isNotEqualTo(playCard2);
    }

}