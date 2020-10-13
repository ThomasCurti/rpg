package com.mti.rpg.persistence.repository;

import com.mti.rpg.persistence.model.SkillsModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

/**
 * Repository that discuss with skills Table
 */
public interface SkillsRepository extends CrudRepository<SkillsModel, Integer> {
}
