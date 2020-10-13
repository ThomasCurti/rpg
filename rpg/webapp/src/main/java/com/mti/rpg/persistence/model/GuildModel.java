package com.mti.rpg.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author thomas.curti(thomas.curti @ epita.fr)
 * @since 1.0
 */
@Entity
@Table(name = "guild")
public class GuildModel {

    /**
     * Entity identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Guild's name.
     */
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    /**
     * Guild's level.
     */
    @Column(name = "level", nullable = false)
    private Integer level;

    /**
     * Guild's slogan.
     */
    @Column(name = "slogan", length = 100, nullable = false)
    private String slogan;

    /**
     * Guild's accounts.
     */
    @OneToMany(mappedBy = "guild", cascade = CascadeType.REMOVE)
    private Collection<AccountModel> accounts;

    /**
     * Default constructor.
     */
    public GuildModel() {
    }

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param level field value.
     * @param slogan field value.
     * @param accounts field value.
     */
    public GuildModel(final Integer id,
                      final String name,
                      final Integer level,
                      final String slogan,
                      final Collection<AccountModel> accounts) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.slogan = slogan;
        this.accounts = accounts;
    }


    /**
     * Get the value of id.
     *
     * @return The value of id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the value id field.
     *
     * @param id The value to set.
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Get the value of name.
     *
     * @return The value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value name field.
     *
     * @param name The value to set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get the value of level.
     *
     * @return The value of level.
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Set the value level field.
     *
     * @param level The value to set.
     */
    public void setLevel(final Integer level) {
        this.level = level;
    }

    /**
     * Get the value of slogan.
     *
     * @return The value of slogan.
     */
    public String getSlogan() {
        return slogan;
    }

    /**
     * Set the value slogan field.
     *
     * @param slogan The value to set.
     */
    public void setSlogan(final String slogan) {
        this.slogan = slogan;
    }

    /**
     * Get the value of accounts.
     *
     * @return The value of accounts.
     */
    public Collection<AccountModel> getAccounts() {
        return accounts;
    }

    /**
     * Set the value slogan field.
     *
     * @param accounts The value to set.
     */
    public void setAccounts(final Collection<AccountModel> accounts) {
        this.accounts = accounts;
    }
}
