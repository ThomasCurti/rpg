package com.mti.rpg.view;

import com.mti.rpg.domain.entity.PetEntity;
import com.mti.rpg.domain.service.PetService;
import com.mti.rpg.view.accountcontroller.DeleteAccountDtoResponse;
import com.mti.rpg.view.petcontroller.DeletePetDtoResponse;
import com.mti.rpg.view.petcontroller.FindAllPetsDtoResponse;
import com.mti.rpg.view.petcontroller.PutPetDtoRequest;
import com.mti.rpg.view.petcontroller.PutPetDtoResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.CanLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vincent1.masson (vincent1.masson@epita.fr)
 * @since 1.0
 */
@RestController
@RequestMapping("/pet")
public class PetController implements CanLog {

    /**
     * PetController's petService.
     */
    private final PetService petService;

    /**
     * Initializer.
     *
     * @param petService field value.
     */
    public PetController(final PetService petService) {
        this.petService = petService;
    }

    /**
     * GET Request to find all pet.
     *
     * @return FindAllPetsDtoResponse
     */
    @GetMapping("/")
    public FindAllPetsDtoResponse findAllPets() {
        logger().trace("Start TX pets save entity");
        final List<PetEntity> petIterable = petService.findAllPets();
        logger().trace("Finish TX pets save entity");
        return new FindAllPetsDtoResponse(petIterable.stream()
                                                     .map(entity -> new FindAllPetsDtoResponse.PetDtoResponse(entity.id, entity.name))
                                                     .collect(Collectors.toList()));
    }

    /**
     * PUT Request to add an pet.
     *
     * @param putPetDtoRequest The RequestBody.
     * @return putPetDtoRequest
     */
    @PutMapping("/")
    public PutPetDtoResponse putPet(final @RequestBody PutPetDtoRequest putPetDtoRequest) {
        final var entity = new PetEntity(putPetDtoRequest.id, putPetDtoRequest.name);
        logger().trace("Start TX pet save entity");
        final var result = petService.savePetToCharacter(entity, putPetDtoRequest.characterId);
        logger().trace("Finish TX pet save entity");
        if (result == null) {
            return new PutPetDtoResponse(null, null, "Wrong character id");
        }
        return new PutPetDtoResponse(result.id, result.name, null);
    }

    /**
     * DELETE Request to delete an pet.
     *
     * @param id The PathVariable.
     * @return DeletePetDtoResponse
     */
    @DeleteMapping(path="/{id}")
    public DeletePetDtoResponse deletePet(final @PathVariable String id) {
        logger().trace("Start TX pet delete entity");
        boolean response = petService.deletePet(Integer.parseInt(id));
        logger().trace("Finish TX pet delete entity");
        if (response)
            return new DeletePetDtoResponse("Entity deleted successfully");
        return new DeletePetDtoResponse("Error will deleting entity, please check the id");
    }
}
