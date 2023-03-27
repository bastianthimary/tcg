package de.my.tcg.basedata;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum CardTypes implements Serializable {
    ENERGY("Energy"),
    POKEMON("Pokémon"),
    TRAINER("Trainer")
    ;

    final String stringValue;
    CardTypes(String stringValue) {
        this.stringValue=stringValue;
    }
    @JsonValue
    public String getStringValue() {
        return stringValue;
    }
}
