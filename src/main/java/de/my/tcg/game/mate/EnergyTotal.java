package de.my.tcg.game.mate;

import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.game.mate.card.EnergyCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            List<EnergyCard> energyCards=new ArrayList<>();
            energyCards.add(energyCard);
            energyDepot.put(energyCard.getPokeType(),energyCards);
        }
    }

    public int getTotalEnergy() {
        AtomicInteger total= new AtomicInteger();
        energyDepot.keySet().forEach(type -> total.set(energyDepot.get(type).size() + total.get()));
        return total.get();
    }

    public boolean couldAttackBeUsed(Attack attack){
        if(attack==null){
            return false;
        }
        return true;
    }
}
