package de.my.tcg.game.domain;

import de.my.tcg.basedata.Ability;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.poketype.PokeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class PlayCard implements Serializable {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private CardTypes supertype;
    @Getter
    @Setter
    private Set<String> subtypes = new HashSet<>();
    @Getter
    @Setter
    private String hp;
    @Getter
    @Setter
    private Set<String> types = new HashSet<>();
    @Getter
    @Setter
    private String evolvesFrom;
    @Getter
    @Setter
    private Set<Ability> abilities = new HashSet<>();
    @Getter
    @Setter
    private Set<Attack> attacks = new HashSet<>();
    @Getter
    @Setter
    private PokeType weaknesses;
    @Getter
    @Setter
    private PokeType resistances;
    @Getter
    @Setter
    private Integer convertedRetreatCost;


}
