package derekahedron.invexpplus.datagen.tags;

import derekahedron.invexp.item.InvExpItemTags;
import derekahedron.invexpplus.InventoryExpansionPlus;
import derekahedron.invexpplus.item.IEPItemTags;
import derekahedron.invexpplus.item.IEPItems;
import derekahedron.invexpplus.util.CompatUtil;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class IEPItemTagsProvider extends ItemTagsProvider {

    public IEPItemTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            CompletableFuture<TagLookup<Block>> contentsGetter,
            ExistingFileHelper exFileHelper) {
        super(output, lookupProvider, contentsGetter, InventoryExpansionPlus.MOD_ID, exFileHelper);
    }

    @Override
    public String getName() {
        return String.format("%s Item Tags", InventoryExpansionPlus.MOD_NAME);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {

        tag(InvExpItemTags.SACKS)
                .add(IEPItems.BISACK.get())
                .add(IEPItems.DINOSACK.get())
                .add(IEPItems.EVERYTHING_SACK.get())
                .add(IEPItems.SPACIOUS_SACK.get());

        tag(InvExpItemTags.QUIVERS)
                .add(IEPItems.STARTER_QUIVER.get())
                .add(IEPItems.PRO_QUIVER.get())
                .add(IEPItems.PREMIUM_QUIVER.get())
                .add(IEPItems.UNLIMITED_QUIVER.get());

        tag(InvExpItemTags.BUNDLES)
                .addTag(IEPItemTags.DYEABLE_DOUBLE_BUNDLES)
                .add(IEPItems.CURSED_BUNDLE.get())
                .add(IEPItems.BUNDLE_OF_JOY.get())
                .add(IEPItems.TRIPLE_BUNDLE.get());

        tag(IEPItemTags.BISACK_FABRIC)
                .addOptional(CompatUtil.alexsMobs("bison_fur"));

        tag(IEPItemTags.DINOSACK_FABRIC)
                .addOptional(CompatUtil.alexsCaves("tough_hide"));

        tag(IEPItemTags.DINOSACK_STRING)
                .addOptional(CompatUtil.alexsCaves("archaic_vine"));

        tag(IEPItemTags.DOUBLE_BUNDLE_FABRIC)
                .addOptional(CompatUtil.alexsMobs("kangaroo_hide"));

        tag(IEPItemTags.DYEABLE_DOUBLE_BUNDLES)
                .add(IEPItems.DOUBLE_BUNDLE.get())
                .add(IEPItems.WHITE_DOUBLE_BUNDLE.get())
                .add(IEPItems.ORANGE_DOUBLE_BUNDLE.get())
                .add(IEPItems.MAGENTA_DOUBLE_BUNDLE.get())
                .add(IEPItems.LIGHT_BLUE_DOUBLE_BUNDLE.get())
                .add(IEPItems.YELLOW_DOUBLE_BUNDLE.get())
                .add(IEPItems.LIME_DOUBLE_BUNDLE.get())
                .add(IEPItems.PINK_DOUBLE_BUNDLE.get())
                .add(IEPItems.GRAY_DOUBLE_BUNDLE.get())
                .add(IEPItems.LIGHT_GRAY_DOUBLE_BUNDLE.get())
                .add(IEPItems.PURPLE_DOUBLE_BUNDLE.get())
                .add(IEPItems.CYAN_DOUBLE_BUNDLE.get())
                .add(IEPItems.BLUE_DOUBLE_BUNDLE.get())
                .add(IEPItems.BROWN_DOUBLE_BUNDLE.get())
                .add(IEPItems.GREEN_DOUBLE_BUNDLE.get())
                .add(IEPItems.RED_DOUBLE_BUNDLE.get())
                .add(IEPItems.BLACK_DOUBLE_BUNDLE.get());

        tag(IEPItemTags.CURSED_BUNDLE_FABRIC)
                .addOptional(CompatUtil.alexsCaves("dark_tatters"));

        tag(IEPItemTags.CURSED_BUNDLE_STRING)
                .addOptional(CompatUtil.alexsCaves("shadow_silk"));

        tag(IEPItemTags.SHODDY_QUIVER_BARK)
                .addOptional(CompatUtil.farmersDelight("tree_bark"));

        tag(IEPItemTags.PRO_QUIVER_ROPE)
                .addOptional(CompatUtil.farmersDelight("rope"));

        tag(IEPItemTags.PRO_QUIVER_METAL)
                .addOptional(CompatUtil.alexsCaves("polymer_plate"));
    }
}
