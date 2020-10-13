package com.mti.rpg.view;

import com.mti.rpg.domain.entity.MountEntity;
import com.mti.rpg.domain.service.MountService;
import com.mti.rpg.persistence.model.MountModel;
import com.mti.rpg.view.accountcontroller.DeleteAccountDtoResponse;
import com.mti.rpg.view.mountcontroller.DeleteMountDtoResponse;
import com.mti.rpg.view.mountcontroller.FindAllMountDtoResponse;
import com.mti.rpg.view.mountcontroller.PutMountDtoRequest;
import com.mti.rpg.view.mountcontroller.PutMountDtoResponse;
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
 * @author jeremie.piro (jeremie.piro@epita.fr)
 * @since 1.0
 */
@RestController
@RequestMapping("/mount")
public class MountController implements CanLog {

    /**
     * MountController's mountService.
     */
    private final MountService mountService;

    /**
     * Initializer.
     *
     * @param mountService field value.
     */
    public MountController(MountService mountService) {
        this.mountService = mountService;
    }

    /**
     * GET Request to find all mount.
     *
     * @return FindAllMountDtoResponse
     */
    @GetMapping("/")
    public FindAllMountDtoResponse findAllMount() {
        logger().trace("Start TX mount save entity");
        final List<MountEntity> serviceResponse = mountService.findAllMount();
        logger().trace("Finish TX mount save entity");
        final var responseObjects = serviceResponse.stream()
                                                   .map(entity -> new FindAllMountDtoResponse.mountDtoResponse(
                                                           entity.id,
                                                           entity.name,
                                                           entity.speed)).collect(Collectors.toList());
        final var response = new FindAllMountDtoResponse(responseObjects);
        return response;
    }

    /**
     * PUT Request to add an mount.
     *
     * @param putMountDtoRequest The RequestBody.
     * @return PutMountDtoResponse
     */
    @PutMapping("/")
    public PutMountDtoResponse putMount(final @RequestBody PutMountDtoRequest putMountDtoRequest) {
        final var entity = new MountEntity(putMountDtoRequest.id, putMountDtoRequest.name, putMountDtoRequest.speed);
        logger().trace("Start TX mount save entity");
        final var result = mountService.saveMountToCharacter(entity, putMountDtoRequest.characterId);
        logger().trace("Finish TX mount save entity");
        if (result == null)
            return new PutMountDtoResponse(null, null, null, "Wrong character id");
        return new PutMountDtoResponse(result.id, result.name, result.speed, null);
    }

    /**
     * DELETE Request to delete an mount.
     *
     * @param id The PathVariable.
     * @return DeleteMountDtoResponse
     */
    @DeleteMapping(path="/{id}")
    public DeleteMountDtoResponse deleteMount(final @PathVariable String id) {
        logger().trace("Start TX mount delete entity");
        boolean response = mountService.deleteMount(Integer.parseInt(id));
        logger().trace("Finish TX mount delete entity");
        if (response)
            return new DeleteMountDtoResponse("Entity deleted successfully");
        return new DeleteMountDtoResponse("Error will deleting entity, please check the id");
    }
}
