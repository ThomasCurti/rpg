package com.mti.rpg.persistence.repository;

import com.mti.rpg.persistence.model.GuildModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

/**
 * Repository that discuss with guild Table
 */
public interface GuildRepository extends CrudRepository<GuildModel, Integer> {
}
