package de.my.tcg;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.Subtype;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.card.EnergyCard;
import de.my.tcg.game.mate.card.PokemonCard;

import java.util.*;

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
        card.setConvertedRetreatCost(0);
        return new PokemonCard(new PlayCard(card));
    }

    public static PokemonCard createPokemonCard(String hp) {
        Card card = new Card();
        card.setHp(hp);
        card.setConvertedRetreatCost(0);
        card.setSupertype(CardTypes.POKEMON);
        return new PokemonCard(new PlayCard(card));
    }

    public static PlayCard createBasicPlayCard(int retreatCosts, String name) {
        Card card = new Card();
        card.setName(name);
        card.setHp("100");
        card.setConvertedRetreatCost(retreatCosts);
        card.setSubtypes(Set.of(Subtype.BASIC));
        card.setSupertype(CardTypes.POKEMON);
        return new PlayCard(card);
    }

    public static Attack createAttack(String name, Cost... costs) {
        Attack attack = new Attack();
        attack.setName(name);
        attack.setCost(new HashSet<>(Arrays.asList(costs)));
        return attack;
    }

    public static List<PokeType> convertStringToPokeTypeList(String energyCardsAsString) {
        return Arrays.stream(energyCardsAsString.replace("[", "").replace("]", "").split(";")).filter(s -> !s.isBlank())
                .map(PokeType::valueOf).toList();
    }

    public static List<EnergyCard> convertStringToEnergyCardList(String energyCardsAsString) {
        return convertStringToPokeTypeList(energyCardsAsString).
                stream().map(TestCardFactory::createEnergyCard).toList();
    }

    public static List<PlayCard> generateAPlayDeckFromDistributionString(String distributionString) {
        List<Integer> distribtion = Arrays.stream(distributionString.replace("[", "").replace("]", "").split(";"))
                .filter(s -> !s.isBlank()).map(Integer::parseInt).toList();
        Integer numberOfPokemon = distribtion.get(0);
        Integer numberOfTrainer = distribtion.get(1);
        Integer numberOfEnergyCards = distribtion.get(2);
        List<PlayCard> deck = new ArrayList<>();
        deck.addAll(createANumberOfPokemonPlayCards(numberOfPokemon));
        deck.addAll(createANumberOfTrainerPlayCards(numberOfTrainer));
        deck.addAll(createANumberOfEnergyPlayCards(numberOfEnergyCards));
        return deck;
    }


    public static List<PlayCard> createANumberOfPokemonPlayCards(int numberOfPokemon) {
        List<PlayCard> pokemonPlayCards = new ArrayList<>();
        for (int i = 0; i < numberOfPokemon; i++) {
            Card card = new Card();
            card.setHp("90");
            card.setConvertedRetreatCost(0);
            card.setSubtypes(Set.of(Subtype.BASIC));
            card.setSupertype(CardTypes.POKEMON);
            card.setName("pokemon " + i);
            pokemonPlayCards.add(new PlayCard(card));
        }
        return pokemonPlayCards;
    }

    public static List<PlayCard> createANumberOfTrainerPlayCards(int numberOfTrainer) {
        List<PlayCard> trainerPlayCards = new ArrayList<>();
        for (int i = 0; i < numberOfTrainer; i++) {
            Card card = new Card();
            card.setSupertype(CardTypes.TRAINER);
            card.setName("trainer " + i);
            trainerPlayCards.add(new PlayCard(card));
        }
        return trainerPlayCards;
    }

    private static List<PlayCard> createANumberOfEnergyPlayCards(Integer numberOfTrainer) {
        List<PlayCard> energyPlayCards = new ArrayList<>();
        for (int i = 0; i < numberOfTrainer; i++) {
            Card card = new Card();
            card.setSupertype(CardTypes.ENERGY);
            card.setName("Fire Energy");
            energyPlayCards.add(new PlayCard(card));
        }
        return energyPlayCards;
    }
}
