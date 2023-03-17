
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

    private byte[] large_img;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Images() {
    }

    /**
     * @param small
     * @param large
     * @param largeImg
     */
    public Images(String small, String large, byte[] largeImg) {
        super();
        this.small = small;
        this.large = large;
        large_img = largeImg;
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

    public byte[] getLarge_img() {
        return large_img;
    }

    public void setLarge_img(byte[] large_img) {
        this.large_img = large_img;
    }
}
