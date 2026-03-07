package derekahedron.invexpplus;

import com.mojang.logging.LogUtils;
import derekahedron.invexpplus.block.cauldron.IEPCauldronBehavior;
import derekahedron.invexpplus.block.dispenser.IEPDispenserBehavior;
import derekahedron.invexpplus.item.IEPCreativeTabs;
import derekahedron.invexpplus.item.IEPItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(InventoryExpansionPlus.MOD_ID)
public class InventoryExpansionPlus {
    public static final String MOD_ID = "invexpplus";
    public static final String MOD_NAME = "Inventory Expansion Plus";
    private static final Logger LOGGER = LogUtils.getLogger();

    public InventoryExpansionPlus(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        IEPItems.ITEMS.register(modEventBus);

        modEventBus.addListener(IEPCauldronBehavior::initialize);
        modEventBus.addListener(IEPDispenserBehavior::initialize);
        modEventBus.addListener(EventPriority.LOW, IEPCreativeTabs::initialize);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
