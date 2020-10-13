package com.mti.rpg.persistence.repository;

import com.mti.rpg.persistence.model.MountModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

/**
 * Repository that discuss with mount Table
 */
public interface MountRepository extends CrudRepository<MountModel, Integer> {
}
