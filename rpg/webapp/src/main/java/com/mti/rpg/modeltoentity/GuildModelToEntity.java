package com.mti.rpg.modeltoentity;

import com.mti.rpg.domain.entity.GuildEntity;
import com.mti.rpg.persistence.model.GuildModel;
import com.mti.rpg.utils.scope.ConverterService;
import utils.Converter;

/**
 * @author thomas.curti(thomas.curti @ epita.fr)
 * @since 1.0
 */
@ConverterService
public class GuildModelToEntity implements Converter.Reversible<GuildModel, GuildEntity> {

    /**
     * AccountModelToEntity's accountModelToEntity.
     */
    private final AccountModelToEntity accountModelToEntity;

    /**
     * Initializer.
     *
     * @param accountModelToEntity field value.
     */
    public GuildModelToEntity(final AccountModelToEntity accountModelToEntity) {
        this.accountModelToEntity = accountModelToEntity;
    }

    /**
     * Convert an GuildModel to GuildEntity.
     */
    @Override
    public GuildEntity convert(final GuildModel from) {
        return new GuildEntity(from.getId(),
                               from.getName(),
                               from.getLevel(),
                               from.getSlogan(),
                               from.getAccounts() == null
                               ? null
                               : accountModelToEntity.convertList(from.getAccounts()));
    }

    /**
     * Convert an GuildEntity to GuildModel.
     */
    @Override
    public GuildModel revertConvert(final GuildEntity from) {
        return new GuildModel(from.id,
                              from.name,
                              from.level,
                              from.slogan,
                              from.accounts == null ? null : accountModelToEntity.revertConvertList(from.accounts));
    }
}
