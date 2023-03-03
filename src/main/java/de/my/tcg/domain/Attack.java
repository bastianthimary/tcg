
package de.my.tcg.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.my.tcg.domain.cost.Cost;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Attack")
public class Attack implements Serializable {
    @GeneratedValue
    @Id
    private Integer id;
    private String name;

   @OneToMany(cascade = CascadeType.ALL)
   @JsonDeserialize(as = HashSet.class,contentAs = Cost.class)
    private Set<Cost> cost = new HashSet<>();

    private Integer convertedEnergyCost;
    private String damage;
    @Column(length = 1024)
    private String text;


    /**
     * No args constructor for use in serialization
     */
    public Attack() {
    }

    /**
     * @param damage
     * @param cost
     * @param name
     * @param text
     * @param convertedEnergyCost
     */
    public Attack(String name, Set<Cost> cost, Integer convertedEnergyCost, String damage, String text) {
        super();
        this.name = name;
        this.cost = cost;
        this.convertedEnergyCost = convertedEnergyCost;
        this.damage = damage;
        this.text = text;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Cost> getCost() {
        return cost;
    }

    public void setCost(Set<Cost> cost) {
        this.cost = cost;
    }

    public Integer getConvertedEnergyCost() {
        return convertedEnergyCost;
    }

    public void setConvertedEnergyCost(Integer convertedEnergyCost) {
        this.convertedEnergyCost = convertedEnergyCost;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
