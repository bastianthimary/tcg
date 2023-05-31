package de.my.tcg.collector;

import de.my.tcg.interfaces.TCGDeck;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class TradingDeck implements TCGDeck, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    private List<TradingCard> cardList;

    public TradingDeck() {
    }

    public Long getId() {
        return id;
    }

    public TradingDeck(List<TradingCard> cardList) {
        this.cardList = cardList;
    }

    @Override
    public List<TradingCard> getCards() {
        return cardList;
    }

    @Override
    public int getDecksize() {
        return cardList.size();
    }
}
