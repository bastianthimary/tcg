package de.my.tcg;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.card.EnergyCard;

import java.util.Set;

public class TestCardFactory {

    public static EnergyCard createEnergyCard(PokeType type){
        Card card= new Card();
        card.setSupertype(CardTypes.ENERGY);
        if (PokeType.Colorless.equals(type)) {
            card.setName("Double " + type.getTypeName() + " Energy");
        } else {
            card.setName(type.getTypeName() + " Energy");
        }
        return new EnergyCard(new PlayCard(card));

    }



    public static Attack createAttack(String name, Set<Cost> costs){
        Attack attack = new Attack();
        attack.setName(name);
        attack.setCost(costs);
        return attack;
    }
}
