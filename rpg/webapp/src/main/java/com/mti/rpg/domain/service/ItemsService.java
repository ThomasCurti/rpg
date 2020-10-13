package com.mti.rpg.domain.service;

import com.mti.rpg.domain.entity.CharacterEntity;
import com.mti.rpg.domain.entity.ItemsEntity;
import com.mti.rpg.modeltoentity.CharacterModelToEntity;
import com.mti.rpg.modeltoentity.ItemsModelToEntity;
import com.mti.rpg.persistence.repository.ItemsRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import utils.CanLog;
import utils.IterableUtils;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * @author jeremie.piro(jeremie.piro@epita.fr)
 * @since 1.0
 */
@Service
public class ItemsService implements CanLog {

    /**
     * ItemsService's itemsRepository.
     */
    private final ItemsRepository itemsRepository;

    /**
     * ItemsService's itemsModelToEntity.
     */
    private final ItemsModelToEntity itemsModelToEntity;

    /**
     * ItemsService's characterModelToEntity.
     */
    private final CharacterModelToEntity characterModelToEntity;

    /**
     * ItemsService's characterService.
     */
    private final CharacterService characterService;

    /**
     * Initializer.
     *
     * @param itemsRepository field value.
     * @param itemsModelToEntity field value.
     * @param characterModelToEntity field value.
     * @param characterService field value.
     */
    public ItemsService(final ItemsRepository itemsRepository,
                        final ItemsModelToEntity itemsModelToEntity,
                        final CharacterModelToEntity characterModelToEntity,
                        @Lazy final CharacterService characterService) {
        this.itemsRepository = itemsRepository;
        this.itemsModelToEntity = itemsModelToEntity;
        this.characterModelToEntity = characterModelToEntity;
        this.characterService = characterService;
    }

    /**
     * Find all item.
     *
     * @return the list of all item.
     */
    public List<ItemsEntity> findAllItems()
    {
        logger().trace("Start find all items");
        final var itemIterable = itemsRepository.findAll();
        logger().trace("Found all items & cast Iterable to List");
        final var itemList = IterableUtils.toList(itemIterable);
        final var itemEntityList = itemsModelToEntity.convertList(itemList);
        return itemEntityList;

    }

    /**
     * Transaction to save an item to a character.
     *
     * @param itemEntity The item which will be added or updated.
     * @param characterId The character id associated to the item.
     * @return The item updated.
     */

    @Transactional
    public ItemsEntity saveItemToCharacter(final ItemsEntity itemEntity, final Integer characterId) {

        logger().trace("Start Save items in service");
        final var characterEntity = characterService.findCharacterById(characterId);
        if (characterEntity == null) {
            logger().warn("Didn't find items in Itemsservice");
            return null;
        }

        final var itemModels = itemsModelToEntity.revertConvert(itemEntity);
        final var resultModel = itemsRepository.save(itemModels);
        resultModel.setCharacters(characterModelToEntity.revertConvert(characterEntity));
        final var resultEntity = itemsModelToEntity.convert(resultModel);
        logger().trace("Finish Save items in service");
        return resultEntity;
    }

    /**
     * Transaction to save a list of item to a character.
     *
     * @param itemEntity The list of item which will be added or updated.
     * @param character The character associated to the item.
     * @return The list of item updated.
     */
    @Transactional
    public Collection<ItemsEntity> saveAll(final Collection<ItemsEntity> itemEntity, final CharacterEntity character) {

        logger().trace("Start SaveAll items in service");
        final var itemModels = itemsModelToEntity.revertConvertList(itemEntity);

        final var characterModel = characterModelToEntity.revertConvert(character);
        itemModels.stream().forEach(item -> item.setCharacters(characterModel));

        final var resultModel = itemsRepository.saveAll(itemModels);
        final var resultModelList = IterableUtils.toList(resultModel);
        final var resultEntity = itemsModelToEntity.convertList(resultModelList);
        logger().trace("Finish SaveAll items in service");
        return resultEntity;
    }

    /**
     * Transaction to delete an item.
     *
     * @param ItemId The item id which will be deleted.
     *
     * @return Boolean.
     */
    @Transactional
    public boolean deleteItem(final Integer ItemId) {
        logger().trace("Start delete items in service");
        var itemsModel = itemsRepository.findById(ItemId);
        if (itemsModel.isEmpty()) {
            logger().warn("Didn't find item to delete in service " + ItemId);
            return false;
        }

        itemsRepository.delete(itemsModel.get());
        logger().trace("Finish delete item in service");
        return true;
    }
}
