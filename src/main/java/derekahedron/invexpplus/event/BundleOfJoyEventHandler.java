package derekahedron.invexpplus.event;

import derekahedron.invexpplus.InventoryExpansionPlus;
import derekahedron.invexpplus.item.IEPItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
import java.util.List;

@Mod.EventBusSubscriber(modid = InventoryExpansionPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BundleOfJoyEventHandler {
    public static final String KEPT_ITEMS_KEY = InventoryExpansionPlus.MOD_ID + ":KeptItems";

    @SubscribeEvent
    public static void onPlayerDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof Player player) {
            Collection<ItemEntity> drops = event.getDrops();
            List<ItemEntity> keptDrops = drops.stream()
                    .filter(drop -> drop.getItem().is(IEPItems.BUNDLE_OF_JOY.get()))
                    .toList();

            if (!keptDrops.isEmpty()) {
                ListTag keptItems = player.getPersistentData().getList(KEPT_ITEMS_KEY, 10);
                for (ItemEntity drop : keptDrops) {
                    ItemStack stack = drop.getItem();
                    keptItems.add(stack.save(new CompoundTag()));
                }
                player.getPersistentData().put(KEPT_ITEMS_KEY, keptItems);
                drops.removeAll(keptDrops);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        // Only run if the player died (not returning from the End)
        if (event.isWasDeath()) {
            var oldPlayer = event.getOriginal();
            var newPlayer = event.getEntity();

            // Restore items from the old player's persistent NBT to the new player
            ListTag keptItems = oldPlayer.getPersistentData().getList(KEPT_ITEMS_KEY, 10);

            for (int i = 0; i < keptItems.size(); i++) {
                ItemStack stack = ItemStack.of(keptItems.getCompound(i));
                if (!stack.isEmpty()) {
                    newPlayer.getInventory().add(stack);
                }
            }

            // Clear the data so items aren't duplicated on next death
            oldPlayer.getPersistentData().remove(KEPT_ITEMS_KEY);
        }
    }
}
