package de.my.tcg.game.rules;

import de.my.tcg.game.domain.Player;

public interface Competition {

   void winTheGame(Player player);
   void lostTheGame(Player player);
}
