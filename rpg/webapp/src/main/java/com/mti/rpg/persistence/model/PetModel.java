package com.mti.rpg.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */
@Entity
@Table(name="pet")
public class PetModel {

    /**
     * Entity identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Pet's name.
     */
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    /**
     * Pet's character.
     */
    @ManyToOne
    @JoinColumn(name = "characters_id", referencedColumnName = "id")
    private CharacterModel character;

    /**
     * Default constructor.
     */
    public PetModel() {
    }

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param character field value.
     */
    public PetModel(final Integer id, final String name, final CharacterModel character) {
        this.id = id;
        this.name = name;
        this.character = character;
    }

    /**
     * Get the value of id.
     *
     * @return The value of id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the value id field.
     *
     * @param id The value to set.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the value of name.
     *
     * @return The value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value name field.
     *
     * @param name The value to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of character.
     *
     * @return The value of character.
     */
    public CharacterModel getCharacter() {
        return character;
    }

    /**
     * Set the value character field.
     *
     * @param character The value to set.
     */
    public void setCharacter(CharacterModel character) {
        this.character = character;
    }
}