package com.mti.rpg.domain.entity;

import java.util.Collection;

/**
 * @author clement.dedenis(clement.dedenis@epita.fr)
 * @since 1.0
 */
public class ClassEntity {

    /**
     * ClassEntity's id.
     */
    public final Integer id;

    /**
     * ClassEntity's name.
     */
    public final String name;

    /**
     * ClassEntity's description.
     */
    public final String description;

    /**
     * ClassEntity's skills.
     */
    public final Collection<SkillsEntity> skills;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     * @param skills field value.
     */
    public ClassEntity(final Integer id,
                       final String name,
                       final String description,
                       final Collection<SkillsEntity> skills) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.skills = skills;
    }
}
