
package de.my.tcg.domain.images;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name="Images")
public class Images implements Serializable {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    private String small;

    private String large;



    /**
     * No args constructor for use in serialization
     * 
     */
    public Images() {
    }

    /**
     * 
     * @param small
     * @param large
     */
    public Images(String small, String large) {
        super();
        this.small = small;
        this.large = large;
    }

    @JsonProperty("small")
    public String getSmall() {
        return small;
    }

    @JsonProperty("small")
    public void setSmall(String small) {
        this.small = small;
    }

    @JsonProperty("large")
    public String getLarge() {
        return large;
    }

    @JsonProperty("large")
    public void setLarge(String large) {
        this.large = large;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
