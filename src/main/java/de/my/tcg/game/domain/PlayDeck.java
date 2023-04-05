package de.my.tcg.game.domain;



import java.util.ArrayList;
import java.util.List;

public class PlayDeck {
    List<PlayCard> cardList;

    public PlayDeck() {
        cardList = new ArrayList<>();
    }

    public List<PlayCard> getCards() {
        return cardList;
    }

    public void addCard(PlayCard playCard) {
        cardList.add(playCard);
    }

    public int getDecksize() {
        return cardList.size();
    }

}
