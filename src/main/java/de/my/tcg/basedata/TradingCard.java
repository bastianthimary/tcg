package de.my.tcg.basedata;

import de.my.tcg.basedata.card.Card;
import de.my.tcg.interfaces.TCGCard;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TradingCard implements TCGCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    @Getter
    @Setter
    private Card card;


}
