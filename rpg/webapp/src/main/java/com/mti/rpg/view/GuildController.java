package com.mti.rpg.view;

import com.mti.rpg.domain.entity.AccountEntity;
import com.mti.rpg.domain.entity.GuildEntity;
import com.mti.rpg.domain.service.GuildService;
import com.mti.rpg.view.accountcontroller.DeleteAccountDtoResponse;
import com.mti.rpg.view.guildcontroller.DeleteGuildDtoResponse;
import com.mti.rpg.view.guildcontroller.FindAllGuildsDtoResponse;
import com.mti.rpg.view.guildcontroller.PutGuildDtoRequest;
import com.mti.rpg.view.guildcontroller.PutGuildDtoResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.CanLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author thomas.curti (thomas.curti@epita.fr)
 * @since 1.0
 */
@RestController
@RequestMapping("/guild")
public class GuildController implements CanLog {

    /**
     * GuildController's guildService.
     */
    private final GuildService guildService;

    /**
     * Initializer.
     *
     * @param guildService field value.
     */
    public GuildController(final GuildService guildService) {
        this.guildService = guildService;
    }

    /**
     * GET Request to find all guild.
     *
     * @return FindAllGuildsDtoResponse
     */
    @GetMapping("/")
    public FindAllGuildsDtoResponse findAllGuilds() {
        logger().trace("Start TX guild find all");
        final List<GuildEntity> entitiesList = guildService.findAllGuilds();
        logger().trace("Finish TX guild find all");
        return new FindAllGuildsDtoResponse(entitiesList.stream()
                                                        .map(entity -> new FindAllGuildsDtoResponse.GuildsDtoResponse(
                                                                entity.id,
                                                                entity.name,
                                                                entity.level,
                                                                entity.slogan,
                                                                entity.accounts.stream()
                                                                               .map(account -> new FindAllGuildsDtoResponse.GuildsDtoResponse.AccountDto(
                                                                                       account.id,
                                                                                       account.name))
                                                                               .collect(Collectors.toList())))
                                                        .collect(Collectors.toList()));
    }

    /**
     * PUT Request to add a guild.
     *
     * @param putGuildDtoRequest The RequestBody.
     * @return PutGuildDtoResponse
     */
    @PutMapping("/")
    public PutGuildDtoResponse putGuild(final @RequestBody PutGuildDtoRequest putGuildDtoRequest) {
        final var entity = new GuildEntity(putGuildDtoRequest.id,
                                           putGuildDtoRequest.name,
                                           putGuildDtoRequest.level,
                                           putGuildDtoRequest.slogan,
                                           null);

        logger().trace("Start TX guild save entity");
        final var result = guildService.save(entity);
        logger().trace("Finish TX guild save entity");

        return new PutGuildDtoResponse(result.id,
                                       result.name,
                                       result.level,
                                       result.slogan);
    }

    /**
     * DELETE Request to delete a guild.
     *
     * @param id The PathVariable.
     * @return DeleteGuildDtoResponse
     */
    @DeleteMapping(path="/{id}")
    public DeleteGuildDtoResponse deleteGuild(final @PathVariable String id) {
        logger().trace("Start TX guild delete entity");
        boolean response = guildService.deleteGuild(Integer.parseInt(id));
        logger().trace("Finish TX guild delete entity");
        if (response)
            return new DeleteGuildDtoResponse("Entity deleted successfully");
        return new DeleteGuildDtoResponse("Error will deleting entity, please check the id");
    }
}
