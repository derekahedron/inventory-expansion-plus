package derekahedron.invexpplus.item;

import derekahedron.invexp.item.SackItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.math.Fraction;

public class EverythingSackItem extends SackItem {

    public EverythingSackItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxSackTypes() {
        return getMaxSackStacks();
    }

    @Override
    public Fraction getMaxSackWeight() {
        return super.getMaxSackWeight().divideBy(Fraction.getFraction(2));
    }

    @Override
    public Component getTooltipDescription(ItemStack stack) {
        return Component.translatable(getDescriptionId() + ".desc");
    }
}
