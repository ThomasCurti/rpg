package com.mti.rpg.view.guildcontroller;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

import java.util.Collection;

public class FindAllGuildsDtoResponse {

    /**
     * FindAllGuildsDtoResponse's guildList.
     */
    public final Iterable<GuildsDtoResponse> guildList;

    /**
     * Initializer.
     *
     * @param guildList field value.
     */
    public FindAllGuildsDtoResponse(final Iterable<GuildsDtoResponse> guildList) {
        this.guildList = guildList;
    }

    public static class GuildsDtoResponse {
        /**
         * GuildsDtoResponse's id.
         */
        public final Integer id;
        /**
         * GuildsDtoResponse's name.
         */
        public final String name;
        /**
         * GuildsDtoResponse's level.
         */
        public final Integer level;
        /**
         * GuildsDtoResponse's slogan.
         */
        public final String slogan;
        /**
         * GuildsDtoResponse's accounts.
         */
        public final Collection<AccountDto> accounts;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         * @param level field value.
         * @param slogan field value.
         * @param accounts field value.
         */
        public GuildsDtoResponse(final Integer id,
                                 final String name,
                                 final Integer level,
                                 final String slogan,
                                 final Collection<AccountDto> accounts) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.slogan = slogan;
            this.accounts = accounts;
        }

        public static class AccountDto {

            /**
             * AccountDto's id.
             */
            public final Integer id;

            /**
             * AccountDto's name.
             */
            public final String name;

            /**
             * Initializer.
             *
             * @param id field value.
             * @param name field value.
             */
            public AccountDto(final Integer id, final String name) {
                this.id = id;
                this.name = name;
            }
        }
    }

}
