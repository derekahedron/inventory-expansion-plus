package derekahedron.invexpplus.item;


import derekahedron.invexp.item.quiver.QuiverContentsReader;
import derekahedron.invexp.item.quiver.QuiverItem;
import org.apache.commons.lang3.math.Fraction;

public class ExpandedQuiverItem extends QuiverItem {

    public final Fraction maxWeight;

    public ExpandedQuiverItem(Fraction maxWeight, Properties properties) {
        super(properties);
        this.maxWeight = maxWeight;
    }

    @Override
    public Fraction getMaxWeight(QuiverContentsReader contents) {
        return maxWeight;
    }
}
