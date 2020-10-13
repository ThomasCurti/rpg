package com.mti.rpg.domain.service;

import com.mti.rpg.domain.entity.AccountEntity;
import com.mti.rpg.domain.entity.GuildEntity;
import com.mti.rpg.modeltoentity.AccountModelToEntity;
import com.mti.rpg.modeltoentity.GuildModelToEntity;
import com.mti.rpg.persistence.repository.AccountRepository;
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
public class AccountService implements CanLog {

    /**
     * AccountService's accountRepository.
     */
    private final AccountRepository accountRepository;

    /**
     * AccountService's accountModelToEntity.
     */
    private final AccountModelToEntity accountModelToEntity;

    /**
     * AccountService's guildModelToEntity.
     */
    private final GuildModelToEntity guildModelToEntity;

    /**
     * AccountService's guildService.
     */
    private final GuildService guildService;

    /**
     * Initializer.
     *
     * @param accountRepository field value.
     * @param accountModelToEntity field value.
     * @param guildModelToEntity field value.
     * @param guildService field value.
     */
    public AccountService(final AccountRepository accountRepository,
                          final AccountModelToEntity accountModelToEntity,
                          final GuildModelToEntity guildModelToEntity, final GuildService guildService) {
        this.accountRepository = accountRepository;
        this.accountModelToEntity = accountModelToEntity;
        this.guildModelToEntity = guildModelToEntity;
        this.guildService = guildService;
    }

    /**
     * Find all Accounts.
     *
     * @return the list of all accounts.
     */
    public List<AccountEntity> findAllAccounts() {
        logger().trace("Start find all accounts");
        final var accountsIterable = accountRepository.findAll();
        logger().trace("Found all accounts & cast Iterable to List");
        final var accountsList = IterableUtils.toList(accountsIterable);
        final var accountEntityList = accountModelToEntity.convertList(accountsList);
        return accountEntityList;
    }

    /**
     * Find an account by id.
     *
     * @param id The id of account to find.
     * @return The account.
     */
    public AccountEntity findAccountById(Integer id) {
        logger().trace("Start find account " + id.toString());
        final var accountModel = accountRepository.findById(id);
        if (accountModel.isEmpty()) {
            logger().warn("Didn't find account " + id.toString());
            return null;
        }
        logger().trace("Found account " + id.toString());
        return accountModelToEntity.convert(accountModel.get());
    }

    /**
     * Join a guild.
     *
     * @param accountEntity The  account which join the guild.
     * @param guildId The id of the guild.
     *
     * @return The account updated.
     */
    public AccountEntity joinGuild(AccountEntity accountEntity, Integer guildId) {
        logger().trace("Start find account " + accountEntity.id.toString());
        var accountModel = accountRepository.findById(accountEntity.id);
        if (accountModel.isEmpty()) {
            logger().warn("Didn't find account " + accountEntity.id.toString());
            return null;
        }
        logger().trace("Account found" + accountEntity.id.toString());
        logger().trace("Start find guild " + guildId.toString());
        var guildEntity = guildService.findGuildById(guildId);
        if (guildEntity == null) {
            logger().warn("Didn't find guild " + guildId.toString());
            return null;
        }
        logger().trace("Guild found " + guildId.toString());

        accountModel.get().setGuild(guildModelToEntity.revertConvert(guildEntity));
        //calls the update

        logger().trace("Update guild " + guildId.toString());
        var result = accountRepository.save(accountModel.get());
        return accountModelToEntity.convert(result);
    }

    /**
     * Transaction to save an account.
     *
     * @param accountEntity The  account which will add or update.
     *
     * @return The account updated.
     */
    @Transactional
    public AccountEntity save(final AccountEntity accountEntity) {
        logger().trace("Start Save account in service");
        final var accountModel = accountModelToEntity.revertConvert(accountEntity);
        final var resultModel = accountRepository.save(accountModel);
        final var resultEntity = accountModelToEntity.convert(resultModel);
        logger().trace("Finish Save account in service");
        return resultEntity;
    }

    /**
     * Transaction to delete an account.
     *
     * @param accountId The account id which will be deleted.
     *
     * @return Boolean.
     */
    @Transactional
    public boolean deleteAccount(final Integer accountId) {
        logger().trace("Start delete account in service");
        var accountModel = accountRepository.findById(accountId);
        if (accountModel.isEmpty()) {
            logger().warn("Didn't find account to delete in service " + accountId);
            return false;
        }
        accountRepository.delete(accountModel.get());
        logger().trace("Finish delete account in service");
        return true;
    }
}
