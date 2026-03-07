package derekahedron.invexpplus.item;

import derekahedron.invexp.item.InvExpItems;
import net.minecraft.world.item.*;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class IEPCreativeTabs {

    public static void initialize(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            addAfter(event, InvExpItems.QUIVER.get(), IEPItems.PRO_QUIVER.get());
            addAfter(event, IEPItems.PRO_QUIVER.get(), IEPItems.PREMIUM_QUIVER.get());
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            addAfter(event, Items.MILK_BUCKET, IEPItems.BOTTOMLESS_BUCKET.get());

            addAfter(event, InvExpItems.PINK_BUNDLE.get(), IEPItems.DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.DOUBLE_BUNDLE.get(), IEPItems.WHITE_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.WHITE_DOUBLE_BUNDLE.get(), IEPItems.LIGHT_GRAY_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.LIGHT_GRAY_DOUBLE_BUNDLE.get(), IEPItems.GRAY_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.GRAY_DOUBLE_BUNDLE.get(), IEPItems.BLACK_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.BLACK_DOUBLE_BUNDLE.get(), IEPItems.BROWN_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.BROWN_DOUBLE_BUNDLE.get(), IEPItems.RED_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.RED_DOUBLE_BUNDLE.get(), IEPItems.ORANGE_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.ORANGE_DOUBLE_BUNDLE.get(), IEPItems.YELLOW_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.YELLOW_DOUBLE_BUNDLE.get(), IEPItems.LIME_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.LIME_DOUBLE_BUNDLE.get(), IEPItems.GREEN_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.GREEN_DOUBLE_BUNDLE.get(), IEPItems.CYAN_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.CYAN_DOUBLE_BUNDLE.get(), IEPItems.LIGHT_BLUE_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.LIGHT_BLUE_DOUBLE_BUNDLE.get(), IEPItems.BLUE_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.BLUE_DOUBLE_BUNDLE.get(), IEPItems.PURPLE_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.PURPLE_DOUBLE_BUNDLE.get(), IEPItems.MAGENTA_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.MAGENTA_DOUBLE_BUNDLE.get(), IEPItems.PINK_DOUBLE_BUNDLE.get());
            addAfter(event, IEPItems.PINK_DOUBLE_BUNDLE.get(), IEPItems.CURSED_BUNDLE.get());
            addAfter(event, IEPItems.CURSED_BUNDLE.get(), IEPItems.BUNDLE_OF_JOY.get());
            addAfter(event, IEPItems.BUNDLE_OF_JOY.get(), IEPItems.TRIPLE_BUNDLE.get());

            addAfter(event, InvExpItems.SACK.get(), IEPItems.BISACK.get());
            addAfter(event, IEPItems.BISACK.get(), IEPItems.DINOSACK.get());
            addAfter(event, IEPItems.DINOSACK.get(), IEPItems.EVERYTHING_SACK.get());
            addAfter(event, IEPItems.EVERYTHING_SACK.get(), IEPItems.SPACIOUS_SACK.get());
        }
    }

    private static void addAfter(BuildCreativeModeTabContentsEvent event, Item after, Item key) {
        event.getEntries().putAfter(new ItemStack(after), new ItemStack(key), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}
