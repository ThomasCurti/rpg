package com.mti.rpg.persistence.repository;

import com.mti.rpg.persistence.model.ClassModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

/**
 * Repository that discuss with class Table
 */
public interface ClassRepository extends CrudRepository<ClassModel, Integer> {
}
