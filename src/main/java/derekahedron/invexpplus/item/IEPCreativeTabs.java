package derekahedron.invexpplus.item;

import derekahedron.invexp.item.InvExpItems;
import net.minecraft.world.item.*;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class IEPCreativeTabs {

    public static void initialize(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            addList(event, InvExpItems.QUIVER.get(),
                    IEPItems.PRO_QUIVER.get(),
                    IEPItems.PREMIUM_QUIVER.get());
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            addList(event, Items.MILK_BUCKET,
                    IEPItems.BOTTOMLESS_BUCKET.get());

            addList(event, InvExpItems.PINK_BUNDLE.get(),
                    IEPItems.DOUBLE_BUNDLE.get(),
                    IEPItems.WHITE_DOUBLE_BUNDLE.get(),
                    IEPItems.LIGHT_GRAY_DOUBLE_BUNDLE.get(),
                    IEPItems.GRAY_DOUBLE_BUNDLE.get(),
                    IEPItems.BROWN_DOUBLE_BUNDLE.get(),
                    IEPItems.BLACK_DOUBLE_BUNDLE.get(),
                    IEPItems.RED_DOUBLE_BUNDLE.get(),
                    IEPItems.ORANGE_DOUBLE_BUNDLE.get(),
                    IEPItems.YELLOW_DOUBLE_BUNDLE.get(),
                    IEPItems.LIME_DOUBLE_BUNDLE.get(),
                    IEPItems.GREEN_DOUBLE_BUNDLE.get(),
                    IEPItems.CYAN_DOUBLE_BUNDLE.get(),
                    IEPItems.LIGHT_BLUE_DOUBLE_BUNDLE.get(),
                    IEPItems.BLUE_DOUBLE_BUNDLE.get(),
                    IEPItems.PURPLE_DOUBLE_BUNDLE.get(),
                    IEPItems.MAGENTA_DOUBLE_BUNDLE.get(),
                    IEPItems.PINK_DOUBLE_BUNDLE.get(),
                    IEPItems.CURSED_BUNDLE.get(),
                    IEPItems.BUNDLE_OF_JOY.get(),
                    IEPItems.TRIPLE_BUNDLE.get());

            addList(event, InvExpItems.SACK.get(),
                    IEPItems.BISACK.get(),
                    IEPItems.DINOSACK.get(),
                    IEPItems.EVERYTHING_SACK.get(),
                    IEPItems.SPACIOUS_SACK.get());
        }
    }

    public static void addList(BuildCreativeModeTabContentsEvent event, Item start, Item... items) {
        ItemStack lastStack = new ItemStack(start);
        for (Item item : items) {
            ItemStack stack = new ItemStack(item);
            event.getEntries().putAfter(lastStack, stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            lastStack = stack;
        }
    }
}
