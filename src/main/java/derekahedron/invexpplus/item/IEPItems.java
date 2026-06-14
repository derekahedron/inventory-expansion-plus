package derekahedron.invexpplus.item;

import derekahedron.invexpplus.InventoryExpansionPlus;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.math.Fraction;

public class IEPItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InventoryExpansionPlus.MOD_ID);

    public static final RegistryObject<BisackItem> BISACK =
            ITEMS.register("bisack", () ->
                    new BisackItem(
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedSackItem> DINOSACK =
            ITEMS.register("dinosack", () ->
                    new ExpandedSackItem(
                            Fraction.getFraction(6),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<EverythingSackItem> EVERYTHING_SACK =
            ITEMS.register("everything_sack", () ->
                    new EverythingSackItem(
                            new Item.Properties()
                                    .rarity(Rarity.UNCOMMON)
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedSackItem> SPACIOUS_SACK =
            ITEMS.register("spacious_sack", () ->
                    new ExpandedSackItem(
                            Fraction.getFraction(8),
                            new Item.Properties()
                                    .fireResistant()
                                    .rarity(Rarity.RARE)
                                    .stacksTo(1)));

    public static final RegistryObject<ExpandedBundleItem> DOUBLE_BUNDLE =
            ITEMS.register("double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> WHITE_DOUBLE_BUNDLE =
            ITEMS.register("white_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> ORANGE_DOUBLE_BUNDLE =
            ITEMS.register("orange_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> MAGENTA_DOUBLE_BUNDLE =
            ITEMS.register("magenta_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> LIGHT_BLUE_DOUBLE_BUNDLE =
            ITEMS.register("light_blue_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> YELLOW_DOUBLE_BUNDLE =
            ITEMS.register("yellow_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> LIME_DOUBLE_BUNDLE =
            ITEMS.register("lime_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> PINK_DOUBLE_BUNDLE =
            ITEMS.register("pink_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> GRAY_DOUBLE_BUNDLE =
            ITEMS.register("gray_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> LIGHT_GRAY_DOUBLE_BUNDLE =
            ITEMS.register("light_gray_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> PURPLE_DOUBLE_BUNDLE =
            ITEMS.register("purple_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> CYAN_DOUBLE_BUNDLE =
            ITEMS.register("cyan_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> BLUE_DOUBLE_BUNDLE =
            ITEMS.register("blue_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> BROWN_DOUBLE_BUNDLE =
            ITEMS.register("brown_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> GREEN_DOUBLE_BUNDLE =
            ITEMS.register("green_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> RED_DOUBLE_BUNDLE =
            ITEMS.register("red_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> BLACK_DOUBLE_BUNDLE =
            ITEMS.register("black_double_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(2),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<CursedBundleItem> CURSED_BUNDLE =
            ITEMS.register("cursed_bundle", () ->
                    new CursedBundleItem(
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<BundleOfJoyItem> BUNDLE_OF_JOY =
            ITEMS.register("bundle_of_joy", () ->
                    new BundleOfJoyItem(
                            new Item.Properties()
                                    .rarity(Rarity.UNCOMMON)
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedBundleItem> TRIPLE_BUNDLE =
            ITEMS.register("triple_bundle", () ->
                    new ExpandedBundleItem(
                            Fraction.getFraction(3),
                            new Item.Properties()
                                    .fireResistant()
                                    .rarity(Rarity.RARE)
                                    .stacksTo(1)));

    public static final RegistryObject<ExpandedQuiverItem> STARTER_QUIVER =
            ITEMS.register("starter_quiver", () ->
                    new ExpandedQuiverItem(
                            Fraction.getFraction(4),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedQuiverItem> PRO_QUIVER =
            ITEMS.register("pro_quiver", () ->
                    new ExpandedQuiverItem(
                            Fraction.getFraction(12),
                            new Item.Properties()
                                    .stacksTo(1)));
    public static final RegistryObject<UnlimitedQuiverItem> UNLIMITED_QUIVER =
            ITEMS.register("unlimited_quiver", () ->
                    new UnlimitedQuiverItem(
                            new Item.Properties()
                                    .rarity(Rarity.UNCOMMON)
                                    .stacksTo(1)));
    public static final RegistryObject<ExpandedQuiverItem> PREMIUM_QUIVER =
            ITEMS.register("premium_quiver", () ->
                    new ExpandedQuiverItem(
                            Fraction.getFraction(16),
                            new Item.Properties()
                                    .fireResistant()
                                    .rarity(Rarity.RARE)
                                    .stacksTo(1)));

    public static final RegistryObject<BottomlessBucketItem> BOTTOMLESS_BUCKET =
            ITEMS.register("bottomless_bucket", () ->
                    new BottomlessBucketItem(
                            new Item.Properties()
                                    .rarity(Rarity.UNCOMMON)
                                    .stacksTo(1)));
}
