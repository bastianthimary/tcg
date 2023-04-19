package de.my.tcg.game;

import de.my.tcg.TestCardFactory;
import de.my.tcg.collector.Person;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.domain.Player;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.NoLegalActionException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TestFieldSideFactory {


    public static FieldSide createFieldSideWithActiveMon(String pokemonName) {
        Person person = mock(Person.class);
        Player player = new Player(person);
        PlayCard activePlaycard = TestCardFactory.createBasicPlayCard(2, pokemonName);
        player.setHandCards(new ArrayList<>(List.of(activePlaycard)));
        try {
            player.playActiveMonFromHand(activePlaycard);
        } catch (NoLegalActionException e) {
            throw new RuntimeException(e);
        }
        return player.getPlayMate();
    }
}
