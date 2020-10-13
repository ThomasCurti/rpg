package com.mti.rpg.domain.entity;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */
public class AccountEntity {

    /**
     * AccountEntity's id.
     */
    public final Integer id;

    /**
     * AccountEntity's name.
     */
    public final String name;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     */
    public AccountEntity(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }
}
