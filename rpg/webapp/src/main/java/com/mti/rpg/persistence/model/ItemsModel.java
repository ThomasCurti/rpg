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
 * @author thomas.curti(thomas.curti @ epita.fr)
 * @since 1.0
 */

@Entity
@Table(name = "items")
public class ItemsModel {

    /**
     * Entity identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Items's name.
     */
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    /**
     * Items's description.
     */
    @Column(name = "description", length = 128, nullable = false)
    private String description;

    /**
     * Items's characters.
     */
    @ManyToOne
    @JoinColumn(name = "characters_id", referencedColumnName = "id")
    private CharacterModel characters;

    /**
     * Default constructor.
     */
    public ItemsModel() {
    }

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     * @param characters field value.
     */
    public ItemsModel(final Integer id, final String name, final String description, final CharacterModel characters) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.characters = characters;
    }

    /**
     * Get the value of id.
     *
     * @return The value of id.
     */
    public Integer getId() {
        return id;
    }

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
     * Get the value of description.
     *
     * @return The value of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value description field.
     *
     * @param description The value to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of characters.
     *
     * @return The value of characters.
     */
    public CharacterModel getCharacters() {
        return characters;
    }

    /**
     * Set the value characters field.
     *
     * @param characters The value to set.
     */
    public void setCharacters(CharacterModel characters) {
        this.characters = characters;
    }
}