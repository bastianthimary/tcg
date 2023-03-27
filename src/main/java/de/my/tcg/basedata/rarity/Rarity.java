package de.my.tcg.basedata.rarity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rarity {

    COMMON("Common"),
    UNCOMMON("Uncommon"),
    RARE("Rare"),
    RARE_HOLO("Rare Holo"),
    RARE_ULTRA("Rare Ultra"),
    RARE_HOLO_LVX("Rare Holo LV.X"),
    RARE_HOLO_V("Rare Holo V"),
    RARE_HOLO_VSTAR("Rare Holo VSTAR"),
    TRAINER_GALLERY_RARE_HOLO("Trainer Gallery Rare Holo"),
    TRAINER_GALLERY_RARE_HOLO_V("Trainer Gallery Rare Holo V"),
    TRAINER_GALLERY_RARE_ULTRA("Trainer Gallery Rare Ultra"),
    TRAINER_GALLERY_RARE_SECRET("Trainer Gallery Rare Secret"),
    RARE_HOLO_VMAX("Rare Holo VMAX"),
    RARE_HOLO_EX("Rare Holo EX"),
    RARE_RAINBOW("Rare Rainbow"),
    LEGEND("LEGEND"),
    RARE_SECRET("Rare Secret"),
    AMAZING_RARE("Amazing Rare"),
    RARE_ACE("Rare ACE"),
    RARE_SHINING("Rare Shining"),
    RARE_SHINIY("Rare Shiny"),
    RARE_SHINY_GX("Rare Shiny GX"),
    RARE_PRIME("Rare Prime"),
    RARE_PRISM_STAR("Rare Prism Star"),
    PROMO("Promo"),
    RARE_BREAK("Rare BREAK"),
    RARE_HOLO_GX("Rare Holo GX"),
    RARE_HOLO_STAR("Rare Holo Star");

    final String stringValue;

    Rarity(String stringValue) {
        this.stringValue = stringValue;
    }


    @JsonValue
    public String getStringValue() {
        return stringValue;
    }
}
