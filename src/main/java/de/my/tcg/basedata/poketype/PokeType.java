package de.my.tcg.basedata.poketype;

import com.fasterxml.jackson.annotation.JsonValue;



public enum PokeType {
    Fire("Fire"),

    Water("Water"),
    Grass("Grass"),
    Lightning("Lightning"),
    Psychic("Psychic"),
    Colorless("Colorless"),
    Fighting("Fighting"),
    Darkness("Darkness"),
    Fairy("Fairy"),
    Dragon("Dragon"),
    Metal("Metal");

    private String typeName;

    PokeType() {
    }

    PokeType(String typeName){
        this.typeName=typeName;
    }

    @JsonValue
    public String getTypeName(){
        return typeName;
    }
}
