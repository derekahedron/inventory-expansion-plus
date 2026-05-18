package derekahedron.invexpplus.item;

import derekahedron.invexp.item.sack.SackItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class BisackItem extends SackItem implements DyeableLeatherItem {

    public BisackItem(Properties properties) {
        super(properties);
    }

    public int getColor(ItemStack stack) {
        CompoundTag tag = stack.getTagElement("display");
        return tag != null && tag.contains("color", 99) ? tag.getInt("color") : 0xFF54402f;
    }

    @Override
    public int getMaxSackTypes(ItemStack self) {
        return 2;
    }

    @Override
    public Optional<Component> getTooltipDescription(ItemStack stack) {
        return Optional.of(Component.translatable(getDescriptionId() + ".desc"));
    }
}
