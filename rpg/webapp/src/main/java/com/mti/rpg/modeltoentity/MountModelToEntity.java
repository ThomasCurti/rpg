package com.mti.rpg.modeltoentity;

import com.mti.rpg.domain.entity.MountEntity;
import com.mti.rpg.persistence.model.MountModel;
import com.mti.rpg.utils.scope.ConverterService;
import utils.Converter;

/**
 * @author jeremie.piro (jeremie.piro@epita.fr)
 * @since 1.0
 */
@ConverterService
public class MountModelToEntity implements Converter.Reversible<MountModel, MountEntity> {

    /**
     * Default constructor.
     */
    public MountModelToEntity() {
    }

    /**
     * Convert an MountModel to MountEntity.
     */
    @Override
    public  MountEntity convert(final  MountModel mountModel) {
        return new MountEntity(mountModel.getId(),mountModel.getName(),mountModel.getSpeed());
    }

    /**
     * Convert an MountEntity to MountModel.
     */
    @Override
    public MountModel revertConvert(final MountEntity mountEntity) {
        return new MountModel(mountEntity.id, mountEntity.name, mountEntity.speed, null);
    }
}
