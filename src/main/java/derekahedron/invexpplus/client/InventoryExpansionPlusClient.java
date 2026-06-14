package derekahedron.invexpplus.client;

import derekahedron.invexp.item.quiver.QuiverContentsWriter;
import derekahedron.invexp.util.InvExpUtil;
import derekahedron.invexpplus.InventoryExpansionPlus;
import derekahedron.invexpplus.client.compat.CuriosCompatClient;
import derekahedron.invexpplus.item.IEPItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = InventoryExpansionPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InventoryExpansionPlusClient {

    @SubscribeEvent
    public static void setupItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((ItemStack stack, int tintIndex) -> tintIndex > 0 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack), IEPItems.BISACK.get());
    }

    @SubscribeEvent
    public static void setupItemOverrides(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemProperties.register(IEPItems.STARTER_QUIVER.get(), InvExpUtil.location("quiver/has_contents"), (stack, level, entity, id) -> {
                QuiverContentsWriter contents = QuiverContentsWriter.of(stack);
                return contents != null && !contents.isEmpty() ? 1.0F : 0.0F;
            });
            ItemProperties.register(IEPItems.PRO_QUIVER.get(), InvExpUtil.location("quiver/has_contents"), (stack, level, entity, id) -> {
                QuiverContentsWriter contents = QuiverContentsWriter.of(stack);
                return contents != null && !contents.isEmpty() ? 1.0F : 0.0F;
            });
            ItemProperties.register(IEPItems.UNLIMITED_QUIVER.get(), InvExpUtil.location("quiver/has_contents"), (stack, level, entity, id) -> {
                QuiverContentsWriter contents = QuiverContentsWriter.of(stack);
                return contents != null && !contents.isEmpty() ? 1.0F : 0.0F;
            });
            ItemProperties.register(IEPItems.PREMIUM_QUIVER.get(), InvExpUtil.location("quiver/has_contents"), (stack, level, entity, id) -> {
                QuiverContentsWriter contents = QuiverContentsWriter.of(stack);
                return contents != null && !contents.isEmpty() ? 1.0F : 0.0F;
            });
        });
    }

    @SubscribeEvent
    public static void setupCurioModels(FMLClientSetupEvent event) {
        if (ModList.get().isLoaded("curios")) {
            CuriosCompatClient.setupCurioModels(event);
        }
    }
}
