package de.my.tcg.game.mate.card;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.EnergyTotal;

public class PokemonCard extends FieldCard{

    private int hp;

    private EnergyTotal energyTotal;

    public PokemonCard(PlayCard playCard) {
        this.currentCard = playCard;
        setBaseStatsFromCard();

    }

    private void setBaseStatsFromCard() {
        Card baseCard=currentCard.getCard();
        hp=Integer.getInteger(baseCard.getHp());
    }


}
