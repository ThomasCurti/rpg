package com.mti.rpg.modeltoentity;

import com.mti.rpg.domain.entity.SkillsEntity;
import com.mti.rpg.persistence.model.SkillsModel;
import com.mti.rpg.utils.scope.ConverterService;
import utils.Converter;

/**
 * @author vincent1.masson (vincent1.masson@epita.fr)
 * @since 1.0
 */
@ConverterService
public class SkillsModelToEntity implements Converter.Reversible<SkillsModel, SkillsEntity> {

    /**
     * Default constructor.
     */
    public SkillsModelToEntity() {
    }

    /**
     * Convert an SkillsModel to SkillsEntity.
     */
    @Override
    public SkillsEntity convert(final SkillsModel from) {
        return new SkillsEntity(from.getId(), from.getName(), from.getDescription());
    }

    /**
     * Convert an SkillsEntity to SkillsModel.
     */
    @Override
    public SkillsModel revertConvert(final SkillsEntity from) {
        return new SkillsModel(from.id, from.name, from.description, null);
    }
}
