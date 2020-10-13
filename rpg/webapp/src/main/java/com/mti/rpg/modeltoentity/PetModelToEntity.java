package com.mti.rpg.modeltoentity;

import com.mti.rpg.domain.entity.PetEntity;
import com.mti.rpg.persistence.model.PetModel;
import com.mti.rpg.utils.scope.ConverterService;
import utils.Converter;

/**
 * @author vincent1.masson (vincent1.masson@epita.fr)
 * @since 1.0
 */
@ConverterService
public class PetModelToEntity implements Converter.Reversible<PetModel, PetEntity> {

    /**
     * Default constructor.
     */
    public PetModelToEntity() {
    }

    /**
     * Convert an PetModel to PetEntity.
     */
    @Override
    public PetEntity convert(final PetModel petModel) {
        return new PetEntity(petModel.getId(), petModel.getName());
    }

    /**
     * Convert an PetEntity to PetModel.
     */
    @Override
    public PetModel revertConvert(final PetEntity petEntity) {
        return new PetModel(petEntity.id, petEntity.name, null);
    }
}