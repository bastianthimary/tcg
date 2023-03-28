package de.my.tcg.game.mate.card;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.card.status.StatusCondition;
import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

public class PokemonCard extends FieldCard {

    private String name;
    private PokeType myPokeType;
    private int hp;
    private LinkedHashSet<PlayCard> preEvolution;

    private List<Attack> attacks;
    private final int WEAKNESS_FACTOR = 2;
    private Optional<PokeType> weakness;
    private final int RESISTANCE_VALUE = -30;
    private Optional<PokeType> resistance;

    private int retreatCosts;

    private EnergyTotal energyTotal;

    private int dmgCounter;

    @Getter
    private StatusCondition statusCondition;

    public PokemonCard(PlayCard playCard) {
        this.currentCard = playCard;
        setBaseStatsFromCard();
        initValues();

    }

    private void setBaseStatsFromCard() {
        Card baseCard = currentCard.getCard();
        hp = Integer.getInteger(baseCard.getHp());
        myPokeType = PokeType.valueOf(baseCard.getTypes().stream().findFirst().get());
        resistance = Optional.of(baseCard.getResistances());
        weakness = Optional.of(baseCard.getWeaknesses());
        retreatCosts = baseCard.getConvertedRetreatCost();
    }

    private void initValues() {
        energyTotal = new EnergyTotal();
        statusCondition = new StatusCondition(this);
        preEvolution = new LinkedHashSet<>();
    }


    public void doDmgAccordingToType(int originValue, PokeType takeDmgByType) throws MonIsDefeatedException {
        if (hasAWeaknessAgainst(takeDmgByType)) {
            originValue = calcWeaknessDmg(originValue);
        } else if (hasAResistanceAgainst(takeDmgByType)) {
            originValue = calcResistanceDmg(originValue);
        }
        doSimpleDmg(originValue);
    }

    private boolean hasAWeaknessAgainst(PokeType takeDmgByType) {
        return weakness.isPresent() && weakness.get().equals(takeDmgByType);
    }

    private int calcWeaknessDmg(int originValue) {
        return originValue * WEAKNESS_FACTOR;
    }

    private boolean hasAResistanceAgainst(PokeType takeDmgByType) {
        return resistance.isPresent() && resistance.get().equals(takeDmgByType);
    }

    private int calcResistanceDmg(int originValue) {
        originValue = originValue + RESISTANCE_VALUE;
        if (originValue < 0) {
            originValue = 0;
        }
        return originValue;
    }

    public void doSimpleDmg(int originValue) throws MonIsDefeatedException {
        dmgCounter = dmgCounter + originValue;
        if (dmgCounter >= hp) {
            throw new MonIsDefeatedException();
        }
    }

}
