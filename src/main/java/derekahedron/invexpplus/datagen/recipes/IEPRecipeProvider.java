package derekahedron.invexpplus.datagen.recipes;

import derekahedron.invexp.recipe.DyeBundleRecipe;
import derekahedron.invexpplus.item.IEPItemTags;
import derekahedron.invexpplus.item.IEPItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Consumer;

public class IEPRecipeProvider extends RecipeProvider {

    public IEPRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,
                        IEPItems.BISACK.get())
                .define('-', Tags.Items.STRING)
                .define('#', IEPItemTags.BISACK_FABRIC)
                .pattern("-#-")
                .pattern("# #")
                .pattern("###")
                .unlockedBy(
                        getHasName(Items.STRING),
                        has(Tags.Items.STRING))
                .save(consumer, IEPItems.BISACK.getId());

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,
                        IEPItems.DINOSACK.get())
                .define('-', IEPItemTags.DINOSACK_STRING)
                .define('#', IEPItemTags.DINOSACK_FABRIC)
                .pattern("-#-")
                .pattern("# #")
                .pattern("###")
                .unlockedBy(
                        "has_dinosack_string",
                        has(IEPItemTags.DINOSACK_STRING))
                .save(consumer, IEPItems.DINOSACK.getId());

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,
                        IEPItems.DOUBLE_BUNDLE.get())
                .define('-', Tags.Items.STRING)
                .define('#', IEPItemTags.DOUBLE_BUNDLE_FABRIC)
                .pattern("-")
                .pattern("#")
                .unlockedBy(
                        getHasName(Items.STRING),
                        has(Tags.Items.STRING))
                .save(consumer, IEPItems.DOUBLE_BUNDLE.getId());
        dyeDoubleBundle(consumer, IEPItems.WHITE_DOUBLE_BUNDLE.get(), Items.WHITE_DYE);
        dyeDoubleBundle(consumer, IEPItems.ORANGE_DOUBLE_BUNDLE.get(), Items.ORANGE_DYE);
        dyeDoubleBundle(consumer, IEPItems.MAGENTA_DOUBLE_BUNDLE.get(), Items.MAGENTA_DYE);
        dyeDoubleBundle(consumer, IEPItems.LIGHT_BLUE_DOUBLE_BUNDLE.get(), Items.LIGHT_BLUE_DYE);
        dyeDoubleBundle(consumer, IEPItems.YELLOW_DOUBLE_BUNDLE.get(), Items.YELLOW_DYE);
        dyeDoubleBundle(consumer, IEPItems.LIME_DOUBLE_BUNDLE.get(), Items.LIME_DYE);
        dyeDoubleBundle(consumer, IEPItems.PINK_DOUBLE_BUNDLE.get(), Items.PINK_DYE);
        dyeDoubleBundle(consumer, IEPItems.GRAY_DOUBLE_BUNDLE.get(), Items.GRAY_DYE);
        dyeDoubleBundle(consumer, IEPItems.LIGHT_GRAY_DOUBLE_BUNDLE.get(), Items.LIGHT_GRAY_DYE);
        dyeDoubleBundle(consumer, IEPItems.PURPLE_DOUBLE_BUNDLE.get(), Items.PURPLE_DYE);
        dyeDoubleBundle(consumer, IEPItems.CYAN_DOUBLE_BUNDLE.get(), Items.CYAN_DYE);
        dyeDoubleBundle(consumer, IEPItems.BLUE_DOUBLE_BUNDLE.get(), Items.BLUE_DYE);
        dyeDoubleBundle(consumer, IEPItems.BROWN_DOUBLE_BUNDLE.get(), Items.BROWN_DYE);
        dyeDoubleBundle(consumer, IEPItems.GREEN_DOUBLE_BUNDLE.get(), Items.GREEN_DYE);
        dyeDoubleBundle(consumer, IEPItems.RED_DOUBLE_BUNDLE.get(), Items.RED_DYE);
        dyeDoubleBundle(consumer, IEPItems.BLACK_DOUBLE_BUNDLE.get(), Items.BLACK_DYE);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,
                        IEPItems.CURSED_BUNDLE.get())
                .define('-', IEPItemTags.CURSED_BUNDLE_STRING)
                .define('#', IEPItemTags.CURSED_BUNDLE_FABRIC)
                .pattern("-")
                .pattern("#")
                .unlockedBy(
                        "has_cursed_bundle_string",
                        has(IEPItemTags.CURSED_BUNDLE_STRING))
                .save(consumer, IEPItems.CURSED_BUNDLE.getId());

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,
                        IEPItems.PRO_QUIVER.get())
                .define('-', IEPItemTags.PRO_QUIVER_ROPE)
                .define('X', Items.RABBIT_HIDE)
                .define('#', IEPItemTags.PRO_QUIVER_BARK)
                .pattern(" XX")
                .pattern("-##")
                .pattern(" ##")
                .unlockedBy(
                        getHasName(Items.ARROW),
                        has(ItemTags.ARROWS))
                .save(consumer, IEPItems.PRO_QUIVER.getId());
    }

    public static void dyeDoubleBundle(Consumer<FinishedRecipe> consumer, ItemLike bundle, ItemLike dye) {
        new DyeBundleRecipe.Builder(RecipeCategory.TOOLS,
                bundle,
                Ingredient.of(IEPItemTags.DYEABLE_DOUBLE_BUNDLES),
                Ingredient.of(dye))
                .group("double_bundle_dye")
                .unlockedBy(
                        getHasName(dye),
                        has(dye))
                .save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(bundle.asItem())));
    }
}
