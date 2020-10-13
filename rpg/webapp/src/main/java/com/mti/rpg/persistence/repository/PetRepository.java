package com.mti.rpg.persistence.repository;

import com.mti.rpg.persistence.model.PetModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

/**
 * Repository that discuss with pet Table
 */
public interface PetRepository extends CrudRepository<PetModel, Integer> {
}
