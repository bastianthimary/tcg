package de.my.tcg.market.booster;

import de.my.tcg.domain.card.Card;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Booster implements Serializable {
    private Set<Card> cards;

    public Booster() {
        this.cards= new HashSet<>();
    }

    public void addCard(Card addCard){
        cards.add(addCard);
    }
    public void addAllCards(Set<Card> addCards){
        cards.addAll(addCards);
    }

    public Set<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer= new StringBuffer();
        cards.forEach(card -> stringBuffer.append(card.toString()));
        return "Booster{" +
                "cards=" +stringBuffer+
                '}';
    }
}
