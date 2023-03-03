package de.my.tcg.domain.cost;

import de.my.tcg.domain.poketype.PokeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@lombok.Getter
@lombok.Setter
@Entity
@Table(name="Cost")
public class Cost {
    @lombok.Getter
    @lombok.Setter
    @GeneratedValue
    @Id
    private Integer id;

    @lombok.Getter
    @lombok.Setter
    private PokeType type;
    @lombok.Getter
    @lombok.Setter
    private Integer quantity;

    public Cost() {
    }

    public Cost( PokeType type,Integer quantity) {
        this.type = type;
        this.quantity = quantity;
    }
    public Cost( String type,Integer quantity) {
        this.type = PokeType.valueOf(type);
        this.quantity = quantity;
    }


}
