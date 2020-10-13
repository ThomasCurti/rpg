package com.mti.rpg.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author thomas.curti(thomas.curti @ epita.fr)
 * @since 1.0
 */
@Entity
@Table(name = "class")
public class ClassModel {

    /**
     * Entity identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Class's name.
     */
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    /**
     * Class's description.
     */
    @Column(name = "description", length = 128, nullable = false)
    private String description;

    /**
     * Class's characters.
     */
    @OneToMany (mappedBy = "classe", cascade = CascadeType.REMOVE)
    private Collection<CharacterModel> characters;

    /**
     * Class's skills.
     */
    @OneToMany(mappedBy = "classe", cascade = CascadeType.REMOVE)
    private Collection<SkillsModel> skills;

    /**
     * Default constructor.
     */
    public ClassModel() {
    }

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     * @param characters field value.
     * @param skills field value.
     */
    public ClassModel(final Integer id,
                      final String name,
                      final String description,
                      final Collection<CharacterModel> characters,
                      final Collection<SkillsModel> skills) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.characters = characters;
        this.skills = skills;
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
    public void setId(final Integer id) {
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
    public void setName(final String name) {
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
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Get the value of characters.
     *
     * @return The value of characters.
     */
    public Collection<CharacterModel> getCharacters() {
        return characters;
    }

    /**
     * Set the value description field.
     *
     * @param characters The value to set.
     */
    public void setCharacters(final Collection<CharacterModel> characters) {
        this.characters = characters;
    }

    /**
     * Get the value of skills.
     *
     * @return The value of skills.
     */
    public Collection<SkillsModel> getSkills() {
        return skills;
    }

    /**
     * Set the value skills field.
     *
     * @param skills The value to set.
     */
    public void setSkills(final Collection<SkillsModel> skills) {
        this.skills = skills;
    }
}
