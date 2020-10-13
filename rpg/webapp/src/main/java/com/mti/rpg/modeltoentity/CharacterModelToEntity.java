package com.mti.rpg.modeltoentity;

import com.mti.rpg.domain.entity.CharacterEntity;
import com.mti.rpg.persistence.model.CharacterModel;
import com.mti.rpg.utils.scope.ConverterService;
import utils.Converter;

/**
 * @author clement.dedenis (clement.dedenis@epita.fr)
 * @since 1.0
 */
@ConverterService
public class CharacterModelToEntity implements Converter.Reversible<CharacterModel, CharacterEntity> {

    /**
     * CharacterModelToEntity's classConverter.
     */
    private final ClassModelToEntity classConverter;

    /**
     * CharacterModelToEntity's itemConverter.
     */
    private final ItemsModelToEntity itemConverter;

    /**
     * CharacterModelToEntity's petConverter.
     */
    private final PetModelToEntity petConverter;

    /**
     * CharacterModelToEntity's mountConverter.
     */
    private final MountModelToEntity mountConverter;

    /**
     * CharacterModelToEntity's accountConverter.
     */
    private final AccountModelToEntity accountConverter;

    /**
     * Initializer.
     *
     * @param classConverter field value.
     * @param itemConverter field value.
     * @param petConverter field value.
     * @param mountConverter field value.
     * @param accountConverter field value.
     */
    public CharacterModelToEntity(final ClassModelToEntity classConverter,
                                  final ItemsModelToEntity itemConverter,
                                  final PetModelToEntity petConverter,
                                  final MountModelToEntity mountConverter,
                                  final AccountModelToEntity accountConverter) {
        this.classConverter = classConverter;
        this.itemConverter = itemConverter;
        this.petConverter = petConverter;
        this.mountConverter = mountConverter;
        this.accountConverter = accountConverter;
    }

    /**
     * Convert an CharacterModel to CharacterEntity.
     */
    @Override
    public CharacterEntity convert(final CharacterModel from) {
        return new CharacterEntity(from.getId(),
                                    from.getPseudo(),
                                    from.getClasse() == null ? null : classConverter.convert(from.getClasse()),
                                    from.getItems() == null ? null : itemConverter.convertList(from.getItems()),
                                    from.getPets() == null ? null : petConverter.convertList(from.getPets()),
                                    from.getMounts() == null ? null : mountConverter.convertList(from.getMounts()),
                                    from.getAccount() == null ? null : accountConverter.convert(from.getAccount()));
    }

    /**
     * Convert an CharacterEntity to CharacterModel.
     */
    @Override
    public CharacterModel revertConvert(final CharacterEntity from) {
        return new CharacterModel(from.id,
                                  from.pseudo,
                                  from.classe == null ? null : classConverter.revertConvert(from.classe),
                                  from.items == null ? null : itemConverter.revertConvertList(from.items),
                                  from.pets == null ? null : petConverter.revertConvertList(from.pets),
                                  from.mounts == null ? null : mountConverter.revertConvertList(from.mounts),
                                  from.account == null ? null : accountConverter.revertConvert(from.account));
    }
}
