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
@Table(name = "characters")
public class CharacterModel {

    /**
     * Entity identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Characters's pseudo.
     */
    @Column(name = "pseudo", nullable = false, length = 20)
    private String pseudo;

    /**
     * Characters's classe.
     */
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassModel classe;

    /**
     * Characters's account.
     */
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountModel account;

    /**
     * Characters's items.
     */
    @OneToMany(mappedBy = "characters", cascade = CascadeType.REMOVE)
    private Collection<ItemsModel> items;

    /**
     * Characters's pets.
     */
    @OneToMany(mappedBy = "character", cascade = CascadeType.REMOVE)
    private Collection<PetModel> pets;

    /**
     * Characters's mounts.
     */
    @OneToMany(mappedBy = "character", cascade = CascadeType.REMOVE)
    private Collection<MountModel> mounts;

    /**
     * Default constructor.
     */
    public CharacterModel() {
    }

    /**
     * Initializer.
     *
     * @param id field value.
     * @param pseudo field value.
     * @param classe field value.
     * @param items field value.
     * @param pets field value.
     * @param mounts field value.
     * @param account field value.
     */
    public CharacterModel(final Integer id,
                          final String pseudo,
                          final ClassModel classe,
                          final Collection<ItemsModel> items,
                          final Collection<PetModel> pets,
                          final Collection<MountModel> mounts,
                          final AccountModel account) {
        this.id = id;
        this.pseudo = pseudo;
        this.classe = classe;
        this.items = items;
        this.pets = pets;
        this.mounts = mounts;
        this.account = account;
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
     * Get the value of pseudo.
     *
     * @return The value of pseudo.
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Set the value pseudo field.
     *
     * @param pseudo The value to set.
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Get the value of classe.
     *
     * @return The value of classe.
     */
    public ClassModel getClasse() {
        return classe;
    }

    /**
     * Set the value of classe.
     *
     * @param classe The value to set.
     */
    public void setClasse(final ClassModel classe) {
        this.classe = classe;
    }

    /**
     * Get the value of items.
     *
     * @return The value of items.
     */
    public Collection<ItemsModel> getItems() {
        return items;
    }

    /**
     * Set the value pseudo items.
     *
     * @param items The value to set.
     */
    public void setItems(final Collection<ItemsModel> items) {
        this.items = items;
    }

    /**
     * Get the value of pets.
     *
     * @return The value of pets.
     */
    public Collection<PetModel> getPets() {
        return pets;
    }

    /**
     * Set the value pseudo pets.
     *
     * @param pets The value to set.
     */
    public void setPets(final Collection<PetModel> pets) {
        this.pets = pets;
    }

    /**
     * Get the value of mounts.
     *
     * @return The value of mounts.
     */
    public Collection<MountModel> getMounts() {
        return mounts;
    }

    /**
     * Set the value pseudo mounts.
     *
     * @param mounts The value to set.
     */
    public void setMounts(final Collection<MountModel> mounts) {
        this.mounts = mounts;
    }

    /**
     * Get the value of account.
     *
     * @return The value of account.
     */
    public AccountModel getAccount() {
        return account;
    }

    /**
     * Set the value pseudo account.
     *
     * @param account The value to set.
     */
    public void setAccount(final AccountModel account) {
        this.account = account;
    }
}