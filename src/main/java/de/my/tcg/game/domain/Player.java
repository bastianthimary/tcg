package de.my.tcg.game.domain;

import de.my.tcg.collector.Person;
import de.my.tcg.game.mate.FieldSide;
import de.my.tcg.game.mate.card.NoLegalActionException;
import de.my.tcg.game.mate.card.PokemonCard;
import de.my.tcg.game.rules.Competition;
import de.my.tcg.game.rules.TradingDeckToPlayDeckConverter;
import de.my.tcg.game.rules.exception.ExceptionMessage;
import de.my.tcg.game.rules.exception.GameException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    @Getter
    private final Person person;
    private PlayDeck playdeck;
    @Setter
    @Getter
    private Player opponent;
    @Setter
    @Getter
    private List<PlayCard> handCards = new ArrayList<>();
    @Setter
    @Getter
    private Competition competition;
    @Getter
    private final FieldSide playMate;

    private final List<PlayCard> priceCards = new ArrayList<>();

    public Player(Person person) {
        this.person = person;
        playMate = new FieldSide(this);
    }


    public void convertPersonsDeckToPlayDeck() {
        this.handCards = new ArrayList<>();
        this.playdeck = TradingDeckToPlayDeckConverter.convertTradingToPlayDeck(person.getChoosenDeck());
    }

    public void drawSeveralCardsFromDeckToHand(int draws) {
        if (draws > 0) {
            for (int i = 0; i < draws; i++) {
                convertPersonsDeckToPlayDeck();
                drawACardFromDeckToHand();
            }
        }
    }

    public void drawACardFromDeckToHand() {
        handCards.add(drawACardFromDeck());
    }

    public void setupPriceCards(int numberOfPrices) {
        for (int i = 0; i < numberOfPrices; i++) {
            priceCards.add(drawACardFromDeck());
        }
    }

    private PlayCard drawACardFromDeck() {
        List<PlayCard> deckCards = playdeck.cardList;
        if (deckCards.size() == 0) {
            competition.lostTheGame(this);
        }
        int size = deckCards.size();
        int drawIndex = new Random().nextInt(size);
        return deckCards.remove(drawIndex);
    }

    public void evolveActiveMon(PlayCard handCard) throws NoLegalActionException {
        checkIsCardInHand(handCard);
        if (playMate.canActiveMonEvolveToCardFromHand(handCard)) {
            playMate.evolveActiveMon(handCard);
            handCards.remove(handCard);
        } else {
            throw new NoLegalActionException(NoLegalActionException.POKEMON_CANT_EVOLVE_TO_CHOOSEN_POKEMON);
        }
    }

    public void playActiveMonFromHand(PlayCard handCard) throws NoLegalActionException {
        checkIsCardInHand(handCard);
        playMate.playActiveFromHand(handCard);
        handCards.remove(handCard);
    }

    private void checkIsCardInHand(PlayCard handCard) {
        if (!handCards.contains(handCard)) {
            throw new GameException(ExceptionMessage.CARD_NOT_IN_HAND);
        }
    }

    public void playBenchMonFromHand(PlayCard handCard) throws NoLegalActionException {
        checkIsCardInHand(handCard);
        if (playMate.canBenchMonPlayed(handCard)) {
            playMate.playBenchMonFromHand(handCard);
            handCards.remove(handCard);
        }
    }

    public List<PokemonCard> getEvolveableMonsFromBench(PlayCard evolutionCard) {
        return playMate.getEvolveableMonsFromBench(evolutionCard);
    }

    public void evolveBenchMon(PokemonCard benchMon, PlayCard evolutionCard) throws NoLegalActionException {
        checkIsCardInHand(evolutionCard);
        playMate.evolveBenchMon(benchMon, evolutionCard);
        handCards.remove(evolutionCard);
    }

    public void takeAPrice() {
        handCards.add(priceCards.remove(0));
        if (priceCards.size() == 0) {
            competition.winTheGame(this);
        }
    }


}
