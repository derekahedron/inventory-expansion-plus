package derekahedron.invexpplus.item;

import derekahedron.invexp.item.bundle.BetterBundleItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class BundleOfJoyItem extends BetterBundleItem {

    public BundleOfJoyItem(Properties properties) {
        super(properties);
    }

    @Override
    public Optional<Component> getTooltipDescription(ItemStack stack) {
        return Optional.of(Component.translatable(getDescriptionId() + ".desc"));
    }
}
