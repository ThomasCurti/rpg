package com.mti.rpg.view.petcontroller;

/**
 * @author vincent1.masson (vincent1.masson@epita.fr)
 * @since 1.0
 */
public class PutPetDtoResponse {

    /**
     * PutPetDtoResponse's id.
     */
    public final Integer id;
    /**
     * PutPetDtoResponse's name.
     */
    public final String name;
    /**
     * PutPetDtoResponse's error.
     */
    public final String error;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param error field value.
     */
    public PutPetDtoResponse(final Integer id, final String name, final String error) {
        this.id = id;
        this.name = name;
        this.error = error;
    }
}
