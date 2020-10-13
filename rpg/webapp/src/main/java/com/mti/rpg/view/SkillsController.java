package com.mti.rpg.view;

import com.mti.rpg.domain.entity.SkillsEntity;
import com.mti.rpg.domain.service.SkillsService;
import com.mti.rpg.view.accountcontroller.DeleteAccountDtoResponse;
import com.mti.rpg.view.skillscontroller.DeleteSkillsDtoResponse;
import com.mti.rpg.view.skillscontroller.FindAllSkillsDtoResponse;
import com.mti.rpg.view.skillscontroller.PutSkillsDtoRequest;
import com.mti.rpg.view.skillscontroller.PutSkillsDtoResponse;
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
@RequestMapping("/skills")
public class SkillsController implements CanLog {

    /**
     * SkillsController's skillsService.
     */
    private final SkillsService skillsService;

    /**
     * Initializer.
     *
     * @param skillsService field value.
     */
    public SkillsController(final SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    /**
     * GET Request to find all skill.
     *
     * @return FindAllSkillsDtoResponse
     */
    @GetMapping("/")
    public FindAllSkillsDtoResponse findAllSkills() {
        logger().trace("Start TX skills find all");
        final List<SkillsEntity> skillsIterable = skillsService.findAllSkills();
        logger().trace("Finish TX skills find all");
        return new FindAllSkillsDtoResponse(skillsIterable.stream()
                                                          .map(entity -> new FindAllSkillsDtoResponse.SkillsDtoResponse(entity.id, entity.name, entity.description))
                                                          .collect(Collectors.toList()));
    }

    /**
     * PUT Request to add an skill.
     *
     * @param putSkillsDtoRequest The RequestBody.
     * @return PutSkillsDtoResponse
     */
    @PutMapping("/")
    public PutSkillsDtoResponse putSkills(final @RequestBody PutSkillsDtoRequest putSkillsDtoRequest) {
        final var entity = new SkillsEntity(putSkillsDtoRequest.id, putSkillsDtoRequest.name, putSkillsDtoRequest.description);
        logger().trace("Start TX skills save entity");
        final var result = skillsService.saveSkillOfClass(entity, putSkillsDtoRequest.classId);
        logger().trace("Finish TX skills save entity");
        if (result == null)
            return new PutSkillsDtoResponse(null, null, null, "Wrong class id");
        return new PutSkillsDtoResponse(result.id, result.name, result.description, null);
    }

    /**
     * DELETE Request to delete an pet.
     *
     * @param id The PathVariable.
     * @return DeleteSkillsDtoResponse
     */
    @DeleteMapping(path="/{id}")
    public DeleteSkillsDtoResponse deleteSkill(final @PathVariable String id) {
        logger().trace("Start TX skills delete entity");
        boolean response = skillsService.deleteSkill(Integer.parseInt(id));
        logger().trace("Finish TX skills delete entity");
        if (response)
            return new DeleteSkillsDtoResponse("Entity deleted successfully");
        return new DeleteSkillsDtoResponse("Error will deleting entity, please check the id");
    }
}
