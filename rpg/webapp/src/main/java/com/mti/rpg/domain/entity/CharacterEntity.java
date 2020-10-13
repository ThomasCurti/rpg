package com.mti.rpg.domain.entity;

import java.util.Collection;

/**
 * @author thomas.curti(thomas.curti@epita.fr)
 * @since 1.0
 */
public class CharacterEntity {

    /**
     * CharacterEntity's id.
     */
    public final Integer id;

    /**
     * CharacterEntity's pseudo.
     */
    public final String pseudo;

    /**
     * CharacterEntity's classe.
     */
    public final ClassEntity classe;

    /**
     * CharacterEntity's items.
     */
    public final Collection<ItemsEntity> items;

    /**
     * CharacterEntity's pets.
     */
    public final Collection<PetEntity> pets;

    /**
     * CharacterEntity's mounts.
     */
    public final Collection<MountEntity> mounts;

    /**
     * CharacterEntity's account.
     */
    public final AccountEntity account;

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
    public CharacterEntity(final Integer id, final String pseudo, final ClassEntity classe,
                            final Collection<ItemsEntity> items,
                            final Collection<PetEntity> pets,
                            final Collection<MountEntity> mounts,
                            final AccountEntity account) {
        this.id = id;
        this.pseudo = pseudo;
        this.classe = classe;
        this.items = items;
        this.pets = pets;
        this.mounts = mounts;
        this.account = account;
    }
}
