package derekahedron.invexpplus.client.compat;

import derekahedron.invexp.forge.client.compat.QuiverCurioRenderer;
import derekahedron.invexpplus.item.IEPItems;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class CuriosCompatClient {

    public static void setupCurioModels(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            CuriosRendererRegistry.register(IEPItems.STARTER_QUIVER.get(), QuiverCurioRenderer::new);
            CuriosRendererRegistry.register(IEPItems.PRO_QUIVER.get(), QuiverCurioRenderer::new);
            CuriosRendererRegistry.register(IEPItems.UNLIMITED_QUIVER.get(), QuiverCurioRenderer::new);
            CuriosRendererRegistry.register(IEPItems.PREMIUM_QUIVER.get(), QuiverCurioRenderer::new);
        });
    }
}
