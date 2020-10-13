package com.mti.rpg.view.petcontroller;

/**
 * @author vincent1.masson (vincent1.masson@epita.fr)
 * @since 1.0
 */
public class FindAllPetsDtoResponse {

    /**
     * FindAllPetsDtoResponse's petList.
     */
    public final Iterable<PetDtoResponse> petList;

    /**
     * Initializer.
     *
     * @param petList field value.
     */
    public FindAllPetsDtoResponse(final Iterable<PetDtoResponse> petList) {
        this.petList = petList;
    }

    public static class PetDtoResponse {
        /**
         * PetDtoResponse's id.
         */
        public final Integer id;

        /**
         * PetDtoResponse's name.
         */
        public final String name;


        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         */
        public PetDtoResponse(final Integer id, final String name) {
            this.id = id;
            this.name = name;
        }
    }
}
