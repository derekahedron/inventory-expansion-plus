package derekahedron.invexpplus.item;

import derekahedron.invexp.item.bundle.BundleContentsWriter;
import derekahedron.invexpplus.damage.IEPDamageTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.math.Fraction;

import java.util.Optional;

public class CursedBundleItem extends ExpandedBundleItem {

    public static final Fraction MAX_WEIGHT = Fraction.getFraction(4);
    public static final float DAMAGE_PER_STACK = 6.0F;

    public CursedBundleItem(Properties properties) {
        super(MAX_WEIGHT, properties);
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction clickAction, Player player) {
        boolean otherSlotEmpty = slot.getItem().isEmpty();
        boolean overridden = super.overrideStackedOnOther(stack, slot, clickAction, player);
        if (overridden && clickAction == ClickAction.SECONDARY && otherSlotEmpty) {
            damageTakingOutStacks(player, stack, slot.getItem());
        }
        return overridden;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack otherStack, Slot slot, ClickAction clickAction, Player player, SlotAccess slotAccess) {
        boolean otherSlotEmpty = otherStack.isEmpty();
        boolean overridden = super.overrideOtherStackedOnMe(stack, otherStack, slot, clickAction, player, slotAccess);
        if (overridden && clickAction == ClickAction.SECONDARY && otherSlotEmpty) {
            damageTakingOutStacks(player, stack, slotAccess.get());
        }
        return overridden;
    }

    @Override
    public Optional<Component> getTooltipDescription(ItemStack stack) {
        return Optional.of(Component.translatable(getDescriptionId() + ".desc"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BundleContentsWriter contents = BundleContentsWriter.of(stack);
        InteractionResultHolder<ItemStack> result = super.use(level, player, hand);
        if (contents != null && result.getResult().consumesAction()) {
            damageTakingOutStacks(player, stack, contents.getStacks().toArray(ItemStack[]::new));
        }

        return result;
    }

    public void damageTakingOutStacks(Player player, ItemStack self, ItemStack... takenOutStacks) {
        if (takenOutStacks.length == 0) return;
        float damage = 0;

        for (ItemStack stack : takenOutStacks) {
            if (stack.isEmpty()) continue;
            damage += getWeight(self, stack)
                    .multiplyBy(Fraction.getFraction(stack.getCount()))
                    .multiplyBy(Fraction.getFraction(DAMAGE_PER_STACK))
                    .floatValue();
        }

        Holder<DamageType> damageType = player.level().registryAccess()
                .registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(IEPDamageTypes.CURSED_BUNDLE);
        player.hurt(new DamageSource(damageType), damage);
    }
}
