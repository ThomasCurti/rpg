package com.mti.rpg.domain.service;

import com.mti.rpg.domain.entity.CharacterEntity;
import com.mti.rpg.domain.entity.ClassEntity;
import com.mti.rpg.domain.entity.SkillsEntity;
import com.mti.rpg.modeltoentity.CharacterModelToEntity;
import com.mti.rpg.persistence.repository.CharacterRepository;
import org.springframework.stereotype.Service;
import utils.CanLog;
import utils.IterableUtils;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * @author clement.dedenis(clement.dedenis @ epita.fr)
 * @since 1.0
 */
@Service
public class CharacterService implements CanLog {

    /**
     * CharacterService's charactersRepository.
     */
    private final CharacterRepository charactersRepository;

    /**
     * CharacterService's charactersModelToEntity.
     */
    private final CharacterModelToEntity charactersModelToEntity;

    /**
     * CharacterService's accountService.
     */
    private final AccountService accountService;

    /**
     * CharacterService's classService.
     */
    private final ClassService classService;

    /**
     * CharacterService's skillsService.
     */
    private final SkillsService skillsService;

    /**
     * CharacterService's itemsService.
     */
    private final ItemsService itemsService;

    /**
     * CharacterService's petService.
     */
    private final PetService petService;

    /**
     * CharacterService's mountService.
     */
    private final MountService mountService;

    /**
     * Initializer.
     *
     * @param charactersRepository field value.
     * @param charactersModelToEntity field value.
     * @param accountService field value.
     * @param classService field value.
     * @param skillsService field value.
     * @param itemsService field value.
     * @param petService field value.
     * @param mountService field value.
     */
    public CharacterService(final CharacterRepository charactersRepository,
                            final CharacterModelToEntity charactersModelToEntity,
                            final AccountService accountService,
                            final ClassService classService,
                            final SkillsService skillsService,
                            final ItemsService itemsService,
                            final PetService petService, final MountService mountService) {
        this.charactersRepository = charactersRepository;
        this.charactersModelToEntity = charactersModelToEntity;
        this.accountService = accountService;
        this.classService = classService;
        this.skillsService = skillsService;
        this.itemsService = itemsService;
        this.petService = petService;
        this.mountService = mountService;
    }

    /**
     * Find an character by id.
     *
     * @param id The id of character to find.
     * @return The character.
     */
    public CharacterEntity findCharacterById(Integer id) {
        logger().trace("Start find account " + id.toString());
        final var characterModel = charactersRepository.findById(id);
        if (characterModel.isEmpty()) {
            logger().warn("Didn't find account " + id.toString());
            return null;
        }
        logger().trace("Found account " + id.toString());
        final var characterEntity = charactersModelToEntity.convert(characterModel.get());
        return characterEntity;
    }

    /**
     * Find all character.
     *
     * @return the list of all character.
     */
    public List<CharacterEntity> findAllCharacters() {
        logger().trace("Start find all accounts");
        final var characterModelIterable = charactersRepository.findAll();
        logger().trace("Found all accounts & cast Iterable to List");
        final var characterModelList = IterableUtils.toList(characterModelIterable);
        final var characterEntityList = charactersModelToEntity.convertList(characterModelList);

        return characterEntityList;
    }

    /**
     * Transaction to save an character.
     *
     * @param entity The character which will be added or updated.
     *
     * @return The character updated.
     */
    @Transactional
    public CharacterEntity save(final CharacterEntity entity) {


        if (entity.account == null) {
            logger().warn("No account in CharacterService");
            return null;
        }

        logger().trace("Start find account in CharacterService " + entity.account.id);

        var account = accountService.findAccountById(entity.account.id);
        if (account == null) {
            logger().warn("Didn't find account in CharacterService " + entity.account.id);
            return null;
        }

        logger().trace("Account found in CharacterService "  + entity.account.id);

        logger().trace("Start Save classe in CharacterService");
        ClassEntity classEntity = null;
        if (entity.classe != null) {
            classEntity = classService.save(entity.classe);
        }
        logger().trace("Finish Save classe in CharacterService");

        logger().trace("Start Save skills in CharacterService");
        Collection<SkillsEntity> skillsEntity = null;
        if (entity.classe != null && entity.classe.skills != null)
            skillsEntity = skillsService.saveAll(entity.classe.skills, classEntity);
        logger().trace("Finish Save skills in CharacterService");

        //Must do this to set the classEntity id after inserting it
        CharacterEntity characterEntity = new CharacterEntity(entity.id,
                                                              entity.pseudo,
                                                              classEntity,
                                                              entity.items,
                                                              entity.pets,
                                                              entity.mounts,
                                                              entity.account);

        logger().trace("Start Save character in CharacterService");
        final var characterModel = charactersModelToEntity.revertConvert(characterEntity);
        final var resultModel = charactersRepository.save(characterModel);
        var resultEntity = charactersModelToEntity.convert(resultModel);
        logger().trace("Finish Save character in CharacterService");

        logger().trace("Start items character in CharacterService");
        if (entity.items != null)
            itemsService.saveAll(entity.items, resultEntity);
        logger().trace("Finish Save items in CharacterService");

        logger().trace("Start Save pets in CharacterService");
        if (entity.pets != null)
            petService.saveAll(entity.pets, resultEntity);
        logger().trace("Finish Save pets in CharacterService");

        logger().trace("Start Save mounts in CharacterService");
        if (entity.mounts != null)
            mountService.saveAll(entity.mounts, resultEntity);
        logger().trace("Finish Save mounts in CharacterService");


        //Must do this to get skills because resultModel's skills are null
        var resultClasse = new ClassEntity(resultEntity.classe.id,
                                           resultEntity.classe.name,
                                           resultEntity.classe.description,
                                           skillsEntity);
        var resultEntityWithSkills = new CharacterEntity(resultEntity.id,
                                                         resultEntity.pseudo,
                                                         resultClasse,
                                                         resultEntity.items,
                                                         resultEntity.pets,
                                                         resultEntity.mounts,
                                                         resultEntity.account);

        return resultEntityWithSkills;
    }

    /**
     * Transaction to delete an account.
     *
     * @param id The character id which will be deleted.
     *
     * @return Boolean.
     */
    @Transactional
    public boolean deleteCharacter(Integer id) {
        logger().trace("Start delete character in service");
        var characterModel = charactersRepository.findById(id);
        if (characterModel.isEmpty()) {
            logger().warn("Didn't find character to delete in service " + id);
            return false;
        }
        charactersRepository.delete(characterModel.get());
        logger().trace("Finish delete account in service");
        return true;
    }

}
