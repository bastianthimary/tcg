package de.my.tcg.game.mate.card.textparser.effect.effect.target;

import java.util.Arrays;
import java.util.Optional;

public enum Target {

    NO_TARGET(""),
    THIS_POKEMON("this Pokemon"),
    DEFENDING_POKEMON("the Defending Pokémon");
    private final String stringValue;

    Target(String stringValue) {
        this.stringValue = stringValue;
    }

    public static Target getTargetByName(String stringValue) {
        Optional<Target> target = Arrays.stream(Target.values()).toList().stream().filter(t -> t.getStringValue().equalsIgnoreCase(stringValue)).findFirst();
        if (target.isEmpty()) {
            throw new EnumConstantNotPresentException(Target.class, "Target not Found");
        }
        return target.get();
    }

    public String getStringValue() {
        return stringValue;
    }
}
