package derekahedron.invexpplus.item;

import derekahedron.invexp.item.sack.SackContentsReader;
import derekahedron.invexp.item.sack.SackItem;
import org.apache.commons.lang3.math.Fraction;

public class ExpandedSackItem extends SackItem {

    public final Fraction maxWeight;

    public ExpandedSackItem(Fraction maxWeight, Properties properties) {
        super(properties);
        this.maxWeight = maxWeight;
    }

    @Override
    public Fraction getMaxWeight(SackContentsReader contents) {
        return maxWeight;
    }
}
