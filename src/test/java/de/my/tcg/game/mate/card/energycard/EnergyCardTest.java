package de.my.tcg.game.mate.card.energycard;

import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.game.mate.card.EnergyCard;
import de.my.tcg.mapper.CardPlayCardMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


class EnergyCardTest {
    private final CardPlayCardMapper cardPlayCardMapper = Mappers.getMapper(CardPlayCardMapper.class);

    @Test
    void EnergyCardTest() {
        Card wrongType = new Card();
        wrongType.setSupertype(CardTypes.TRAINER);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new EnergyCard(cardPlayCardMapper.cardToPlayCard(wrongType));
        });

    }
}