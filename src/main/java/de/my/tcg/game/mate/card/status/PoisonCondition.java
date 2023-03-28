package de.my.tcg.game.mate.card.status;

public enum PoisonCondition {
    NO_STATUS(0),
    SINGLE(10),
    DOUBLE(20),
    QUAD(40);

    final int dmg;
   private PoisonCondition( int dmg){
       this.dmg=dmg;
   }
}
