package de.my.tcg.game.mate.card.status;

public enum PoisonCondition implements Status {
    NO_STATUS(0),
    SINGLE(10),
    DOUBLE(20),
    QUAD(40);

    final int dmg;

    PoisonCondition(int dmg) {
        this.dmg = dmg;
    }
}
