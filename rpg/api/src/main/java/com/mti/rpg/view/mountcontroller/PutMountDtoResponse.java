package com.mti.rpg.view.mountcontroller;

/**
 * @author jeremie.piro(jeremie.piro@epita.fr)
 * @since 1.0
 */
public class PutMountDtoResponse {
    /**
     * PutMountDtoResponse's id.
     */
    public final Integer id;

    /**
     * PutMountDtoResponse's name.
     */
    public final String name;

    /**
     * PutMountDtoResponse's speed.
     */
    public final Integer speed;

    /**
     * PutMountDtoResponse's error.
     */
    public final String error;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param speed field value.
     * @param error field value.
     */
    public PutMountDtoResponse(final Integer id, final String name, final Integer speed, final String error) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.error = error;
    }
}