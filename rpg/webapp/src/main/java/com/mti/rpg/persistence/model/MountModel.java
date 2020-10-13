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
 * @author jeremie.piro(jeremie.piro @ epita.fr)
 * @since 1.0
 */
@Entity
@Table(name = "mount")
public class MountModel {

    /**
     * Entity identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Mount's name.
     */
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    /**
     * Mount's speed.
     */
    @Column(name = "speed")
    private Integer speed;

    /**
     * Mount's character.
     */
    @ManyToOne
    @JoinColumn(name = "characters_id", referencedColumnName = "id")
    private CharacterModel character;

    /**
     * Default constructor.
     */
    public MountModel() {
    }

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param speed field value.
     * @param character field value.
     */
    public MountModel(final Integer id, final String name, final Integer speed, final CharacterModel character) {
        this.id = id;
        this.name = name;
        this.speed = speed;
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
     * Get the value of speed.
     *
     * @return The value of speed.
     */
    public Integer getSpeed() {
        return speed;
    }

    /**
     * Set the value speed field.
     *
     * @param speed The value to set.
     */
    public void setSpeed(Integer speed) {
        this.speed = speed;
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
    public void setCharacters(CharacterModel character) {
        this.character = character;
    }
}