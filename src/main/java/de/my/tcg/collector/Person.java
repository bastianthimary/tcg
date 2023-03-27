package de.my.tcg.collector;

import de.my.tcg.basedata.TradingCard;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Person")

public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private Set<TradingCard> cardCollection;

    private Set<TradingDeck> tradingDecksCollection;
    private TradingDeck choosenDeck;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCardToCollection(TradingCard card){
        cardCollection.add(card);

    }
    public Set<TradingCard> getCardCollection() {
        return cardCollection;
    }

    public void setCardCollection(Set<TradingCard> cardCollection) {
        this.cardCollection = cardCollection;
    }

    public Set<TradingDeck> getTradingDecksCollection() {
        return tradingDecksCollection;
    }

    public void setTradingDecksCollection(Set<TradingDeck> tradingDecksCollection) {
        this.tradingDecksCollection = tradingDecksCollection;
    }

    public TradingDeck getChoosenDeck() {
        return choosenDeck;
    }

    public void setChoosenDeck(TradingDeck choosenDeck) {
        this.choosenDeck = choosenDeck;
    }
}
