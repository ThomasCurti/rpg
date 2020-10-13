package com.mti.rpg.modeltoentity;

import com.mti.rpg.domain.entity.ItemsEntity;
import com.mti.rpg.persistence.model.ItemsModel;
import com.mti.rpg.utils.scope.ConverterService;
import utils.Converter;

/**
 * @author jeremie.piro (jeremie.piro@epita.fr)
 * @since 1.0
 */
@ConverterService
public class ItemsModelToEntity implements Converter.Reversible<ItemsModel, ItemsEntity> {

    /**
     * Default constructor.
     */
    public ItemsModelToEntity() {
    }


    /**
     * Convert an ItemsModel to ItemsEntity.
     */
    @Override
    public ItemsEntity convert(final ItemsModel itemsModel) {
        return new ItemsEntity(itemsModel.getId(),
                               itemsModel.getName(),
                               itemsModel.getDescription());
    }

    /**
     * Convert an ItemsEntity to ItemsModel.
     */
    @Override
    public ItemsModel revertConvert(final ItemsEntity itemsEntity) {
        return new ItemsModel(itemsEntity.id,
                              itemsEntity.name,
                              itemsEntity.description,
                              null);
    }
}
