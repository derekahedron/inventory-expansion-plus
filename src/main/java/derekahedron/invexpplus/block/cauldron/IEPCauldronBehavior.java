package derekahedron.invexpplus.block.cauldron;

import derekahedron.invexpplus.item.IEPItems;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

public class IEPCauldronBehavior {

    public static void initialize(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            CauldronInteraction.WATER.put(IEPItems.BISACK.get(), CauldronInteraction.DYED_ITEM);
        });
    }
}
