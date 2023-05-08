package de.my.tcg.game.mate.card;

import de.my.tcg.basedata.Ability;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.card.Card;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.mate.EnergyTotal;
import de.my.tcg.game.mate.card.nextturn.NextTurnEffects;
import de.my.tcg.game.mate.card.status.PokemonStatusCondition;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

public class PokemonCard extends FieldCard {

    @Getter
    private String name;
    @Getter
    private PokeType myPokeType;
    @Getter
    private int hp;
    @Getter
    private LinkedHashSet<PlayCard> preEvolution;
    @Getter
    private List<Ability> abilities;
    @Getter
    private List<Attack> attacks;
    private static final int WEAKNESS_FACTOR = 2;
    @Getter
    private Optional<PokeType> weakness;
    private static final int RESISTANCE_VALUE = -30;

    @Getter
    private Optional<PokeType> resistance;

    @Getter
    private int retreatCosts;
    @Getter
    private EnergyTotal energyTotal;

    @Getter
    private int dmgCounter;

    @Getter
    private PokemonStatusCondition pokemonStatusCondition;

    @Setter
    @Getter
    private NextTurnEffects nextTurnEffects;

    public PokemonCard(PlayCard playCard) {
        this.currentCard = playCard;
        setBaseStatsFromCard(currentCard.getCard());
        initValues();

    }

    private void setBaseStatsFromCard(Card baseCard) {
        name = baseCard.getName();
        hp = Integer.parseInt(baseCard.getHp());
        Optional<String> stringOptional = baseCard.getTypes().stream().findFirst();
        stringOptional.ifPresent(s -> myPokeType = PokeType.valueOf(s));
        resistance = Optional.ofNullable(baseCard.getResistances());
        weakness = Optional.ofNullable(baseCard.getWeaknesses());
        retreatCosts = baseCard.getConvertedRetreatCost();
        attacks = new ArrayList<>(baseCard.getAttacks());
        abilities = new ArrayList<>(baseCard.getAbilities());
    }

    private void initValues() {
        energyTotal = new EnergyTotal();
        pokemonStatusCondition = new PokemonStatusCondition(this);
        preEvolution = new LinkedHashSet<>();
        nextTurnEffects = new NextTurnEffects();
    }


    public void doDmgAccordingToType(int originDmg, PokeType takeDmgByType) throws MonIsDefeatedException {
        if (hasAWeaknessAgainst(takeDmgByType)) {
            originDmg = calcWeaknessDmg(originDmg);
        }
        if (hasAResistanceAgainst(takeDmgByType)) {
            originDmg = calcResistanceDmg(originDmg);
        }
        doSimpleDmg(originDmg);
    }

    public boolean hasAWeaknessAgainst(PokeType takeDmgByType) {
        return weakness.isPresent() && weakness.get().equals(takeDmgByType);
    }

    private int calcWeaknessDmg(int originValue) {
        return originValue * WEAKNESS_FACTOR;
    }

    public boolean hasAResistanceAgainst(PokeType takeDmgByType) {
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

    public void doAttackDmg(int attackDmg) {
        int afterTurnEffects = getNextTurnEffects().calcDmgAfterTurnEffects(attackDmg);
        doSimpleDmg(afterTurnEffects);
    }

    public List<Attack> giveUseableAttacks() {
        return attacks.stream().filter(attack -> energyTotal.couldAttackBeUsed(attack)).toList();
    }

    public void evolvePokemon(PlayCard evolution) {
        if (name.equals(evolution.getCard().getEvolvesFrom())) {
            preEvolution.add(currentCard);
            currentCard = evolution;
            setBaseStatsFromCard(evolution.getCard());
            pokemonStatusCondition.healAllStates();
        }
    }

}
