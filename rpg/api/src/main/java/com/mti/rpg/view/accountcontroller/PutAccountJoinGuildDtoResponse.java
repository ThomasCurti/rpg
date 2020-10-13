package com.mti.rpg.view.accountcontroller;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

public class PutAccountJoinGuildDtoResponse {

    /**
     * PutAccountJoinGuildDtoResponse's id.
     */
    public final Integer id;

    /**
     * PutAccountJoinGuildDtoResponse's name.
     */
    public final String name;

    /**
     * PutAccountJoinGuildDtoResponse's error.
     */
    public final String error;


    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param error field value.
     */
    public PutAccountJoinGuildDtoResponse(final Integer id, final String name, final String error) {
        this.id = id;
        this.name = name;
        this.error = error;
    }
}
