package derekahedron.invexpplus.item;

import derekahedron.invexp.item.BetterBundleItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class BundleOfJoyItem extends BetterBundleItem {

    public BundleOfJoyItem(Properties properties) {
        super(properties);
    }

    @Override
    public Component getTooltipDescription(ItemStack stack) {
        return Component.translatable(getDescriptionId() + ".desc");
    }
}
