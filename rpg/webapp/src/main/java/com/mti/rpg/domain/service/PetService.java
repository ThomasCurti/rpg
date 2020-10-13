package com.mti.rpg.domain.service;

import com.mti.rpg.domain.entity.CharacterEntity;
import com.mti.rpg.domain.entity.PetEntity;
import com.mti.rpg.modeltoentity.CharacterModelToEntity;
import com.mti.rpg.modeltoentity.PetModelToEntity;
import com.mti.rpg.persistence.repository.PetRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import utils.CanLog;
import utils.IterableUtils;

import javax.print.CancelablePrintJob;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * @author vincent1.masson (vincent1.masson@epita.fr)
 * @since 1.0
 */
@Service
public class PetService implements CanLog {

    /**
     * PetService's petRepository.
     */
    private final PetRepository petRepository;

    /**
     * PetService's petModelToEntity.
     */
    private final PetModelToEntity petModelToEntity;

    /**
     * PetService's characterModelToEntity.
     */
    private final CharacterModelToEntity characterModelToEntity;

    /**
     * PetService's characterService.
     */
    private final CharacterService characterService;

    /**
     * Initializer.
     *
     * @param petRepository field value.
     * @param petModelToEntity field value.
     * @param characterModelToEntity field value.
     * @param characterService field value.
     */
    public PetService(final PetRepository petRepository,
                      final PetModelToEntity petModelToEntity,
                      final CharacterModelToEntity characterModelToEntity,
                      @Lazy final CharacterService characterService) {
        this.petRepository = petRepository;
        this.petModelToEntity = petModelToEntity;
        this.characterModelToEntity = characterModelToEntity;
        this.characterService = characterService;
    }

    /**
     * Find all pet.
     *
     * @return the list of all pet.
     */
    public List<PetEntity> findAllPets() {
        logger().trace("Start find all pets");
        final var petModelIterable = petRepository.findAll();
        final var petModelList = IterableUtils.toList(petModelIterable);
        logger().trace("Found all pets & cast Iterable to List");
        return petModelToEntity.convertList(petModelList);
    }

    /**
     * Transaction to save an pet to a character.
     *
     * @param entity The pet which will be added or updated.
     * @param characterId The character id associated to the mount.
     * @return The pet updated.
     */
    @Transactional
    public PetEntity savePetToCharacter(final PetEntity entity, final Integer characterId) {

        logger().trace("Start Save items in service");
        final var characterEntity = characterService.findCharacterById(characterId);
        if (characterEntity == null) {
            logger().warn("Didn't find pet in Petsservice");
            return null;
        }

        final var petModel = petModelToEntity.revertConvert(entity);
        petModel.setCharacter(characterModelToEntity.revertConvert(characterEntity));
        final var resultModel = petRepository.save(petModel);
        logger().trace("Finish Save pet in service");
        return petModelToEntity.convert(resultModel);
    }

    /**
     * Transaction to save a list of pet to a character.
     *
     * @param entity The list of pet which will be added or updated.
     * @param character The character associated to the mount.
     * @return The list of pet updated.
     */
    @Transactional
    public Collection<PetEntity> saveAll(final Collection<PetEntity> entity, final CharacterEntity character) {

        logger().trace("Start SaveAll pets in service");
        final var petModel = petModelToEntity.revertConvertList(entity);

        final var characterModel = characterModelToEntity.revertConvert(character);
        petModel.stream().forEach(pet -> pet.setCharacter(characterModel));

        final var resultModel = petRepository.saveAll(petModel);
        final var resultModelList = IterableUtils.toList(resultModel);
        logger().trace("Finish SaveAll pets in service");
        return petModelToEntity.convertList(resultModelList);
    }

    /**
     * Transaction to delete an pet.
     *
     * @param petId The pet id which will be deleted.
     *
     * @return Boolean.
     */
    @Transactional
    public boolean deletePet(final Integer petId) {
        logger().trace("Start delete pets in service");
        var petModel = petRepository.findById(petId);
        if (petModel.isEmpty()) {
            logger().warn("Didn't find pets to delete in service " + petId);
            return false;
        }

        petRepository.delete(petModel.get());
        logger().trace("Finish delete pets in service");
        return true;
    }
}
