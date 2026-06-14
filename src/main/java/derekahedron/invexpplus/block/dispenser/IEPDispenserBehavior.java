package derekahedron.invexpplus.block.dispenser;

import derekahedron.invexp.block.dispenser.QuiverDispenserBehavior;
import derekahedron.invexp.block.dispenser.SackDispenserBehavior;
import derekahedron.invexpplus.item.IEPItems;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

public class IEPDispenserBehavior {

    public static void initialize(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            DispenserBlock.registerBehavior(IEPItems.BISACK.get(), new SackDispenserBehavior());
            DispenserBlock.registerBehavior(IEPItems.DINOSACK.get(), new SackDispenserBehavior());
            DispenserBlock.registerBehavior(IEPItems.EVERYTHING_SACK.get(), new SackDispenserBehavior());
            DispenserBlock.registerBehavior(IEPItems.SPACIOUS_SACK.get(), new SackDispenserBehavior());
            DispenserBlock.registerBehavior(IEPItems.STARTER_QUIVER.get(), new QuiverDispenserBehavior());
            DispenserBlock.registerBehavior(IEPItems.PRO_QUIVER.get(), new QuiverDispenserBehavior());
            DispenserBlock.registerBehavior(IEPItems.UNLIMITED_QUIVER.get(), new QuiverDispenserBehavior());
            DispenserBlock.registerBehavior(IEPItems.PREMIUM_QUIVER.get(), new QuiverDispenserBehavior());
        });
    }
}
