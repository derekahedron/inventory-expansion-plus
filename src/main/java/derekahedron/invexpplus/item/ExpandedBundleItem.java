package derekahedron.invexpplus.item;

import derekahedron.invexp.item.BetterBundleItem;

public class ExpandedBundleItem extends BetterBundleItem {
    public final int occupancyStacks;

    public ExpandedBundleItem(int occupancyStacks, Properties properties) {
        super(properties);
        this.occupancyStacks = occupancyStacks;
    }

    @Override
    public int getMaxBundleWeightStacks() {
        return super.getMaxBundleWeightStacks() * occupancyStacks;
    }

    @Override
    public int getMaxBundleStacks() {
        return super.getMaxBundleStacks() * occupancyStacks;
    }
}
