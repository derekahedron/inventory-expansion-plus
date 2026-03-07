package derekahedron.invexpplus.item;

import derekahedron.invexp.item.QuiverItem;

public class ExpandedQuiverItem extends QuiverItem {
    public final int maxOccupancyStacks;

    public ExpandedQuiverItem(int maxOccupancyStacks, Properties properties) {
        super(properties);
        this.maxOccupancyStacks = maxOccupancyStacks;
    }

    public int getMaxQuiverOccupancyStacks() {
        return maxOccupancyStacks;
    }
}
