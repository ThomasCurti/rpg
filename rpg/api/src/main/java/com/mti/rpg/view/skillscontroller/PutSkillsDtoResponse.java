package com.mti.rpg.view.skillscontroller;

/**
 * @author moi (vincent1.masson@epita.fr)
 * @since 1.0
 */
public class PutSkillsDtoResponse {

    /**
     * PutSkillsDtoResponse's id.
     */
    public final Integer id;

    /**
     * PutSkillsDtoResponse's name.
     */
    public final String name;

    /**
     * PutSkillsDtoResponse's description.
     */
    public final String description;

    /**
     * PutSkillsDtoResponse's error.
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
    public PutSkillsDtoResponse(final Integer id, final String name, final String description, final String error) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.error = error;
    }
}
