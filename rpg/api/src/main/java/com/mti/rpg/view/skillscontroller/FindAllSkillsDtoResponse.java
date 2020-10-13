package com.mti.rpg.view.skillscontroller;

/**
 * @author moi (vincent1.masson@epita.fr)
 * @since 1.0
 */

public class FindAllSkillsDtoResponse {
    /**
     * FindAllSkillsDtoResponse's skillsList.
     */
    public final Iterable<SkillsDtoResponse> skillsList;

    /**
     * Initializer.
     *
     * @param skillsList field value.
     */
    public FindAllSkillsDtoResponse(final Iterable<SkillsDtoResponse> skillsList) {
        this.skillsList = skillsList;
    }

    public static class SkillsDtoResponse {

        /**
         * SkillsDtoResponse's id.
         */
        public final Integer id;

        /**
         * SkillsDtoResponse's name.
         */
        public final String name;

        /**
         * SkillsDtoResponse's description.
         */
        public final String description;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         * @param description field value.
         */
        public SkillsDtoResponse(final Integer id, final String name, final String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }
}
