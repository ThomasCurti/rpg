package com.mti.rpg.domain.entity;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */
public class ItemsEntity {

    /**
     * ItemsEntity's slogan.
     */
    public final Integer id;

    /**
     * ItemsEntity's name.
     */
    public final String name;

    /**
     * ItemsEntity's description.
     */
    public final String description;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     */
    public ItemsEntity(final Integer id,final String name,final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
