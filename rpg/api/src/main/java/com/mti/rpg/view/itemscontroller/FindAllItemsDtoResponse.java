package com.mti.rpg.view.itemscontroller;

/**
 * @author jeremie.piro(jeremie.piro@epita.fr)
 * @since 1.0
 */
public class FindAllItemsDtoResponse {
    /**
     * FindAllItemsDtoResponse's item.
     */
    public final Iterable<itemDtoResponse> item;

    /**
     * Initializer.
     *
     * @param item field value.
     */
    public FindAllItemsDtoResponse(Iterable<itemDtoResponse> item) {
        this.item = item;
    }

    public static class itemDtoResponse{

        /**
         * itemDtoResponse's id.
         */
        public final Integer id;

        /**
         * itemDtoResponse's name.
         */
        public final String name ;

        /**
         * itemDtoResponse's description.
         */
        public final String description;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         * @param description field value.
         */
        public itemDtoResponse(Integer id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }
}
