package de.my.tcg.market.booster.distribution;

public class RarityAppearance {
  private final BoosterSlot slot;
   private final int appearance;
   public RarityAppearance(BoosterSlot slot){
        this.slot = slot;
        appearance=1;
    }
    public RarityAppearance(BoosterSlot slot, int appearance){
       this.slot = slot;
       this.appearance=appearance;
    }

    public BoosterSlot getSlot() {
        return slot;
    }

    public int getAppearance() {
        return appearance;
    }
}
