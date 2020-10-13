package com.mti.rpg.view.classcontroller;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

import java.util.Collection;

public class PutClassDtoRequest {

    /**
     * PutClassDtoRequest's id.
     */
    public final Integer id;

    /**
     * PutClassDtoRequest's name.
     */
    public final String name;

    /**
     * PutClassDtoRequest's description.
     */
    public final String description;

    /**
     * PutClassDtoRequest's skills.
     */
    public final Collection<SkillsDto> skills;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param description field value.
     * @param skills field value.
     */
    public PutClassDtoRequest(final Integer id,
                              final String name,
                              final String description,
                              final Collection<SkillsDto> skills) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.skills = skills;
    }

    public static class SkillsDto {

        /**
         * SkillsDto's id.
         */
        public final Integer id;

        /**
         * SkillsDto's name.
         */
        public final String name;

        /**
         * SkillsDto's description.
         */
        public final String description;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         * @param description field value.
         */
        public SkillsDto(final Integer id, final String name, final String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }
}
