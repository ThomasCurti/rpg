package com.mti.rpg.domain.entity;

/**
 * @author jeremie.piro(jeremie.piro @ epita.fr)
 * @since 1.0
 */
public class SkillsEntity {
    /**
     * SkillsEntity's id.
     */
    public final Integer id;

    /**
     * SkillsEntity's name.
     */
    public final String name;

    /**
     * SkillsEntity's description.
     */
    public final String description;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     */
    public SkillsEntity(final Integer id, final String name, final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
