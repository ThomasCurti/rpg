package com.mti.rpg.view.mountcontroller;

/**
 * @author jeremie.piro (jeremie.piro@epita.fr)
 * @since 1.0
 */
public class FindAllMountDtoResponse {

    /**
     * FindAllMountDtoResponse's mount.
     */
    public final Iterable<mountDtoResponse> mount;

    /**
     * Initializer.
     *
     * @param mount field value.
     */
    public FindAllMountDtoResponse(final Iterable<mountDtoResponse> mount) {
        this.mount = mount;
    }

    public static class mountDtoResponse{

        /**
         * mountDtoResponse's id.
         */
        public final Integer id;

        /**
         * mountDtoResponse's name.
         */
        public final String name;

        /**
         * mountDtoResponse's speed.
         */
        public final Integer speed;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         * @param speed field value.
         */
        public mountDtoResponse(Integer id, String name, Integer speed) {
            this.id = id;
            this.name = name;
            this.speed = speed;
        }
    }
}