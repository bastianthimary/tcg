
package de.my.tcg.basedata.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.my.tcg.basedata.rarity.Rarity;
import de.my.tcg.basedata.Ability;
import de.my.tcg.basedata.Attack;
import de.my.tcg.basedata.CardTypes;
import de.my.tcg.basedata.images.Images;
import de.my.tcg.basedata.poketype.PokeType;
import de.my.tcg.basedata.cardset.CardSet;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static de.my.tcg.dataimport.json.CardFieldNames.ID;
import static de.my.tcg.dataimport.json.CardFieldNames.NAME;


@Entity
@Table(name = "Card", uniqueConstraints = {@UniqueConstraint(columnNames = {"shortDescription"})})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card implements Serializable {

    @GeneratedValue
    @Id
    @JsonIgnore
    private Integer id;
    @JsonProperty(ID)
    private String shortDescription;
    @JsonProperty(NAME)
    private String name;
    @Enumerated(EnumType.STRING)
    private CardTypes supertype;

    private Set<String> subtypes = new HashSet<>();

    private String level;

    private String hp;

    private Set<String> types = new HashSet<>();

    private String evolvesFrom;

    @OneToMany(cascade = CascadeType.ALL)

    private Set<Ability> abilities = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Attack> attacks = new HashSet<>();

    @Enumerated(EnumType.ORDINAL)
    private PokeType weaknesses;

    @Enumerated(EnumType.STRING)

    private PokeType resistances;

    private Integer convertedRetreatCost;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private CardSet cardSet;
    private String artist;

    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    @Column(length = 1024)
    private String flavorText;

    private Set<Integer> nationalPokedexNumbers = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Images images;

    public PokeType getResistances() {
        return resistances;
    }

    public void setResistances(PokeType resistances) {
        this.resistances = resistances;
    }


    /**
     * No args constructor for use in serialization
     */
    public Card() {
    }

    /**
     * @param flavorText
     * @param supertype
     * @param types
     * @param images
     * @param cardSet
     * @param level
     * @param artist
     * @param hp
     * @param convertedRetreatCost
     * @param evolvesFrom
     * @param subtypes
     * @param abilities
     * @param attacks
     * @param nationalPokedexNumbers
     * @param weaknesses
     * @param name
     * @param rarity
     */

    public Card(String name, CardTypes supertype, Set<String> subtypes, String level, String hp, Set<String> types,
                String evolvesFrom, Set<Ability> abilities, Set<Attack> attacks, PokeType weaknesses,
                Integer convertedRetreatCost, CardSet cardSet, String artist, Rarity rarity, String flavorText,
                Set<Integer> nationalPokedexNumbers, Images images) {
        super();
        this.name = name;
        this.supertype = supertype;
        this.subtypes = subtypes;
        this.level = level;
        this.hp = hp;
        this.types = types;
        this.evolvesFrom = evolvesFrom;
        this.abilities = abilities;
        this.attacks = attacks;
        this.weaknesses = weaknesses;
        this.convertedRetreatCost = convertedRetreatCost;
        this.cardSet = cardSet;
        this.artist = artist;
        this.rarity = rarity;
        this.flavorText = flavorText;
        this.nationalPokedexNumbers = nationalPokedexNumbers;
        this.images = images;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("supertype")
    public CardTypes getSupertype() {
        return supertype;
    }

    @JsonProperty("supertype")
    public void setSupertype(CardTypes supertype) {
        this.supertype = supertype;
    }

    @JsonProperty("subtypes")
    public Set<String> getSubtypes() {
        return subtypes;
    }

    @JsonProperty("subtypes")
    public void setSubtypes(Set<String> subtypes) {
        this.subtypes = subtypes;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    @JsonProperty("hp")
    public String getHp() {
        return hp;
    }

    @JsonProperty("hp")
    public void setHp(String hp) {
        this.hp = hp;
    }

    @JsonProperty("types")
    public Set<String> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(Set<String> types) {
        this.types = types;
    }

    @JsonProperty("evolvesFrom")
    public String getEvolvesFrom() {
        return evolvesFrom;
    }

    @JsonProperty("evolvesFrom")
    public void setEvolvesFrom(String evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }

    @JsonProperty("abilities")
    public Set<Ability> getAbilities() {
        return abilities;
    }

    @JsonProperty("abilities")
    public void setAbilities(Set<Ability> abilities) {
        this.abilities = abilities;
    }

    @JsonProperty("attacks")
    public Set<Attack> getAttacks() {
        return attacks;
    }


    public void setAttacks(Set<Attack> attacks) {
        this.attacks = attacks;
    }


    public PokeType getWeaknesses() {
        return weaknesses;
    }


    public void setWeaknesses(PokeType weaknesses) {
        this.weaknesses = weaknesses;
    }


    public Integer getConvertedRetreatCost() {
        return convertedRetreatCost;
    }


    public void setConvertedRetreatCost(Integer convertedRetreatCost) {
        this.convertedRetreatCost = convertedRetreatCost;
    }

    @JsonProperty("set")
    public CardSet getSet() {
        return cardSet;
    }

    @JsonProperty("set")
    public void setSet(CardSet cardSet) {
        this.cardSet = cardSet;
    }


    @JsonProperty("artist")
    public String getArtist() {
        return artist;
    }

    @JsonProperty("artist")
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @JsonProperty("rarity")
    public Rarity getRarity() {
        return rarity;
    }

    @JsonProperty("rarity")
    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    @JsonProperty("flavorText")
    public String getFlavorText() {
        return flavorText;
    }

    @JsonProperty("flavorText")
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    @JsonProperty("nationalPokedexNumbers")
    public Set<Integer> getNationalPokedexNumbers() {
        return nationalPokedexNumbers;
    }

    @JsonProperty("nationalPokedexNumbers")
    public void setNationalPokedexNumbers(Set<Integer> nationalPokedexNumbers) {
        this.nationalPokedexNumbers = nationalPokedexNumbers;
    }


    public Images getImages() {
        return images;
    }


    public void setImages(Images images) {
        this.images = images;
    }


    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", shortDescription='" + shortDescription + '\'' +
                ", name='" + name + '\'' +
                ", supertype='" + supertype + '\'' +
                ", subtypes=" + subtypes +
                ", level='" + level + '\'' +
                ", hp='" + hp + '\'' +
                ", types=" + types +
                ", evolvesFrom='" + evolvesFrom + '\'' +
                ", abilities=" + abilities +
                ", attacks=" + attacks +
                ", weaknesses=" + weaknesses +
                ", resitances=" + resistances +
                ", convertedRetreatCost=" + convertedRetreatCost +
                ", cardSet=" + cardSet +
                ", artist='" + artist + '\'' +
                ", rarity='" + rarity + '\'' +
                ", flavorText='" + flavorText + '\'' +
                ", nationalPokedexNumbers=" + nationalPokedexNumbers +
                ", images=" + images +
                '}';
    }
}
