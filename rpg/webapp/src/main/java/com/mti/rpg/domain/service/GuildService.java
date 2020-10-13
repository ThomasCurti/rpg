package com.mti.rpg.domain.service;

import com.mti.rpg.domain.entity.GuildEntity;
import com.mti.rpg.modeltoentity.AccountModelToEntity;
import com.mti.rpg.modeltoentity.GuildModelToEntity;
import com.mti.rpg.persistence.repository.GuildRepository;
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
public class GuildService implements CanLog {

    /**
     * GuildService's guildRepository.
     */
    private final GuildRepository guildRepository;

    /**
     * GuildService's guildModelToEntity.
     */
    private final GuildModelToEntity guildModelToEntity;

    /**
     * Initializer.
     *
     * @param guildRepository field value.
     * @param guildModelToEntity field value.
     */
    public GuildService(final GuildRepository guildRepository,
                        final GuildModelToEntity guildModelToEntity) {
        this.guildRepository = guildRepository;
        this.guildModelToEntity = guildModelToEntity;
    }

    /**
     * Find all guild.
     *
     * @return the list of all guild.
     */
    public List<GuildEntity> findAllGuilds(){
        logger().trace("Start find all guilds");
        final var guildModelIterable = guildRepository.findAll();
        logger().trace("Found all guilds & cast Iterable to List");
        final var guildModelList = IterableUtils.toList(guildModelIterable);
        final var guildEntityList = guildModelToEntity.convertList(guildModelList);

        return guildEntityList;
    }

    /**
     * Find an guild by id.
     *
     * @param id The id of guild to find.
     * @return The guild.
     */
    public GuildEntity findGuildById(Integer id){
        logger().trace("Start find guild " + id.toString());
        final var guildModel = guildRepository.findById(id);
        if (guildModel.isEmpty()) {
            logger().warn("Didn't find guild " + id.toString());
            return null;
        }
        logger().trace("Found guild " + id.toString());
        final var guildEntity = guildModelToEntity.convert(guildModel.get());

        return guildEntity;
    }

    /**
     * Transaction to save an guild.
     *
     * @param guildEntity The guild which will be added or updated.
     *
     * @return The guild updated.
     */
    @Transactional
    public GuildEntity save(GuildEntity guildEntity) {
        logger().trace("Start Guild account in service");
        final var guildModel = guildModelToEntity.revertConvert(guildEntity);
        final var resultModel = guildRepository.save(guildModel);
        final var resultEntity = guildModelToEntity.convert(resultModel);
        logger().trace("Finish Guild account in service");
        return resultEntity;
    }

    /**
     * Transaction to delete an guild.
     *
     * @param guildId The guild id which will be deleted.
     *
     * @return Boolean.
     */
    @Transactional
    public boolean deleteGuild(final Integer guildId) {
        logger().trace("Start delete guild in service");
        var guildModel = guildRepository.findById(guildId);
        if (guildModel.isEmpty()) {
            logger().warn("Didn't find guild to delete in service " + guildId);
            return false;
        }

        guildRepository.delete(guildModel.get());
        logger().trace("Finish delete guild in service");
        return true;
    }
}
