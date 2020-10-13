package com.mti.rpg.domain.entity;

import com.mti.rpg.persistence.model.AccountModel;

import java.util.Collection;

/**
 * @author clement.dedenis(clement.dedenis@epita.fr)
 * @since 1.0
 */
public class GuildEntity {
    /**
     * GuildEntity's id.
     */
    public final Integer id;

    /**
     * GuildEntity's name.
     */
    public final String name;

    /**
     * GuildEntity's level.
     */
    public final Integer level;

    /**
     * GuildEntity's slogan.
     */
    public final String slogan;

    /**
     * GuildEntity's accounts.
     */
    public final Collection<AccountEntity> accounts;

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param level field value.
     * @param slogan field value.
     * @param accounts field value.
     */
    public GuildEntity(final Integer id,
                       final String name,
                       final Integer level,
                       final String slogan,
                       final Collection<AccountEntity> accounts) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.slogan = slogan;
        this.accounts = accounts;
    }
}
