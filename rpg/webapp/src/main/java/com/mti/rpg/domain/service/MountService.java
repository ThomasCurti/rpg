package com.mti.rpg.domain.service;

import com.mti.rpg.domain.entity.CharacterEntity;
import com.mti.rpg.domain.entity.MountEntity;
import com.mti.rpg.modeltoentity.CharacterModelToEntity;
import com.mti.rpg.modeltoentity.MountModelToEntity;
import com.mti.rpg.persistence.repository.MountRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import utils.CanLog;
import utils.IterableUtils;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * @author jeremie.piro(jeremie.piro @ epita.fr)
 * @since 1.0
 */
@Service
public class MountService implements CanLog {

    /**
     * MountService's mountRepository.
     */
    private final MountRepository mountRepository;

    /**
     * MountService's mountModelToEntity.
     */
    private final MountModelToEntity mountModelToEntity;

    /**
     * MountService's characterModelToEntity.
     */
    private final CharacterModelToEntity characterModelToEntity;

    /**
     * MountService's characterModelToEntity.
     */
    private final CharacterService characterService;

    /**
     * Initializer.
     *
     * @param mountRepository field value.
     * @param mountModelToEntity field value.
     * @param characterModelToEntity field value.
     * @param characterService field value.
     */
    public MountService(final MountRepository mountRepository,
                        final MountModelToEntity mountModelToEntity,
                        final CharacterModelToEntity characterModelToEntity,
                        @Lazy final CharacterService characterService) {
        this.mountRepository = mountRepository;
        this.mountModelToEntity = mountModelToEntity;
        this.characterModelToEntity = characterModelToEntity;
        this.characterService = characterService;
    }

    /**
     * Find all mount.
     *
     * @return the list of all mount.
     */
    public List<MountEntity> findAllMount() {
        logger().trace("Start find all mounts");
        final var mountIterable = mountRepository.findAll();
        logger().trace("Found all mounts & cast Iterable to List");
        final var mountList = IterableUtils.toList(mountIterable);
        final var mountEntityList = mountModelToEntity.convertList(mountList);
        return mountEntityList;
    }

    /**
     * Transaction to save an mount to a character.
     *
     * @param mountEntity The mount which will be added or updated.
     * @param characterId The character id associated to the mount.
     * @return The mount updated.
     */
    @Transactional
    public MountEntity saveMountToCharacter(final MountEntity mountEntity, final Integer characterId) {

        logger().trace("Start Save mounts in service");
        final var characterEntity = characterService.findCharacterById(characterId);
        if (characterEntity == null) {
            logger().warn("Didn't find mounts in Mountservice");
            return null;
        }

        final var mountModels = mountModelToEntity.revertConvert(mountEntity);
        mountModels.setCharacters(characterModelToEntity.revertConvert(characterEntity));
        final var resultModel = mountRepository.save(mountModels);
        final var resultEntity = mountModelToEntity.convert(resultModel);
        logger().trace("Finish Save mounts in service");
        return resultEntity;
    }

    /**
     * Transaction to save a list of mount to a character.
     *
     * @param mountEntity The list of mount which will be added or updated.
     * @param character The character associated to the mount.
     * @return The list of mount updated.
     */
    @Transactional
    public Collection<MountEntity> saveAll(final Collection<MountEntity> mountEntity, final CharacterEntity character) {

        logger().trace("Start SaveAll mounts in service");
        final var mountModels = mountModelToEntity.revertConvertList(mountEntity);

        final var characterModel = characterModelToEntity.revertConvert(character);
        mountModels.stream().forEach(mount -> mount.setCharacters(characterModel));

        final var resultModel = mountRepository.saveAll(mountModels);
        final var resultModelList = IterableUtils.toList(resultModel);
        final var resultEntity = mountModelToEntity.convertList(resultModelList);
        logger().trace("Finish SaveAll mounts in service");
        return resultEntity;

    }

    /**
     * Transaction to delete an mount.
     *
     * @param mountId The mount id which will be deleted.
     *
     * @return Boolean.
     */
    @Transactional
    public boolean deleteMount(final Integer mountId) {
        logger().trace("Start delete mounts in service");
        var mountModel = mountRepository.findById(mountId);
        if (mountModel.isEmpty()) {
            logger().warn("Didn't find mounts to delete in service " + mountId);
            return false;
        }

        mountRepository.delete(mountModel.get());
        logger().trace("Finish delete item in service");
        return true;
    }

}
