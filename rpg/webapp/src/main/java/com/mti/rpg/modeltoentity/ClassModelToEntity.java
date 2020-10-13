package com.mti.rpg.modeltoentity;

import com.mti.rpg.domain.entity.ClassEntity;
import com.mti.rpg.persistence.model.CharacterModel;
import com.mti.rpg.persistence.model.ClassModel;
import com.mti.rpg.utils.scope.ConverterService;
import utils.Converter;

import java.util.ArrayList;

/**
 * @author thomas.curti(thomas.curti @ epita.fr)
 * @since 1.0
 */
@ConverterService
public class ClassModelToEntity implements Converter.Reversible<ClassModel, ClassEntity> {

    /**
     * ClassModelToEntity's skillsConverter.
     */
    private final SkillsModelToEntity skillsConverter;

    /**
     * Initializer.
     *
     * @param skillsConverter field value.
     */
    public ClassModelToEntity(final SkillsModelToEntity skillsConverter) {
        this.skillsConverter = skillsConverter;
    }

    /**
     * Convert an ClassModel to ClassEntity.
     */
    @Override
    public ClassEntity convert(final ClassModel from) {
        return new ClassEntity(from.getId(),
                               from.getName(),
                               from.getDescription(),
                               skillsConverter.convertList(from.getSkills()));
    }

    /**
     * Convert an ClassEntity to ClassModel.
     */
    @Override
    public ClassModel revertConvert(final ClassEntity from) {
        return new ClassModel(from.id,
                              from.name,
                              from.description,
                              new ArrayList<CharacterModel>(),
                              skillsConverter.revertConvertList(from.skills));
    }

}
