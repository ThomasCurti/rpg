package com.mti.rpg.view.mountcontroller;

/**
 * @author jeremie.piro(jeremie.piro@epita.fr)
 * @since 1.0
 */
public class PutMountDtoRequest {

    /**
     * PutMountDtoRequest's id.
     */
    public final Integer id;

    /**
     * PutMountDtoRequest's name.
     */
    public final String name;

    /**
     * PutMountDtoRequest's speed.
     */
    public final Integer speed;

    /**
     * PutMountDtoRequest's characterId.
     */
    public final Integer characterId;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param speed field value.
     * @param characterId field value.
     */
    public PutMountDtoRequest(final Integer id, final String name, final Integer speed, final Integer characterId) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.characterId = characterId;
    }
}