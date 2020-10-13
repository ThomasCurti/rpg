package com.mti.rpg.view.charactercontroller;

import java.util.Collection;

/**
 * @author clement.dedenis(clement.dedenis@epita.fr)
 * @since 1.0
 */
public class PutCharacterDtoResponse {

    /**
     * PutCharacterDtoResponse's id.
     */
    public final Integer id;

    /**
     * PutCharacterDtoResponse's pseudo.
     */
    public final String pseudo;

    /**
     * PutCharacterDtoResponse's classe.
     */
    public final ClassDto classe;

    /**
     * PutCharacterDtoResponse's items.
     */
    public final Collection<ItemsDto> items;

    /**
     * PutCharacterDtoResponse's pets.
     */
    public final Collection<PetDto> pets;

    /**
     * PutCharacterDtoResponse's mounts.
     */
    public final Collection<MountDbo> mounts;

    /**
     * PutCharacterDtoResponse's account.
     */
    public final AccountDto account;

    /**
     * PutCharacterDtoResponse's error.
     */
    public final String error;

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
    public PutCharacterDtoResponse(final Integer id,
                                   final String pseudo,
                                   final ClassDto classe,
                                   final Collection<ItemsDto> items,
                                   final Collection<PetDto> pets,
                                   final Collection<MountDbo> mounts,
                                   final AccountDto account,
                                   final String error) {
        this.id = id;
        this.pseudo = pseudo;
        this.classe = classe;
        this.items = items;
        this.pets = pets;
        this.mounts = mounts;
        this.account = account;
        this.error = error;
    }

    public static class ClassDto {

        /**
         * ClassDto's id.
         */
        public final Integer id;
        /**
         * ClassDto's name.
         */
        public final String name;
        /**
         * ClassDto's description.
         */
        public final String description;
        /**
         * ClassDto's skills.
         */
        public final Collection<SkillsDto> skills;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         * @param description field value.
         * @param skills field value.
         */
        public ClassDto(final Integer id,
                        final String name,
                        final String description,
                        final Collection<SkillsDto> skills) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.skills = skills;
        }
    }

    public static class ItemsDto{

        /**
         * ItemsDto's id.
         */
        public final Integer id;

        /**
         * ItemsDto's name.
         */
        public final String name ;

        /**
         * ItemsDto's description.
         */
        public final String description;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         * @param description field value.
         */
        public ItemsDto(final Integer id,final String name,final String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }

    public static class PetDto{

        /**
         * PetDto's id.
         */
        public final Integer id;

        /**
         * PetDto's name.
         */
        public final String name;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         */
        public PetDto(final Integer id, final String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class MountDbo{

        /**
         * MountDbo's id.
         */
        public final Integer id;

        /**
         * MountDbo's name.
         */
        public final String name;

        /**
         * MountDbo's speed.
         */
        public final Integer speed;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         * @param speed field value.
         */
        public MountDbo(final Integer id, final String name, final Integer speed) {
            this.id = id;
            this.name = name;
            this.speed = speed;
        }
    }

    public static class SkillsDto{
        /**
         * SkillsDto's id.
         */
        public final Integer id;

        /**
         * SkillsDto's name.
         */
        public final String name;

        /**
         * SkillsDto's description.
         */
        public final String description;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         * @param description field value.
         */
        public SkillsDto(final Integer id, final String name, final String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }

    public static class AccountDto {

        /**
         * AccountDto's id.
         */
        public final Integer id;

        /**
         * AccountDto's name.
         */
        public final String name;

        /**
         * Initializer.
         *
         * @param id field value.
         * @param name field value.
         */
        public AccountDto(final Integer id, final String name) {
            this.id = id;
            this.name = name;
        }
    }
}
