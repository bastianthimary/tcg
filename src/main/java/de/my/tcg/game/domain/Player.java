package de.my.tcg.game.domain;

import de.my.tcg.collector.Person;
import de.my.tcg.game.mate.FieldSide;
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
    private Person person;
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

    private FieldSide playMate;


    private List<PlayCard> priceCards= new ArrayList<>();


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

    public void setupPriceCards(int numberOfPrices){
        for (int i=0;i< numberOfPrices; i++){
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

   public void evolveActiveMon(){
        //TODO: Check is able + Karten verheiraten
    }
   public void playActiveMonFromHand(PlayCard cardFromHand){
       if(!handCards.contains(cardFromHand)){
           throw  new GameException(ExceptionMessage.CARD_NOT_IN_HAND);
       }
        playMate.setActiveFromHand(cardFromHand);

    }



}
