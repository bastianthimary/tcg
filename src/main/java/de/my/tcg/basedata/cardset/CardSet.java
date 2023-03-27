
package de.my.tcg.basedata.cardset;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.my.tcg.basedata.card.Card;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.io.Serializable;
import java.util.Set;

import static de.my.tcg.dataimport.json.CardFieldNames.ID;

@Primary
@Entity
@Table(name = "CardSet", uniqueConstraints = {@UniqueConstraint(columnNames = {"shortname"})})
public class CardSet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardset_sequence")
    @JsonIgnore
    private Integer id;

    @JsonProperty(ID)

    private String shortname;
    private String name;
    private String series;

    @OneToMany(mappedBy = "shortDescription")
    @JsonIgnore
    private Set<Card> cardsInSet;

    @OneToOne(cascade = CascadeType.ALL)
    private CardSetImage images;
    private int printedTotal;
    private int total;

    private String releaseDate;


    /**
     * No args constructor for use in serialization
     */
    public CardSet() {
    }

    /**
     * @param total
     * @param printedTotal
     * @param ptcgoCode
     * @param releaseDate
     * @param series
     * @param name
     * @param shortname
     */
    public CardSet(String shortname, String name, String series, int printedTotal, int total, String ptcgoCode, String releaseDate) {
        super();
        this.shortname = shortname;
        this.name = name;
        this.series = series;
        this.printedTotal = printedTotal;
        this.total = total;
        this.releaseDate = releaseDate;
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


    public String getSeries() {
        return series;
    }


    public void setSeries(String series) {
        this.series = series;
    }


    public int getPrintedTotal() {
        return printedTotal;
    }


    public void setPrintedTotal(int printedTotal) {
        this.printedTotal = printedTotal;
    }


    public int getTotal() {
        return total;
    }


    public void setTotal(int total) {
        this.total = total;
    }


    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public CardSetImage getImages() {
        return images;
    }

    public void setImages(CardSetImage images) {
        this.images = images;
    }

    public Set<Card> getCardsInSet() {
        return cardsInSet;
    }

    public void setCardsInSet(Set<Card> cardsInSet) {
        this.cardsInSet = cardsInSet;
    }
}
