package de.my.tcg;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.card.EnergyCard;
import de.my.tcg.game.mate.card.PokemonCard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestCardFactory {

    public static EnergyCard createEnergyCard(PokeType type) {
        Card card = new Card();
        card.setSupertype(CardTypes.ENERGY);
        if (PokeType.Colorless.equals(type)) {
            card.setName("Double " + type.getTypeName() + " Energy");
        } else {
            card.setName(type.getTypeName() + " Energy");
        }
        return new EnergyCard(new PlayCard(card));
    }

    public static PokemonCard createPokemonCard() {
        Card card = new Card();
        card.setSupertype(CardTypes.POKEMON);
        return new PokemonCard(new PlayCard(card));
    }

    public static Attack createAttack(String name, Cost... costs) {
        Attack attack = new Attack();
        attack.setName(name);
        attack.setCost(new HashSet<>(Arrays.asList(costs)));
        return attack;
    }

    public static List<PokeType> convertStringToPokeTypeList(String energyCardsAsString) {
        return Arrays.stream(energyCardsAsString.replace("[", "").replace("]", "").split(";"))
                .map(PokeType::valueOf).toList();
    }

    public static List<EnergyCard> convertStringToEnergyCardList(String energyCardsAsString) {
        return convertStringToPokeTypeList(energyCardsAsString).
                stream().map(e -> createEnergyCard(e)).toList();
    }
}
