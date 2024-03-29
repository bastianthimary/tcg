package de.my.tcg.game.mate;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.card.EnergyCard;
import de.my.tcg.game.mate.card.textparser.utils.NumberParser;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EnergyTotal {
    EnumMap<PokeType, List<EnergyCard>> energyDepot;


    public EnergyTotal() {
        this.energyDepot = new EnumMap<>(PokeType.class);
    }

    public void addEnergyCard(EnergyCard energyCard) {
        addEnergyCardToMap(energyCard, energyDepot);
    }

    private void addEnergyCardToMap(EnergyCard energyCard, EnumMap<PokeType, List<EnergyCard>> map) {
        if (map.containsKey(energyCard.getPokeType())) {
            map.get(energyCard.getPokeType()).add(energyCard);
        } else {
            List<EnergyCard> energyCards = new ArrayList<>();
            energyCards.add(energyCard);
            map.put(energyCard.getPokeType(), energyCards);
        }
    }

    public int getTotalEnergy() {
        return calculateEnergy(energyDepot);
    }

    private int calculateEnergy(EnumMap<PokeType, List<EnergyCard>> energyToCalc) {
        AtomicInteger total = new AtomicInteger();
        energyToCalc.keySet().forEach(type -> total.set(energyToCalc.get(type).size() + total.get()));
        return total.get();
    }

    public boolean couldAttackBeUsed(Attack attack) {
        if (attack == null) {
            return false;
        }
        Set<Cost> attackCost = attack.getCost();
        if (attackCost.isEmpty()) {
            return true;
        }
        return areAttackCostsAffordable(attackCost);

    }

    private boolean areAttackCostsAffordable(Set<Cost> costs) {
        EnumMap<PokeType, List<EnergyCard>> testDepot = createATestDepot();

        if (reduceFixTypeAttackCosts(testDepot, costs)) {
            return canAffortColorlessAttackCosts(costs, testDepot);
        }
        return false;
    }

    private EnumMap<PokeType, List<EnergyCard>> createATestDepot() {
        EnumMap<PokeType, List<EnergyCard>> testDepot = new EnumMap<>(PokeType.class);
        energyDepot.keySet().forEach(type -> testDepot.put(type, new ArrayList<>(energyDepot.get(type))));
        return testDepot;
    }

    private boolean reduceFixTypeAttackCosts(EnumMap<PokeType, List<EnergyCard>> testDepot, Set<Cost> costs) {
        AtomicBoolean canAffort = new AtomicBoolean(true);
        costs.forEach(cost -> {
            if (cost.getType() != PokeType.Colorless) {
                haveCostType(testDepot, canAffort, cost);
                payAttackCostsIfAffortable(testDepot, canAffort, cost);
            }
        });
        return canAffort.get();
    }

    private static void haveCostType(EnumMap<PokeType, List<EnergyCard>> testDepot, AtomicBoolean canAffort, Cost cost) {
        if (!testDepot.containsKey(cost.getType())) {
            canAffort.set(false);
        }
    }

    private static void payAttackCostsIfAffortable(EnumMap<PokeType, List<EnergyCard>> testDepot, AtomicBoolean canAffort, Cost cost) {
        List<EnergyCard> energyCards = testDepot.get(cost.getType());
        int timesOfReduction;
        if (energyCards.size() >= cost.getQuantity()) {
            timesOfReduction = cost.getQuantity();
        } else {
            timesOfReduction = energyCards.size();
            canAffort.set(false);
        }
        if (timesOfReduction > 0) {
            energyCards.subList(0, timesOfReduction).clear();
        }
    }

    private boolean canAffortColorlessAttackCosts(Set<Cost> costs, EnumMap<PokeType, List<EnergyCard>> testDepot) {
        Optional<Cost> colorlessCosts = costs.stream().filter(cost -> PokeType.Colorless.equals(cost.getType())).findFirst();
        return colorlessCosts.isEmpty() || calculateEnergy(testDepot) >= colorlessCosts.get().getQuantity();
    }

    public List<EnergyCard> getAllEnergyCard() {
        List<EnergyCard> allEnergy = new ArrayList<>();
        energyDepot.values().forEach(allEnergy::addAll);
        return allEnergy;
    }

    public List<EnergyCard> removeAllEnergys() {
        List<EnergyCard> removedEnergyCards = new ArrayList<>();
        energyDepot.keySet().forEach(pokeType ->
                removedEnergyCards.addAll(removeNumberOfEnergytype(energyDepot.get(pokeType).size(), pokeType)));
        return removedEnergyCards;
    }

    public List<EnergyCard> removeNumberOfEnergytype(int number, PokeType pokeType) {
        List<EnergyCard> removedEnergyCards = new ArrayList<>();
        List<EnergyCard> energyFromDepot = energyDepot.get(pokeType);
        if (number == NumberParser.ALL) {
            removedEnergyCards.addAll(energyFromDepot);
            energyFromDepot = new ArrayList<>();
        }
        for (int i = 0; i < number; i++) {
            removedEnergyCards.add(energyFromDepot.remove(0));
        }
        return removedEnergyCards;
    }

    public List<EnergyCard> getANumberOfCardOfType(int number, PokeType pokeType) {
        List<EnergyCard> energyFromDepot;
        if (PokeType.All.equals(pokeType)) {
            energyFromDepot = getAllEnergyCard();
        } else {
            energyFromDepot = energyDepot.get(pokeType);
        }
        if (number == NumberParser.ALL) {
            return new ArrayList<>(energyFromDepot);
        }
        return new ArrayList<>(energyFromDepot.subList(0, number));
    }

    public void removeListOfEnergyCards(List<EnergyCard> energyCards) {
        EnumMap<PokeType, List<EnergyCard>> removeMap = new EnumMap<>(PokeType.class);
        energyCards.forEach(card -> addEnergyCardToMap(card, removeMap));

        removeMap.keySet().forEach(type -> removeNumberOfEnergytype(removeMap.get(type).size(), type));
    }

    public boolean allCardsHaveSameType() {
        return getAllEnergyCard().stream().
                map(EnergyCard::getPokeType).collect(Collectors.toSet()).size() == 1;
    }

    public boolean contains(List<EnergyCard> energyCards) {
        EnumMap<PokeType, List<EnergyCard>> containsMap = new EnumMap<>(PokeType.class);
        energyCards.forEach(card -> addEnergyCardToMap(card, containsMap));
        return containsMap.keySet().stream().
                allMatch(pokeType -> containsMap.get(pokeType).size() <= energyDepot.get(pokeType).size());

    }
}
