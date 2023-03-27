package de.my.tcg.game.mate;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.cost.Cost;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.card.EnergyCard;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class EnergyTotal {
    HashMap<PokeType, List<EnergyCard>> energyDepot;

    public EnergyTotal() {
        this.energyDepot = new HashMap<>();
    }

    public void addEnergyCard(EnergyCard energyCard) {
        if (energyDepot.containsKey(energyCard.getPokeType())) {
            energyDepot.get(energyCard.getPokeType()).add(energyCard);
        } else {
            List<EnergyCard> energyCards = new ArrayList<>();
            energyCards.add(energyCard);
            energyDepot.put(energyCard.getPokeType(), energyCards);
        }
    }

    public int getTotalEnergy() {
        return calculateEnergy(energyDepot);
    }

    private int calculateEnergy(HashMap<PokeType, List<EnergyCard>> energyToCalc) {
        AtomicInteger total = new AtomicInteger();
        energyToCalc.keySet().forEach(type -> total.set(energyToCalc.get(type).size() + total.get()));
        return total.get();
    }

    public boolean couldAttackBeUsed(Attack attack) {
        if (attack == null) {
            return false;
        }
        Set<Cost> costs = attack.getCost();
        if (costs.isEmpty()) {
            return true;
        }
        return areCostsAffordable(costs);

    }

    private boolean areCostsAffordable(Set<Cost> costs) {
        HashMap<PokeType, List<EnergyCard>> testDepot = createATestDepot();

        if (reduceFixTypeCosts(testDepot, costs)) {
            return canAffortColorlessCosts(costs, testDepot);
        }
        return false;
    }

    private HashMap<PokeType, List<EnergyCard>> createATestDepot() {
        HashMap<PokeType, List<EnergyCard>> testDepot = new HashMap<>();
        energyDepot.keySet().forEach(type -> testDepot.put(type, new ArrayList<>(energyDepot.get(type))));
        return testDepot;
    }

    private boolean reduceFixTypeCosts(HashMap<PokeType, List<EnergyCard>> testDepot, Set<Cost> costs) {
        AtomicBoolean canAffort = new AtomicBoolean(true);
        costs.forEach(cost -> {
            if (cost.getType() != PokeType.Colorless) {
                haveCostType(testDepot, canAffort, cost);
                payCostsIfAffortable(testDepot, canAffort, cost);
            }
        });
        return canAffort.get();
    }

    private static void haveCostType(HashMap<PokeType, List<EnergyCard>> testDepot, AtomicBoolean canAffort, Cost cost) {
        if (!testDepot.containsKey(cost.getType())) {
            canAffort.set(false);
        }
    }

    private static void payCostsIfAffortable(HashMap<PokeType, List<EnergyCard>> testDepot, AtomicBoolean canAffort, Cost cost) {
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

    private boolean canAffortColorlessCosts(Set<Cost> costs, HashMap<PokeType, List<EnergyCard>> testDepot) {
        Optional<Cost> colorlessCosts = costs.stream().filter(cost ->
                PokeType.Colorless.equals(cost.getType())).findFirst();
        return colorlessCosts.isEmpty() || calculateEnergy(testDepot) >= colorlessCosts.get().getQuantity();
    }
}
