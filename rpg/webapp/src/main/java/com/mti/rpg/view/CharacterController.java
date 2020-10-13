package com.mti.rpg.view;


import com.mti.rpg.domain.entity.AccountEntity;
import com.mti.rpg.domain.entity.CharacterEntity;
import com.mti.rpg.domain.entity.ClassEntity;
import com.mti.rpg.domain.entity.ItemsEntity;
import com.mti.rpg.domain.entity.MountEntity;
import com.mti.rpg.domain.entity.PetEntity;
import com.mti.rpg.domain.entity.SkillsEntity;
import com.mti.rpg.domain.service.CharacterService;
import com.mti.rpg.view.accountcontroller.DeleteAccountDtoResponse;
import com.mti.rpg.view.charactercontroller.FindAllCharacterDtoResponse;
import com.mti.rpg.view.charactercontroller.PutCharacterDtoRequest;
import com.mti.rpg.view.charactercontroller.PutCharacterDtoResponse;
import org.springframework.web.bind.annotation.*;
import utils.CanLog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author clement.dedenis(clement.dedenis @ epita.fr)
 * @since 1.0
 */
@RestController
@RequestMapping("/character")
public class CharacterController implements CanLog {

    /**
     * CharacterController's characterService.
     */
    private final CharacterService characterService;

    /**
     * Initializer.
     *
     * @param characterService field value.
     */
    public CharacterController(final CharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     * GET Request to find all characters.
     *
     * @return FindAllCharacterDtoResponse
     */
    @GetMapping("/")
    public FindAllCharacterDtoResponse findAllCharacters() {
        logger().trace("Start TX characters find all");
        final List<CharacterEntity> characterEntityList = characterService.findAllCharacters();
        logger().trace("Finish TX characters find all");
        return new FindAllCharacterDtoResponse(
                characterEntityList.stream()
                                   .map(characterEntity -> new FindAllCharacterDtoResponse.CharacterDtoResponse(
                                           // Id
                                           characterEntity.id,
                                           // Pseudo
                                           characterEntity.pseudo,
                                           // ClassDto
                                           new FindAllCharacterDtoResponse.ClassDto(
                                                   characterEntity.classe.id,
                                                   characterEntity.classe.name,
                                                   characterEntity.classe.description,
                                                   characterEntity.classe.skills.stream()
                                                                                .map(entity -> new FindAllCharacterDtoResponse.SkillsDto(
                                                                                        entity.id,
                                                                                        entity.name,
                                                                                        entity.description
                                                                                )).collect(Collectors.toList())
                                           ),
                                           // List ItemDto
                                           characterEntity.items.stream().map(
                                                   entity -> new FindAllCharacterDtoResponse.ItemsDto(
                                                           entity.id,
                                                           entity.name,
                                                           entity.description
                                                   )).collect(Collectors.toList()),
                                           // List PetDto
                                           characterEntity.pets.stream().map(
                                                   entity -> new FindAllCharacterDtoResponse.PetDto(
                                                           entity.id,
                                                           entity.name
                                                   )).collect(Collectors.toList()),
                                           // List MountDto
                                           characterEntity.mounts.stream().map(
                                                   entity -> new FindAllCharacterDtoResponse.MountDbo(
                                                           entity.id,
                                                           entity.name,
                                                           entity.speed
                                                   )).collect(Collectors.toList()),
                                           //Account
                                           new FindAllCharacterDtoResponse.AccountDto(characterEntity.account.id,
                                                                                      characterEntity.account.name)
                                   )).collect(Collectors.toList()));
    }

    /**
     * PUT Request to add an characters.
     *
     * @param putCharacterDtoRequest The RequestBody.
     * @return PutCharacterDtoResponse
     */
    @PutMapping("/")
    public PutCharacterDtoResponse putCharacter(final @RequestBody PutCharacterDtoRequest putCharacterDtoRequest) {

        if (putCharacterDtoRequest.classe == null)
            return new PutCharacterDtoResponse(null, null, null, null, null, null, null,  "Classe should NOT be null");

        if (putCharacterDtoRequest.classe.skills == null)
            return new PutCharacterDtoResponse(null, null, null, null, null, null, null,  "Skills should NOT be null");

        if (putCharacterDtoRequest.account == null)
            return new PutCharacterDtoResponse(null, null, null, null, null, null, null,  "Account should NOT be null");

        final var entity = new CharacterEntity(
                // Id
                null,
                // Pseudo
                putCharacterDtoRequest.pseudo,
                // ClassEntity
                new ClassEntity(
                        null,
                        putCharacterDtoRequest.classe.name,
                        putCharacterDtoRequest.classe.description,
                        putCharacterDtoRequest.classe.skills == null
                        ? null
                        : putCharacterDtoRequest.classe.skills.stream()
                                                              .map(skill -> new SkillsEntity(
                                                                      null, skill.name, skill.description))
                                                              .collect(Collectors.toList())),
                // List ItemsEntity
                putCharacterDtoRequest.items == null
                ? null
                : putCharacterDtoRequest.items.stream().map(item -> new ItemsEntity(
                       null, item.name, item.description))
                                              .collect(Collectors.toList()),
                // List PetEntity
                putCharacterDtoRequest.pets == null
                ? null
                : putCharacterDtoRequest.pets.stream().map(pet -> new PetEntity(
                        null, pet.name))
                                             .collect(Collectors.toList()),
                // List MountEntity
                putCharacterDtoRequest.mounts == null
                ? null
                : putCharacterDtoRequest.mounts.stream()
                                               .map(mount -> new MountEntity(null, mount.name, mount.speed))
                                               .collect(Collectors.toList()),
                //AccountEntity
                new AccountEntity(putCharacterDtoRequest.account.id,
                                  putCharacterDtoRequest.account.name)
        );
        logger().trace("Start TX character save entity");
        final var result = characterService.save(entity);
        logger().trace("Finish TX character save entity");
        if (result == null)
            return new PutCharacterDtoResponse(null, null, null, null, null, null, null,  "Wrong id");

        return new PutCharacterDtoResponse(
                result.id,
                result.pseudo,
                // ClassDto
                new PutCharacterDtoResponse.ClassDto(
                        result.classe.id,
                        result.classe.name,
                        result.classe.description,
                        putCharacterDtoRequest.classe.skills == null ? null : result.classe.skills.stream()
                                                                                                  .map(classEntity -> new PutCharacterDtoResponse.SkillsDto(
                                                                                                          classEntity.id,
                                                                                                          classEntity.name,
                                                                                                          classEntity.description
                                                                                                  ))
                                                                                                  .collect(Collectors.toList())
                ),
                // List ItemDto
                putCharacterDtoRequest.items == null ? null : result.items.stream().map(
                        itemEntity -> new PutCharacterDtoResponse.ItemsDto(
                                itemEntity.id,
                                itemEntity.name,
                                itemEntity.description
                        )).collect(Collectors.toList()),
                // List PetDto
                putCharacterDtoRequest.pets == null ? null : result.pets.stream().map(
                        petEntity -> new PutCharacterDtoResponse.PetDto(
                                petEntity.id,
                                petEntity.name
                        )).collect(Collectors.toList()),
                // List MountDto
                putCharacterDtoRequest.mounts == null ? null : result.mounts.stream().map(
                        mountEntity -> new PutCharacterDtoResponse.MountDbo(
                                mountEntity.id,
                                mountEntity.name,
                                mountEntity.speed
                        )).collect(Collectors.toList()),
                //AccountDto
                new PutCharacterDtoResponse.AccountDto(putCharacterDtoRequest.account.id,
                                                       putCharacterDtoRequest.account.name),
                null
        );
    }

    /**
     * DELETE Request to delete an characters.
     *
     * @param id The PathVariable.
     * @return DeleteAccountDtoResponse
     */
    @DeleteMapping(path="/{id}")
    public DeleteAccountDtoResponse deleteAccountDtoResponse(final @PathVariable String id) {
        logger().trace("Start TX account character entity");
        boolean response = characterService.deleteCharacter(Integer.parseInt(id));
        logger().trace("Finish TX account character entity");
        if (response)
            return new DeleteAccountDtoResponse("Entity deleted successfully");
        return new DeleteAccountDtoResponse("Error will deleting entity, please check the id");
    }
}