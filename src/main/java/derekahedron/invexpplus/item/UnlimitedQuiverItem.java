package derekahedron.invexpplus.item;

import derekahedron.invexp.item.quiver.QuiverContentsReader;
import derekahedron.invexp.item.quiver.QuiverItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.math.Fraction;

import java.util.Optional;

public class UnlimitedQuiverItem extends QuiverItem {

    public static final int MAX_STACKS = 99;

    public UnlimitedQuiverItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canTryInsert(QuiverContentsReader contents, ItemStack stack) {
        return super.canTryInsert(contents, stack) && contents.getStacks().stream().allMatch(nestedStack ->
                ItemStack.isSameItemSameTags(nestedStack, stack));
    }

    @Override
    public Fraction getMaxWeight(QuiverContentsReader contents) {
        return Fraction.getFraction(MAX_STACKS);
    }

    @Override
    public int getMaxStacks(QuiverContentsReader contents) {
        return MAX_STACKS;
    }

    @Override
    public Optional<Component> getTooltipDescription(ItemStack stack) {
        return Optional.of(Component.translatable(getDescriptionId() + ".desc"));
    }
}
