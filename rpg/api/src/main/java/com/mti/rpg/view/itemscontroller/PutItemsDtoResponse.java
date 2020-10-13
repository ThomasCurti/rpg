package com.mti.rpg.view.itemscontroller;

/**
 * @author jeremie.piro (jeremie.piro@epita.fr)
 * @since 1.0
 */
public class PutItemsDtoResponse {

    /**
     * PutItemsDtoResponse's id.
     */
    public final Integer id;

    /**
     * PutItemsDtoResponse's name.
     */
    public final String name ;

    /**
     * PutItemsDtoResponse's description.
     */
    public final String description;

    /**
     * PutItemsDtoResponse's error.
     */
    public final String error;


    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     * @param error field value.
     */
    public PutItemsDtoResponse(final Integer id, final String name, final String description, final String error) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.error = error;
    }
}
