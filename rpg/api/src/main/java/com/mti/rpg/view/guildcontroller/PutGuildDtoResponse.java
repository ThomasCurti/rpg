package com.mti.rpg.view.guildcontroller;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

public class PutGuildDtoResponse {

    /**
     * PutGuildDtoResponse's id.
     */
    public final Integer id;
    /**
     * PutGuildDtoResponse's name.
     */
    public final String name;
    /**
     * PutGuildDtoResponse's level.
     */
    public final Integer level;
    /**
     * PutGuildDtoResponse's slogan.
     */
    public final String slogan;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param level field value.
     * @param slogan field value.
     */
    public PutGuildDtoResponse(final Integer id,
                               final String name,
                               final Integer level,
                               final String slogan) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.slogan = slogan;
    }
}
