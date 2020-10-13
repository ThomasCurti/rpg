package com.mti.rpg.view.skillscontroller;

/**
 * @author moi (vincent1.masson@epita.fr)
 * @since 1.0
 */
public class PutSkillsDtoRequest {

    /**
     * PutSkillsDtoRequest's id.
     */
    public final Integer id;

    /**
     * PutSkillsDtoRequest's name.
     */
    public final String name;

    /**
     * PutSkillsDtoRequest's description.
     */
    public final String description;

    /**
     * PutSkillsDtoRequest's classId.
     */
    public final Integer classId;


    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     * @param classId field value.
     */
    public PutSkillsDtoRequest(final Integer id, final String name, final String description, final Integer classId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.classId = classId;
    }
}