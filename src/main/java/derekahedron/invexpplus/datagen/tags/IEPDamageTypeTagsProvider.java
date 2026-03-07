package derekahedron.invexpplus.datagen.tags;

import derekahedron.invexpplus.InventoryExpansionPlus;
import derekahedron.invexpplus.damage.IEPDamageTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class IEPDamageTypeTagsProvider extends TagsProvider<DamageType> {

    public IEPDamageTypeTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, Registries.DAMAGE_TYPE, lookupProvider, InventoryExpansionPlus.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return String.format("%s Damage Types", InventoryExpansionPlus.MOD_NAME);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        tag(DamageTypeTags.BYPASSES_ARMOR)
                .add(IEPDamageTypes.CURSED_BUNDLE);
        tag(DamageTypeTags.BYPASSES_COOLDOWN)
                .add(IEPDamageTypes.CURSED_BUNDLE);
        tag(DamageTypeTags.BYPASSES_EFFECTS)
                .add(IEPDamageTypes.CURSED_BUNDLE);
    }
}
