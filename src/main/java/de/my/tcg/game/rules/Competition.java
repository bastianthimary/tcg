package de.my.tcg.game.rules;

import de.my.tcg.game.domain.Player;

public interface Competition {

   void winTheGame(Player player) throws GameEndsException;

   void lostTheGame(Player player) throws GameEndsException;
}
