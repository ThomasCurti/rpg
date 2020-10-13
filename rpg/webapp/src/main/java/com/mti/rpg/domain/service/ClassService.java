package com.mti.rpg.domain.service;

import com.mti.rpg.domain.entity.ClassEntity;
import com.mti.rpg.modeltoentity.ClassModelToEntity;
import com.mti.rpg.persistence.repository.ClassRepository;
import org.springframework.stereotype.Service;
import utils.CanLog;
import utils.IterableUtils;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author thomas.curti(thomas.curti @ epita.fr)
 * @since 1.0
 */
@Service
public class ClassService implements CanLog {

    /**
     * ClassService's classRepository.
     */
    private final ClassRepository classRepository;

    /**
     * ClassService's classModelToEntity.
     */
    private final ClassModelToEntity classModelToEntity;

    /**
     * Initializer.
     *
     * @param classRepository field value.
     * @param classModelToEntity field value.
     */
    public ClassService(final ClassRepository classRepository, final ClassModelToEntity classModelToEntity) {
        this.classRepository = classRepository;
        this.classModelToEntity = classModelToEntity;
    }

    /**
     * Find all class.
     *
     * @return the list of all class.
     */
    public List<ClassEntity> findAllClass() {
        logger().trace("Start find all class");
        final var classIterable = classRepository.findAll();
        logger().trace("Found all class & cast Iterable to List");
        final var classList = IterableUtils.toList(classIterable);
        final var classEntityList = classModelToEntity.convertList(classList);
        return classEntityList;
    }

    /**
     * Find an class by id.
     *
     * @param id The id of class to find.
     * @return The class.
     */
    public ClassEntity findClassById(Integer id) {
        logger().trace("Start find class " + id.toString());
        final var classmodel = classRepository.findById(id);
        if (classmodel.isEmpty()) {
            logger().warn("Didn't find class " + id.toString());
            return null;
        }
        logger().trace("Found class " + id.toString());
        final var classEntity = classModelToEntity.convert(classmodel.get());
        return classEntity;
    }

    /**
     * Transaction to save an class.
     *
     * @param classEntity The class which will be added or updated.
     *
     * @return The class updated.
     */
    @Transactional
    public ClassEntity save(final ClassEntity classEntity) {
        logger().trace("Start Save class in service");
        final var classModel = classModelToEntity.revertConvert(classEntity);
        final var resultModel = classRepository.save(classModel);
        final var resultEntity = classModelToEntity.convert(resultModel);
        logger().trace("Finish Save class in service");
        return resultEntity;
    }

    /**
     * Transaction to delete an class.
     *
     * @param classId The class id which will be deleted.
     *
     * @return Boolean.
     */
    @Transactional
    public boolean deleteClass(final Integer classId) {
        logger().trace("Start delete class in service");
        var classModel = classRepository.findById(classId);
        if (classModel.isEmpty()) {
            logger().warn("Didn't find class to delete in service " + classId);
            return false;
        }

        classRepository.delete(classModel.get());
        logger().trace("Finish delete class in service");
        return true;
    }
}
