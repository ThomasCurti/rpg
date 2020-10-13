package com.mti.rpg.domain.service;

import com.mti.rpg.domain.entity.ClassEntity;
import com.mti.rpg.domain.entity.SkillsEntity;
import com.mti.rpg.modeltoentity.ClassModelToEntity;
import com.mti.rpg.modeltoentity.SkillsModelToEntity;
import com.mti.rpg.persistence.repository.SkillsRepository;
import org.springframework.stereotype.Service;
import utils.CanLog;
import utils.IterableUtils;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * @author vincent1.masson (vincent1.masson@epita.fr)
 * @since 1.0
 */
@Service
public class SkillsService implements CanLog {

    /**
     * SkillsService's skillsRepository.
     */
    private final SkillsRepository skillsRepository;

    /**
     * SkillsService's skillsModelToEntity.
     */
    private final SkillsModelToEntity skillsModelToEntity;

    /**
     * SkillsService's classModelToEntity.
     */
    private final ClassModelToEntity classModelToEntity;

    /**
     * SkillsService's classService.
     */
    private final ClassService classService;

    /**
     * Initializer.
     *
     * @param skillsRepository field value.
     * @param skillsModelToEntity field value.
     * @param classModelToEntity field value.
     * @param classService field value.
     */
    public SkillsService(final com.mti.rpg.persistence.repository.SkillsRepository skillsRepository,
                         final com.mti.rpg.modeltoentity.SkillsModelToEntity skillsModelToEntity,
                         final ClassModelToEntity classModelToEntity, final ClassService classService) {
        this.skillsRepository = skillsRepository;
        this.skillsModelToEntity = skillsModelToEntity;
        this.classModelToEntity = classModelToEntity;
        this.classService = classService;
    }

    /**
     * Find all skills.
     *
     * @return the list of all skills.
     */
    public List<SkillsEntity> findAllSkills() {
        logger().trace("Start find all skills");
        final var SkillsModelIterable = skillsRepository.findAll();
        logger().trace("Found all skills & cast Iterable to List");
        final var SkillsModelList = IterableUtils.toList(SkillsModelIterable);

        return skillsModelToEntity.convertList(SkillsModelList);
    }

    /**
     * Transaction to save a skill to a class.
     *
     * @param entity The pet which will be added or updated.
     * @param classId The class id associated to the skill.
     * @return The pet updated.
     */
    @Transactional
    public SkillsEntity saveSkillOfClass(final SkillsEntity entity, final Integer classId) {

        logger().trace("Start Save skills in service");
        final var classEntity = classService.findClassById(classId);
        if (classEntity == null) {
            logger().warn("Didn't find skills in Skillsservice");
            return null;
        }

        final var skillModel = skillsModelToEntity.revertConvert(entity);
        skillModel.setClasse(classModelToEntity.revertConvert(classEntity));
        final var resultModel = skillsRepository.save(skillModel);
        logger().trace("Finish Save skills in service");
        return skillsModelToEntity.convert(resultModel);
    }

    /**
     * Transaction to save a list of skills to a class.
     *
     * @param entity The list of skills which will be added or updated.
     * @param classEntity The class associated to the skill.
     * @return The list of skills updated.
     */
    @Transactional
    public Collection<SkillsEntity> saveAll(final Collection<SkillsEntity> entity, final ClassEntity classEntity) {

        logger().trace("Start SaveAll skills in service");
        final var skillsModel = skillsModelToEntity.revertConvertList(entity);

        final var classModel = classModelToEntity.revertConvert(classEntity);
        skillsModel.stream().forEach(skill -> skill.setClasse(classModel));

        final var resultModel = skillsRepository.saveAll(skillsModel);
        final var resultModelList = IterableUtils.toList(resultModel);
        logger().trace("Finish SaveAll skills in service");
        return skillsModelToEntity.convertList(resultModelList);
    }

    /**
     * Transaction to delete an skills.
     *
     * @param skillId The skill id which will be deleted.
     *
     * @return Boolean.
     */
    @Transactional
    public boolean deleteSkill(final Integer skillId) {
        logger().trace("Start delete skills in service");
        var skillModel = skillsRepository.findById(skillId);
        if (skillModel.isEmpty()) {
            logger().warn("Didn't find skills to delete in service " + skillId);
            return false;
        }

        skillsRepository.delete(skillModel.get());
        logger().trace("Finish delete skills in service");
        return true;
    }
}
