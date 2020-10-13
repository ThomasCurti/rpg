package com.mti.rpg.view.charactercontroller;

import java.util.Collection;

/**
 * @author clement.dedenis(clement.dedenis@epita.fr)
 * @since 1.0
 */
public class FindAllCharacterDtoResponse {

    /**
     * FindAllCharacterDtoResponse's characterList.
     */
    public final Iterable<FindAllCharacterDtoResponse.CharacterDtoResponse> characterList;

    /**
     * Initializer.
     *
     * @param characterList field value.
     */
    public FindAllCharacterDtoResponse(final Iterable<FindAllCharacterDtoResponse.CharacterDtoResponse> characterList) {
        this.characterList = characterList;
    }

    public static class CharacterDtoResponse {
        /**
         * CharacterDtoResponse's id.
         */
        public final Integer id;

        /**
         * CharacterDtoResponse's pseudo.
         */
        public final String pseudo;

        /**
         * CharacterDtoResponse's classe.
         */
        public final ClassDto classe;

        /**
         * CharacterDtoResponse's items.
         */
        public final Collection<ItemsDto> items;

        /**
         * CharacterDtoResponse's pets.
         */
        public final Collection<PetDto> pets;

        /**
         * CharacterDtoResponse's mounts.
         */
        public final Collection<MountDbo> mounts;

        /**
         * CharacterDtoResponse's account.
         */
        public final AccountDto account;

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
        public CharacterDtoResponse(final Integer id,
                                    final String pseudo,
                                    final ClassDto classe,
                                    final Collection<ItemsDto> items,
                                    final Collection<PetDto> pets,
                                    final Collection<MountDbo> mounts,
                                    final AccountDto account) {
            this.id = id;
            this.pseudo = pseudo;
            this.classe = classe;
            this.items = items;
            this.pets = pets;
            this.mounts = mounts;
            this.account = account;
        }
    }

    public static class ClassDto {
        public final Integer id;
        public final String name;
        public final String description;
        public final Collection<SkillsDto> skills;

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
        public final Integer id;
        public final String name ;
        public final String description;

        public ItemsDto(final Integer id,final String name,final String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }

    public static class PetDto{
        public final Integer id;
        public final String name;

        public PetDto(final Integer id, final String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class MountDbo{
        public final Integer id;
        public final String name;
        public final Integer speed;

        public MountDbo(final Integer id, final String name, final Integer speed) {
            this.id = id;
            this.name = name;
            this.speed = speed;
        }
    }

    public static class SkillsDto {
        public final Integer id;
        public final String name;
        public final String description;

        public SkillsDto(final Integer id, final String name, final String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }

    public static class AccountDto {
        public final Integer id;
        public final String name;

        public AccountDto(final Integer id, final String name) {
            this.id = id;
            this.name = name;
        }
    }
}

