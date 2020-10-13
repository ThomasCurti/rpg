package com.mti.rpg.view.charactercontroller;

import java.util.Collection;

/**
 * @author clement.dedenis(clement.dedenis@epita.fr)
 * @since 1.0
 */
public class PutCharacterDtoRequest {

    /**
     * PutCharacterDtoRequest's pseudo.
     */
    public final String pseudo;

    /**
     * PutCharacterDtoRequest's classe.
     */
    public final ClassDto classe;

    /**
     * PutCharacterDtoRequest's items.
     */
    public final Collection<ItemsDto> items;

    /**
     * PutCharacterDtoRequest's pets.
     */
    public final Collection<PetDto> pets;

    /**
     * PutCharacterDtoRequest's mounts.
     */
    public final Collection<MountDbo> mounts;

    /**
     * PutCharacterDtoRequest's account.
     */
    public final AccountDto account;

    /**
     * Initializer.
     *
     * @param pseudo field value.
     * @param classe field value.
     * @param items field value.
     * @param pets field value.
     * @param mounts field value.
     * @param account field value.
     */
    public PutCharacterDtoRequest(final String pseudo,
                                  final ClassDto classe,
                                  final Collection<ItemsDto> items,
                                  final Collection<PetDto> pets,
                                  final Collection<MountDbo> mounts,
                                  final AccountDto account) {
        this.pseudo = pseudo;
        this.classe = classe;
        this.items = items;
        this.pets = pets;
        this.mounts = mounts;
        this.account = account;
    }

    public static class ClassDto {
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
         * @param name field value.
         * @param description field value.
         * @param skills field value.
         */
        public ClassDto(final String name,
                        final String description,
                        final Collection<SkillsDto> skills) {
            this.name = name;
            this.description = description;
            this.skills = skills;
        }
    }

    public static class ItemsDto{
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
         * @param name field value.
         * @param description field value.
         */
        public ItemsDto(final String name,final String description) {
            this.name = name;
            this.description = description;
        }
    }

    public static class PetDto{

        /**
         * PetDto's name.
         */
        public  String name;

        public PetDto() {
        }

        /**
         * Initializer.
         *
         * @param name field value.
         */
        public PetDto( final String name) {
            this.name = name;
        }
    }

    public static class MountDbo{

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
         * @param name field value.
         * @param speed field value.
         */
        public MountDbo(final String name, final Integer speed) {
            this.name = name;
            this.speed = speed;
        }
    }

    public static class SkillsDto{

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
         * @param name field value.
         * @param description field value.
         */
        public SkillsDto(final String name, final String description) {
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

