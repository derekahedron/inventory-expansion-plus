package derekahedron.invexpplus.item;

import derekahedron.invexp.item.sack.SackContentsReader;
import derekahedron.invexp.item.sack.SackItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.math.Fraction;

import java.util.Optional;

public class EverythingSackItem extends SackItem {

    public EverythingSackItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxSackTypes(SackContentsReader contents) {
        return getMaxStacks(contents);
    }

    @Override
    public Fraction getMaxWeight(SackContentsReader contents) {
        return super.getMaxWeight(contents).divideBy(Fraction.getFraction(2));
    }

    @Override
    public Optional<Component> getTooltipDescription(ItemStack stack) {
        return Optional.of(Component.translatable(getDescriptionId() + ".desc"));
    }
}
