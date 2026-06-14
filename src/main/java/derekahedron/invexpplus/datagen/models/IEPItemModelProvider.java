package derekahedron.invexpplus.datagen.models;

import derekahedron.invexp.util.InvExpUtil;
import derekahedron.invexpplus.InventoryExpansionPlus;
import derekahedron.invexpplus.item.IEPItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class IEPItemModelProvider extends ItemModelProvider {

    public IEPItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, InventoryExpansionPlus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        sack(IEPItems.BISACK.get());
        bundle(IEPItems.DINOSACK.get());
        bundle(IEPItems.EVERYTHING_SACK.get());
        bundle(IEPItems.SPACIOUS_SACK.get());

        bundle(IEPItems.DOUBLE_BUNDLE.get());
        bundle(IEPItems.WHITE_DOUBLE_BUNDLE.get());
        bundle(IEPItems.ORANGE_DOUBLE_BUNDLE.get());
        bundle(IEPItems.MAGENTA_DOUBLE_BUNDLE.get());
        bundle(IEPItems.LIGHT_BLUE_DOUBLE_BUNDLE.get());
        bundle(IEPItems.YELLOW_DOUBLE_BUNDLE.get());
        bundle(IEPItems.LIME_DOUBLE_BUNDLE.get());
        bundle(IEPItems.PINK_DOUBLE_BUNDLE.get());
        bundle(IEPItems.GRAY_DOUBLE_BUNDLE.get());
        bundle(IEPItems.LIGHT_GRAY_DOUBLE_BUNDLE.get());
        bundle(IEPItems.PURPLE_DOUBLE_BUNDLE.get());
        bundle(IEPItems.CYAN_DOUBLE_BUNDLE.get());
        bundle(IEPItems.BLUE_DOUBLE_BUNDLE.get());
        bundle(IEPItems.BROWN_DOUBLE_BUNDLE.get());
        bundle(IEPItems.GREEN_DOUBLE_BUNDLE.get());
        bundle(IEPItems.RED_DOUBLE_BUNDLE.get());
        bundle(IEPItems.BLACK_DOUBLE_BUNDLE.get());
        bundle(IEPItems.TRIPLE_BUNDLE.get());
        bundle(IEPItems.CURSED_BUNDLE.get());
        bundle(IEPItems.BUNDLE_OF_JOY.get());

        quiver(IEPItems.STARTER_QUIVER.get());
        quiver(IEPItems.PRO_QUIVER.get());
        quiver(IEPItems.UNLIMITED_QUIVER.get());
        quiver(IEPItems.PREMIUM_QUIVER.get());

        basicItem(IEPItems.BOTTOMLESS_BUCKET.get());
    }

    public void sack(Item item) {
        ResourceLocation id = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));

        basicItem(id)
                .texture("layer1", id.withPrefix("item/").withSuffix("_overlay"));
        basicItem(id.withSuffix("_open_front"))
                .texture("layer1", id.withPrefix("item/").withSuffix("_open_front_overlay"));
        basicItem(id.withSuffix("_open_back"));
    }

    public void quiver(Item item) {
        ResourceLocation id = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));

        ModelFile filledModel = basicItem(id.withSuffix("_filled"));
        basicItem(id)
                .override()
                .predicate(InvExpUtil.location("quiver/has_contents"), 1.0F)
                .model(filledModel)
                .end();
    }

    public void bundle(Item item) {
        ResourceLocation id = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));

        basicItem(id);
        basicItem(id.withSuffix("_open_front"));
        basicItem(id.withSuffix("_open_back"));
    }
}
