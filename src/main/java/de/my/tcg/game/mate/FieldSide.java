package de.my.tcg.game.mate;

import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.Subtype;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.domain.Player;
import de.my.tcg.game.mate.card.NoLegalActionException;
import de.my.tcg.game.mate.card.PokemonCard;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static de.my.tcg.game.mate.card.NoLegalActionException.BENCH_IS_FULL;
import static de.my.tcg.game.mate.card.NoLegalActionException.CARD_CANT_PLAYED_AS_POKEMON;

public class FieldSide {
    @Getter
    private Player player;
    @Getter
    private PokemonCard activeMon;
    private final List<PokemonCard> benchMons;

    private final List<PlayCard> discardPile;

    //Only For Test
    public FieldSide() {
        benchMons = new ArrayList<>();
        discardPile = new ArrayList<>();
    }

    public FieldSide(Player player) {
        this.player = player;
        benchMons = new ArrayList<>();
        discardPile = new ArrayList<>();
    }


    public void playActiveFromHand(PlayCard cardFromHand) throws NoLegalActionException {
        if (isPlayableAsPokemonCard(cardFromHand)) {
            if (activeMon == null && cardFromHand.getCard().getSubtypes().contains(Subtype.BASIC.toString())) {
                activeMon = new PokemonCard(cardFromHand);
            } else {
                throw new NoLegalActionException(CARD_CANT_PLAYED_AS_POKEMON);
            }
        } else {
            throw new NoLegalActionException(CARD_CANT_PLAYED_AS_POKEMON);
        }
    }

    private boolean isPlayableAsPokemonCard(PlayCard cardFromHand) {
        return CardTypes.POKEMON.equals(cardFromHand.getCard().getSupertype());
    }

    public boolean canFieldCardEvolveToCardFromHand(PokemonCard fieldCard, PlayCard cardFromHand) {
        if (isPlayableAsPokemonCard(cardFromHand)) {
            return fieldCard.getName().equals(cardFromHand.getCard().getEvolvesFrom());
        }
        return false;
    }

    public void evolveActiveMon(PlayCard cardFromHand) throws NoLegalActionException {
        if (canFieldCardEvolveToCardFromHand(activeMon, cardFromHand)) {
            activeMon.evolvePokemon(cardFromHand);
        } else {
            throw new NoLegalActionException(NoLegalActionException.POKEMON_CANT_EVOLVE_TO_CHOOSEN_POKEMON);
        }
    }

    public boolean canBenchMonPlayed(PlayCard cardFromHand) {
        return isPlayableAsPokemonCard(cardFromHand) && benchMons.size() <= 5;
    }

    public void playBenchMonFromHand(PlayCard cardFromHand) throws NoLegalActionException {
        if (isPlayableAsPokemonCard(cardFromHand)) {
            if (canBenchMonPlayed(cardFromHand)) {
                benchMons.add(new PokemonCard(cardFromHand));
            } else {
                throw new NoLegalActionException(BENCH_IS_FULL);
            }
        } else {
            throw new NoLegalActionException(CARD_CANT_PLAYED_AS_POKEMON);
        }
    }

    public List<PokemonCard> getEvolveableMonsFromBench(PlayCard evolutionCard) {
        return benchMons.stream().filter(fieldCard -> canFieldCardEvolveToCardFromHand(fieldCard, evolutionCard)).toList();
    }

    public boolean canActiveMonEvolveToCardFromHand(PlayCard handCard) {
        return canFieldCardEvolveToCardFromHand(activeMon, handCard);
    }

    public void evolveBenchMon(PokemonCard benchMon, PlayCard evolutionCard) throws NoLegalActionException {
        if (benchMons.contains(benchMon) && canFieldCardEvolveToCardFromHand(benchMon, evolutionCard)) {
            benchMon.evolvePokemon(evolutionCard);
        } else {
            throw new NoLegalActionException(NoLegalActionException.POKEMON_CANT_EVOLVE_TO_CHOOSEN_POKEMON);
        }
    }

    public void addCardToDiscardPile(PlayCard card) {
        discardPile.add(card);
    }

    public void addCardToDiscardPile(List<PlayCard> cards) {
        discardPile.addAll(cards);
    }

}
