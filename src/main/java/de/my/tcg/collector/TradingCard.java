package de.my.tcg.collector;

import de.my.tcg.basedata.Ability;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.cardset.CardSet;
import de.my.tcg.basedata.images.Images;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.basedata.rarity.Rarity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TradingCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    @Getter
    @Setter
    private Card card;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Set<String> subtypes = new HashSet<>();
    @Getter
    @Setter
    private String level;
    @Getter
    @Setter
    private String hp;
    @Getter
    @Setter
    private PokeType type;
    @Getter
    @Setter
    private String evolvesFrom;

    @OneToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<Ability> abilities = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<Attack> attacks = new HashSet<>();

    @Enumerated(EnumType.ORDINAL)
    @Getter
    @Setter
    private PokeType weaknesses;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private PokeType resistances;
    @Getter
    @Setter
    private Integer convertedRetreatCost;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private CardSet cardSet;
    @Getter
    @Setter
    private String artist;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Rarity rarity;

    @Column(length = 1024)
    @Getter
    @Setter
    private String flavorText;
    @Getter
    @Setter
    private Set<Integer> nationalPokedexNumbers = new HashSet<>();
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    private Images images;

}
