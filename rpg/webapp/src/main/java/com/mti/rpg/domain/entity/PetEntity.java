package com.mti.rpg.domain.entity;

/**
 * @author vincent1.masson (vincent1.masson@epita.fr)
 * @since 1.0
 */
public class PetEntity {

    /**
     * PetEntity's id.
     */
    public final Integer id;

    /**
     * PetEntity's name.
     */
    public final String name;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     */
    public PetEntity(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }
}
