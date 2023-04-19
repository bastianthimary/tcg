package de.my.tcg.game.mate.card.textparser.effect;

public class MultipleDmgEffectTerm extends DmgEffectTerm {
    private int dmgPer;

    @Override
    public void runEffect(int compliedTimes) {
        dmg = compliedTimes * dmgPer;
    }

    public void setDmgPerString(String dmgPerString) {
        dmgPer = Integer.parseInt(dmgPerString);
    }
}
