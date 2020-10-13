package com.mti.rpg.persistence.repository;

import com.mti.rpg.persistence.model.AccountModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */

/**
 * Repository that discuss with account Table
 */
public interface AccountRepository extends CrudRepository<AccountModel, Integer> {
}
