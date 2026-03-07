package derekahedron.invexpplus.item;

import derekahedron.invexp.item.SackItem;
import org.apache.commons.lang3.math.Fraction;

public class ExpandedSackItem extends SackItem {
    public final Fraction maxSackWeight;

    public ExpandedSackItem(Fraction maxSackWeight, Properties properties) {
        super(properties);
        this.maxSackWeight = maxSackWeight;
    }

    @Override
    public Fraction getMaxSackWeight() {
        return maxSackWeight;
    }
}
