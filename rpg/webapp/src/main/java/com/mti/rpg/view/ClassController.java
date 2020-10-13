package com.mti.rpg.view;

import com.mti.rpg.domain.entity.ClassEntity;
import com.mti.rpg.domain.entity.SkillsEntity;
import com.mti.rpg.domain.service.ClassService;
import com.mti.rpg.view.accountcontroller.DeleteAccountDtoResponse;
import com.mti.rpg.view.classcontroller.DeleteClassDtoResponse;
import com.mti.rpg.view.classcontroller.FindAllClassDtoResponse;
import com.mti.rpg.view.classcontroller.PutClassDtoRequest;
import com.mti.rpg.view.classcontroller.PutClassDtoResponse;
import com.mti.rpg.view.guildcontroller.PutGuildDtoRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.CanLog;

import java.util.stream.Collectors;

/**
 * @author thomas.curti (thomas.curti@epita.fr)
 * @since 1.0
 */
@RestController
@RequestMapping("/class")
public class ClassController implements CanLog {

    /**
     * ClassController's classService.
     */
    private final ClassService classService;

    /**
     * Initializer.
     *
     * @param classService field value.
     */
    public ClassController(final ClassService classService) {
        this.classService = classService;
    }

    /**
     * GET Request to find all class.
     *
     * @return FindAllClassDtoResponse
     */
    @GetMapping("/")
    public FindAllClassDtoResponse findAllClass() {
        logger().trace("Start TX class find all");
        final var entitiesList = classService.findAllClass();
        logger().trace("Finish TX class find all");
        return new FindAllClassDtoResponse(entitiesList.stream()
                                                       .map(entity -> new FindAllClassDtoResponse.ClassDtoResponse(
                                                               entity.id,
                                                               entity.name,
                                                               entity.description,
                                                               entity.skills.stream()
                                                                            .map(skills -> new FindAllClassDtoResponse.SkillsDto(
                                                                                    skills.id,
                                                                                    skills.name,
                                                                                    skills.description)).collect(
                                                                       Collectors.toList())))
                                                       .collect(
                                                               Collectors.toList()));
    }

    /**
     * PUT Request to add a class.
     *
     * @param putClassDtoRequest The RequestBody.
     * @return PutCharacterDtoResponse
     */
    @PutMapping("/")
    public PutClassDtoResponse putClass(final @RequestBody PutClassDtoRequest putClassDtoRequest) {
        final var entity = new ClassEntity(putClassDtoRequest.id,
                                           putClassDtoRequest.name,
                                           putClassDtoRequest.description,
                                           putClassDtoRequest.skills.stream()
                                                                    .map(skill -> new SkillsEntity(skill.id,
                                                                                                   skill.name,
                                                                                                   skill.description))
                                                                    .collect(Collectors.toList()));
        logger().trace("Start TX class save entity");
        final var result = classService.save(entity);
        logger().trace("Finish TX class save entity");
        return new PutClassDtoResponse(result.id,
                                       result.name,
                                       result.description,
                                       result.skills.stream()
                                                    .map(skill -> new PutClassDtoResponse.SkillsDto(skill.id,
                                                                                                    skill.name,
                                                                                                    skill.description))
                                                    .collect(Collectors.toList()));
    }

    /**
     * DELETE Request to delete a class.
     *
     * @param id The PathVariable.
     * @return DeleteClassDtoResponse
     */
    @DeleteMapping(path="/{id}")
    public DeleteClassDtoResponse deleteClass(final @PathVariable String id) {
        logger().trace("Start TX class delete entity");
        boolean response = classService.deleteClass(Integer.parseInt(id));
        logger().trace("Finish TX class delete entity");
        if (response)
            return new DeleteClassDtoResponse("Entity deleted successfully");
        return new DeleteClassDtoResponse("Error will deleting entity, please check the id");
    }
}
