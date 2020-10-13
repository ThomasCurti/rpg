package com.mti.rpg.domain.entity;

/**
 * @author jeremie.piro(jeremie.piro@epita.fr)
 * @since 1.0
 */
public class MountEntity {

    /**
     * MountEntity's id.
     */
    public final Integer id;

    /**
     * MountEntity's name.
     */
    public final String name;

    /**
     * MountEntity's speed.
     */
    public final Integer speed;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param speed field value.
     */
    public MountEntity(final Integer id, final String name, final Integer speed) {
        this.id = id;
        this.name = name;
        this.speed = speed;
    }
}
