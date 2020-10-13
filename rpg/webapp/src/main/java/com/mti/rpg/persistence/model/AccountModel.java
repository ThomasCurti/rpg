package com.mti.rpg.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author clement.dedenis(clement.dedenis @ epita.fr)
 * @since 1.0
 */
@Entity
@Table(name = "account")
public class AccountModel {

    /**
     * Entity identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Account's name.
     */
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    /**
     * Account's guild.
     */
    @ManyToOne
    @JoinColumn(name = "guild_id", referencedColumnName = "id")
    private GuildModel guild;

    /**
     * Account's characters.
     */
    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private Collection<CharacterModel> characters;

    /**
     * Default constructor.
     */
    public AccountModel() {
    }

    /**
     * Initializer.
     *
     * @param id field value.
     * @param name field value.
     * @param guild field value.
     * @param characters field value.
     */
    public AccountModel(final Integer id,
                        final String name,
                        final GuildModel guild,
                        final Collection<CharacterModel> characters) {
        this.id = id;
        this.name = name;
        this.guild = guild;
        this.characters = characters;
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
    public void setId(Integer id) {
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
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of guild.
     *
     * @return The value of guild.
     */
    public GuildModel getGuild() {
        return guild;
    }

    /**
     * Set the value guild_id field.
     *
     * @param guild The value to set.
     */
    public void setGuild(GuildModel guild) {
        this.guild = guild;
    }

    /**
     * Get the value of characters.
     *
     * @return The value of characters.
     */
    public Collection<CharacterModel> getCharacters() {
        return characters;
    }

    /**
     * Set the value characters field.
     *
     * @param characters The value to set.
     */
    public void setCharacters(final Collection<CharacterModel> characters) {
        this.characters = characters;
    }
}