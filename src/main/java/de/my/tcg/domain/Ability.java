
package de.my.tcg.domain;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "Ability")
public class Ability implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    @Column(length = 1024)
    private String text;
    private String type;


    /**
     * No args constructor for use in serialization
     */
    public Ability() {
    }

    /**
     * @param name
     * @param text
     * @param type
     */
    public Ability(String name, String text, String type) {
        super();
        this.name = name;
        this.text = text;
        this.type = type;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
