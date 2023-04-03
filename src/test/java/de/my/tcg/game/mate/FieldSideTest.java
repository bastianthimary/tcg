package de.my.tcg.game.mate;

import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.Subtype;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.card.NoLegalActionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class FieldSideTest {

    @Test
    public void playActiveFromHand() {
        Card trainerCard = new Card();
        trainerCard.setSupertype(CardTypes.TRAINER);

        PlayCard trainerPlayCard = new PlayCard(trainerCard);
        FieldSide trainerFieldSide = new FieldSide();
        try {
            trainerFieldSide.playActiveFromHand(trainerPlayCard);
            Assertions.fail("Exception Expected");
        } catch (NoLegalActionException e) {
            assertThat(e.getMessage()).isEqualTo(NoLegalActionException.CARD_CANT_PLAYED_AS_POKEMON);
        }


        Card stage1Card = new Card();
        stage1Card.setSupertype(CardTypes.POKEMON);
        stage1Card.setSubtypes(Set.of(Subtype.STAGE_1));

        PlayCard stage1PlayCard = new PlayCard(stage1Card);
        FieldSide stage1FieldSide = new FieldSide();
        try {
            stage1FieldSide.playActiveFromHand(stage1PlayCard);
            Assertions.fail("Exception Expected");
        } catch (NoLegalActionException e) {
            assertThat(e.getMessage()).isEqualTo(NoLegalActionException.CARD_CANT_PLAYED_AS_POKEMON);
        }

        Card baseCard = new Card();
        baseCard.setName("Basemon");
        baseCard.setSupertype(CardTypes.POKEMON);
        baseCard.setSubtypes(Set.of(Subtype.BASIC));
        baseCard.setConvertedRetreatCost(0);
        baseCard.setHp("10");


        PlayCard basePlayCard = new PlayCard(baseCard);
        FieldSide baseFieldSide = new FieldSide();
        try {
            baseFieldSide.playActiveFromHand(basePlayCard);
        } catch (NoLegalActionException e) {
            fail("No Execption Expected");
        }
        assertThat(baseFieldSide.getActiveMon().getName()).isEqualTo("Basemon");


        Card base2Card = new Card();
        base2Card.setSupertype(CardTypes.POKEMON);
        base2Card.setSubtypes(Set.of(Subtype.BASIC));
        base2Card.setHp("10");
        PlayCard base2PlayCard = new PlayCard(base2Card);


        try {
            baseFieldSide.playActiveFromHand(base2PlayCard);
            Assertions.fail("Exception Expected");
        } catch (NoLegalActionException e) {
            assertThat(e.getMessage()).isEqualTo(NoLegalActionException.CARD_CANT_PLAYED_AS_POKEMON);
        }
        assertThat(baseFieldSide.getActiveMon().getName()).isEqualTo("Basemon");
    }


}