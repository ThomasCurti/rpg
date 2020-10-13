package com.mti.rpg.persistence.repository;

import com.mti.rpg.persistence.model.ItemsModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

/**
 * Repository that discuss with items Table
 */
public interface ItemsRepository extends CrudRepository<ItemsModel, Integer> {
}
