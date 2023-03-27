package de.my.tcg.game.mate.card.energycard;

import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.card.EnergyCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class EnergyCardTest {

    @Test
    public void EnergyCardTest(){
        Card wrongType= new Card();
        wrongType.setSupertype(CardTypes.TRAINER);
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            new EnergyCard(new PlayCard(wrongType));
        });

    }
}