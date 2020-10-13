package com.mti.rpg.view.accountcontroller;

/**
 * @author clement.dedenis(clement.dedenis@epita.fr)
 * @since 1.0
 */
public class FindAllAccountsDtoResponse {

    /**
     * FindAllAccountsDtoResponse's accountList.
     */
    public final Iterable<FindAllAccountsDtoResponse.AccountDtoResponse> accountList;

    /**
     * Initializer.
     *
     * @param accountList field value.
     */
    public FindAllAccountsDtoResponse(final Iterable<FindAllAccountsDtoResponse.AccountDtoResponse> accountList) {
        this.accountList = accountList;
    }

    public static class AccountDtoResponse{
        /**
         * AccountDtoResponse's id.
         */
        public final Integer id;

        /**
         * AccountDtoResponse's name.
         */
        public final String name;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         */
        public AccountDtoResponse(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
