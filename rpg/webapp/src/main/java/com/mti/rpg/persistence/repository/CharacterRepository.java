package com.mti.rpg.persistence.repository;

import com.mti.rpg.persistence.model.CharacterModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

/**
 * Repository that discuss with character Table
 */
public interface CharacterRepository extends CrudRepository<CharacterModel, Integer> {
}
