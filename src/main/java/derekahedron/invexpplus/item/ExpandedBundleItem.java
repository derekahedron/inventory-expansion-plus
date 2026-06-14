package derekahedron.invexpplus.item;

import derekahedron.invexp.item.bundle.BetterBundleItem;
import derekahedron.invexp.item.bundle.BundleContentsReader;
import org.apache.commons.lang3.math.Fraction;

public class ExpandedBundleItem extends BetterBundleItem {

    public final Fraction maxWeight;

    public ExpandedBundleItem(Fraction maxWeight, Properties properties) {
        super(properties);
        this.maxWeight = maxWeight;
    }

    @Override
    public Fraction getMaxWeight(BundleContentsReader contents) {
        return maxWeight;
    }

    @Override
    public int getMaxStacks(BundleContentsReader self) {
        Fraction maxStacks = maxWeight.multiplyBy(Fraction.getFraction(64));
        return (maxStacks.getNumerator() + maxStacks.getDenominator() + 1) / maxStacks.getDenominator();
    }
}
