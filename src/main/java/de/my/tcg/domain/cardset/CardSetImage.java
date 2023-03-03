package de.my.tcg.domain.cardset;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CardSetImage")
public class CardSetImage  implements Serializable {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;

    private String symbol;

    private String logo;

    /**
     * No args constructor for use in serialization
     *
     */
    public CardSetImage() {

    }

    public CardSetImage(String symbol, String logo) {
        this.symbol = symbol;
        this.logo = logo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
