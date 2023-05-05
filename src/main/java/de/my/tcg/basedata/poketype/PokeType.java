package de.my.tcg.basedata.poketype;

import com.fasterxml.jackson.annotation.JsonValue;


public enum PokeType {
    Colorless("Colorless"),
    Fire("Fire"),

    Water("Water"),
    Grass("Grass"),
    Lightning("Lightning"),
    Psychic("Psychic"),

    Fighting("Fighting"),
    Darkness("Darkness"),
    Fairy("Fairy"),
    Dragon("Dragon"),
    Metal("Metal"),
    All("All");


    private String typeName;

    PokeType() {
    }

    PokeType(String typeName) {
        this.typeName = typeName;
    }

    @JsonValue
    public String getTypeName() {
        return typeName;
    }
}
