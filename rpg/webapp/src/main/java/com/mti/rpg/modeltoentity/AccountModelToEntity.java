package com.mti.rpg.modeltoentity;

import com.mti.rpg.domain.entity.AccountEntity;
import com.mti.rpg.persistence.model.AccountModel;
import com.mti.rpg.utils.scope.ConverterService;
import utils.Converter;

/**
 * @author clement.dedenis (clement.dedenis@epita.fr)
 * @since 1.0
 */
@ConverterService
public class AccountModelToEntity implements Converter.Reversible<AccountModel, AccountEntity> {

    /**
     * Default constructor.
     */
    public AccountModelToEntity() {
    }

    /**
     * Convert an AccountModel to AccountEntity.
     */
    @Override
    public AccountEntity convert(final AccountModel from) {
        return new AccountEntity(from.getId(), from.getName());
    }

    /**
     * Convert an AccountEntity to AccountModel.
     */
    @Override
    public AccountModel revertConvert(final AccountEntity from) {
        return new AccountModel(from.id, from.name, null, null);
    }
}