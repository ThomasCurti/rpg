package com.mti.rpg.view;

import com.mti.rpg.domain.entity.AccountEntity;
import com.mti.rpg.domain.service.AccountService;
import com.mti.rpg.view.accountcontroller.DeleteAccountDtoResponse;
import com.mti.rpg.view.accountcontroller.FindAllAccountsDtoResponse;
import com.mti.rpg.view.accountcontroller.PutAccountDtoRequest;
import com.mti.rpg.view.accountcontroller.PutAccountDtoResponse;
import com.mti.rpg.view.accountcontroller.PutAccountJoinGuildDtoRequest;
import com.mti.rpg.view.accountcontroller.PutAccountJoinGuildDtoResponse;
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
 * @author clement.dedenis(clement.dedenis @ epita.fr)
 * @since 1.0
 */
@RestController
@RequestMapping("/account")
public class AccountController implements CanLog {

    /**
     * AccountController's accountService.
     */
    private final AccountService accountService;

    /**
     * Initializer.
     *
     * @param accountService field value.
     */
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * GET Request to find all account.
     *
     * @return FindAllAccountsDtoResponse
     */
    @GetMapping("/")
    public FindAllAccountsDtoResponse findAllAccounts() {
        logger().trace("Start TX account find all");
        final List<AccountEntity> accountEntityList = accountService.findAllAccounts();
        logger().trace("Finish TX account find all");
        return new FindAllAccountsDtoResponse(
                accountEntityList.stream()
                                 .map(accountEntity -> new FindAllAccountsDtoResponse.AccountDtoResponse(accountEntity.id,
                                                                                                         accountEntity.name))
                                 .collect(Collectors.toList()));
    }

    /**
     * PUT Request to add an account.
     *
     * @param putAccountDtoRequest The RequestBody.
     * @return PutAccountDtoResponse
     */
    @PutMapping("/")
    public PutAccountDtoResponse putAccount(final @RequestBody PutAccountDtoRequest putAccountDtoRequest) {
        final var entity = new AccountEntity(putAccountDtoRequest.id, putAccountDtoRequest.name);
        logger().trace("Start TX account save entity");
        final var result = accountService.save(entity);
        logger().trace("Finish TX account save entity");
        return new PutAccountDtoResponse(result.id, result.name);
    }

    /**
     * PUT Request to add an account to a guild.
     *
     * @param putAccountJoinGuildDtoRequest The RequestBody.
     * @return PutAccountJoinGuildDtoResponse
     */
    @PutMapping("/joinGuild/")
    public PutAccountJoinGuildDtoResponse putAccountJoinGuild(final @RequestBody PutAccountJoinGuildDtoRequest putAccountJoinGuildDtoRequest) {
        var accountEntity = new AccountEntity(putAccountJoinGuildDtoRequest.accountId, null);
        logger().trace("Start TX account save entity");
        var result = accountService.joinGuild(accountEntity, putAccountJoinGuildDtoRequest.guildId);
        logger().trace("Finish TX account save entity");
        if (result == null)
            return new PutAccountJoinGuildDtoResponse(null ,null, "Wrong id");
        return new PutAccountJoinGuildDtoResponse(result.id, result.name, null);
    }

    /**
     * DELETE Request to delete an account.
     *
     * @param id The PathVariable.
     * @return DeleteAccountDtoResponse
     */
    @DeleteMapping(path="/{id}")
    public DeleteAccountDtoResponse deleteAccount(final @PathVariable String id) {
        logger().trace("Start TX account delete entity");
        boolean response = accountService.deleteAccount(Integer.parseInt(id));
        logger().trace("Finish TX account delete entity");
        if (response)
            return new DeleteAccountDtoResponse("Entity deleted successfully");
        return new DeleteAccountDtoResponse("Error will deleting entity, please check the id");
    }
}