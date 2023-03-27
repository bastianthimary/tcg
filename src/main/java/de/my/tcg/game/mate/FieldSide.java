package de.my.tcg.game.mate;

import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.Subtype;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.domain.Player;
import de.my.tcg.game.mate.card.PokemonCard;

import java.util.List;

public class FieldSide {

    private Player player;
    private PokemonCard activeMon;
    private List<PlayCard> benchMons;

    public void setActiveFromHand(PlayCard cardFromHand) {
        if (isPlayableAsActiveMon(cardFromHand)) {

        }
        if (activeMon == null && cardFromHand.getCard().getSubtypes().contains(Subtype.BASIC)) {
            activeMon = new PokemonCard(cardFromHand);
        } else {
            if (isEvolableToActiveMon(cardFromHand)) {

            } else {

            }
        }
    }

    private boolean isPlayableAsActiveMon(PlayCard cardFromHand) {
        return CardTypes.POKEMON.equals(cardFromHand.getCard().getSupertype());
    }

    private boolean isEvolableToActiveMon(PlayCard cardFromHand) {
        return true;// activeMon.getCard().getName().equals(cardFromHand.getCard().getEvolvesFrom());
    }
}
