package com.mti.rpg.view;

import com.mti.rpg.domain.entity.ItemsEntity;
import com.mti.rpg.domain.service.ItemsService;
import com.mti.rpg.persistence.model.ItemsModel;
import com.mti.rpg.view.accountcontroller.DeleteAccountDtoResponse;
import com.mti.rpg.view.itemscontroller.DeleteitemsDtoResponse;
import com.mti.rpg.view.itemscontroller.FindAllItemsDtoResponse;
import com.mti.rpg.view.itemscontroller.PutItemsDtoRequest;
import com.mti.rpg.view.itemscontroller.PutItemsDtoResponse;
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
@RequestMapping("/item")
public class ItemsController implements CanLog {

    /**
     * ItemsController's itemsService.
     */
    private final ItemsService itemsService;

    /**
     * Initializer.
     *
     * @param itemsService field value.
     */
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    /**
     * GET Request to find all items.
     *
     * @return FindAllItemsDtoResponse
     */
    @GetMapping("/")
    public FindAllItemsDtoResponse findAllItems() {
        logger().trace("Start TX item find all");
        final List<ItemsEntity> serviceResponse = itemsService.findAllItems();
        logger().trace("Finish TX item find all");
        final var responseObjects = serviceResponse.stream()
                                             .map(entity -> new FindAllItemsDtoResponse.itemDtoResponse(
                                                     entity.id,
                                                     entity.name,
                                                     entity.description))
                                                    .collect(Collectors.toList());
        final var response = new FindAllItemsDtoResponse(responseObjects);
        return response;
    }

    /**
     * PUT Request to add an item.
     *
     * @param putItemsDtoRequest The RequestBody.
     * @return PutItemsDtoResponse
     */
    @PutMapping("/")
    public PutItemsDtoResponse putItems(final @RequestBody PutItemsDtoRequest putItemsDtoRequest) {

        final var entity = new ItemsEntity(putItemsDtoRequest.id, putItemsDtoRequest.name, putItemsDtoRequest.description);
        logger().trace("Start TX items save entity");
        final var result = itemsService.saveItemToCharacter(entity, putItemsDtoRequest.characterId);
        logger().trace("Finish TX items save entity");
        if (result == null) {
            return new PutItemsDtoResponse(null, null, null, "Wrong character Id");
        }
        return new PutItemsDtoResponse(result.id, result.name, result.description, null);
    }

    /**
     * DELETE Request to delete an item.
     *
     * @param id The PathVariable.
     * @return DeleteitemsDtoResponse
     */
    @DeleteMapping(path="/{id}")
    public DeleteitemsDtoResponse deleteItem(final @PathVariable String id) {
        logger().trace("Start TX items delete entity");
        boolean response = itemsService.deleteItem(Integer.parseInt(id));
        logger().trace("Finish TX items delete entity");
        if (response)
            return new DeleteitemsDtoResponse("Entity deleted successfully");
        return new DeleteitemsDtoResponse("Error will deleting entity, please check the id");
    }
}
