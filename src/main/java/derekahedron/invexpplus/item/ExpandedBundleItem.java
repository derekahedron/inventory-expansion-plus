package derekahedron.invexpplus.item;

import derekahedron.invexp.item.bundle.BetterBundleItem;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.math.Fraction;

public class ExpandedBundleItem extends BetterBundleItem {

    public final Fraction maxWeight;

    public ExpandedBundleItem(Fraction maxWeight, Properties properties) {
        super(properties);
        this.maxWeight = maxWeight;
    }

    @Override
    public Fraction getMaxWeight(ItemStack self) {
        return maxWeight;
    }

    @Override
    public int getMaxStacks(ItemStack self) {
        Fraction maxStacks = maxWeight.multiplyBy(Fraction.getFraction(64));
        return (maxStacks.getNumerator() + maxStacks.getDenominator() + 1) / maxStacks.getDenominator();
    }
}
