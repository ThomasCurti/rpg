package com.mti.rpg;

import com.mti.rpg.persistence.model.AccountModel;
import com.mti.rpg.persistence.model.CharacterModel;
import com.mti.rpg.persistence.model.ClassModel;
import com.mti.rpg.persistence.model.GuildModel;
import com.mti.rpg.persistence.model.ItemsModel;
import com.mti.rpg.persistence.model.MountModel;
import com.mti.rpg.persistence.model.PetModel;
import com.mti.rpg.persistence.model.SkillsModel;
import com.mti.rpg.persistence.repository.AccountRepository;
import com.mti.rpg.persistence.repository.CharacterRepository;
import com.mti.rpg.persistence.repository.ClassRepository;
import com.mti.rpg.persistence.repository.GuildRepository;
import com.mti.rpg.persistence.repository.ItemsRepository;
import com.mti.rpg.persistence.repository.MountRepository;
import com.mti.rpg.persistence.repository.PetRepository;
import com.mti.rpg.persistence.repository.SkillsRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author thomas.curti (thomas.curti@epita.fr)
 * @since 1.0
 */

@Configuration
@EnableJpaRepositories(basePackageClasses = {AccountRepository.class, AccountModel.class, CharacterRepository.class,
        CharacterModel.class, ClassRepository.class, ClassModel.class, GuildRepository.class, GuildModel.class,
        ItemsRepository.class, ItemsModel.class, MountRepository.class, MountModel.class, PetRepository.class,
        PetModel.class, SkillsRepository.class, SkillsModel.class})
public class RpgConfiguration {
}
