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
@Table(name = "skills")
public class SkillsModel {

    /**
     * Entity identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Skills's name.
     */
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    /**
     * Skills's description.
     */
    @Column(name = "description", nullable = false, length = 128)
    private String description;

    /**
     * Skills's classe.
     */
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassModel classe;

    /**
     * Default constructor.
     */
    public SkillsModel() {
    }

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     * @param classe field value.
     */
    public SkillsModel(final Integer id, final String name, final String description, final ClassModel classe) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.classe = classe;
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
     * Get the value of description.
     *
     * @return The value of description.
     */
    public ClassModel getClasse() {
        return classe;
    }

    /**
     * Set the value classe field.
     *
     * @param classe The value to set.
     */
    public void setClasse(ClassModel classe) {
        this.classe = classe;
    }
}
