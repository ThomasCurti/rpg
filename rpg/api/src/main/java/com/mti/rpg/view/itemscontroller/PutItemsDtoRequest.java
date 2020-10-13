package com.mti.rpg.view.itemscontroller;

/**
 * @author jeremie.piro (jeremie.piro@epita.fr)
 * @since 1.0
 */
public class PutItemsDtoRequest {

    /**
     * PutItemsDtoRequest's id.
     */
    public final Integer id;

    /**
     * PutItemsDtoRequest's name.
     */
    public final String name ;

    /**
     * PutItemsDtoRequest's description.
     */
    public final String description;

    /**
     * PutItemsDtoRequest's characterId.
     */
    public final Integer characterId;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     * @param characterId field value.
     */
    public PutItemsDtoRequest(final Integer id,
                              final String name,
                              final String description,
                              final Integer characterId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.characterId = characterId;
    }
}
