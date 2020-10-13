package com.mti.rpg.view.petcontroller;

/**
 * @author vincent1.masson (vincent1.masson@epita.fr)
 * @since 1.0
 */
public class PutPetDtoRequest {

    /**
     * PutPetDtoRequest's id.
     */
    public final Integer id;

    /**
     * PutPetDtoRequest's name.
     */
    public final String name;

    /**
     * PutPetDtoRequest's characterId.
     */
    public final Integer characterId;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param characterId field value.
     */
    public PutPetDtoRequest(final Integer id, final String name, final Integer characterId) {
        this.id = id;
        this.name = name;
        this.characterId = characterId;
    }
}