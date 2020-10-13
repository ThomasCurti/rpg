package com.mti.rpg.view.accountcontroller;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

public class PutAccountJoinGuildDtoRequest {

    /**
     * PutAccountJoinGuildDtoRequest's accountId.
     */
    public final Integer accountId;

    /**
     * PutAccountJoinGuildDtoRequest's guildId.
     */
    public final Integer guildId;

    /**
     * Initializer.
     *
     * @param accountId field value.
     * @param guildId field value.
     */
    public PutAccountJoinGuildDtoRequest(final Integer accountId, final Integer guildId) {
        this.accountId = accountId;
        this.guildId = guildId;
    }
}
