package com.mti.rpg.view.accountcontroller;

/**
 * @author clement.dedenis(clement.dedenis@epita.fr)
 * @since 1.0
 */
public class PutAccountDtoRequest {

    /**
     * PutAccountDtoRequest's id.
     */
    public final Integer id;

    /**
     * PutAccountDtoRequest's name.
     */
    public final String name;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     */
    public PutAccountDtoRequest(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }
}