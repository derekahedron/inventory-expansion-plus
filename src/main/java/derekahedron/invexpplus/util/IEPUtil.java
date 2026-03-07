package derekahedron.invexpplus.util;

import derekahedron.invexpplus.InventoryExpansionPlus;
import net.minecraft.resources.ResourceLocation;

public class IEPUtil {

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(InventoryExpansionPlus.MOD_ID, path);
    }
}
