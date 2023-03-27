package de.my.tcg.game;

import de.my.tcg.basedata.Subtype;
import de.my.tcg.game.rules.Competition;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.domain.Player;
import de.my.tcg.game.rules.formatsettings.FormatSettings;
import lombok.Getter;

public class BasicGame implements Competition {
    private Player player1;
    private Player player2;
    @Getter
    private FormatSettings formatSettings;

    public BasicGame(Player player1, Player player2, FormatSettings formatSettings) {
        this.player1 = player1;
        this.player2 = player2;
        this.formatSettings=formatSettings;
        setupOpponents(player1, player2);
    }

    private static void setupOpponents(Player player1, Player player2) {
        player1.setOpponent(player2);
        player2.setOpponent(player1);
    }


    public void startOfGame() {
        playerPreparation(player1);
        playerPreparation(player2);

        drawStartHands();
        setupPriceCards();

    }

    private void playerPreparation(Player player) {
        player.convertPersonsDeckToPlayDeck();
        player.setCompetition(this);
    }

    private void drawStartHands() {
        int mulliganCounter1=drawStartHand(player1);
        int mulliganCounter2=drawStartHand(player2);
        player1.drawSeveralCardsFromDeckToHand(mulliganCounter2);
        player2.drawSeveralCardsFromDeckToHand(mulliganCounter1);
    }

    private int drawStartHand(Player player) {
        player.drawSeveralCardsFromDeckToHand(formatSettings.numberStartHand());
        if (player.getHandCards().stream().noneMatch(
                playCard -> playCard.getCard().getSubtypes().contains(Subtype.BASIC))) {
            return drawStartHand(player) + 1;
        }
        return 0;
    }

    private void setupPriceCards() {

        player1.setupPriceCards(formatSettings.prices());
        player2.setupPriceCards(formatSettings.prices());
    }

    @Override
    public void winTheGame(Player player) {

    }

    @Override
    public void lostTheGame(Player player) {

    }

    public void addActiveToPlayMate(Player player, PlayCard playCard) {
    }
}
