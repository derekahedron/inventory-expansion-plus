package derekahedron.invexpplus.damage;

import derekahedron.invexpplus.InventoryExpansionPlus;
import derekahedron.invexpplus.util.IEPUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class IEPDamageTypes {

    public static final ResourceKey<DamageType> CURSED_BUNDLE =
            of("cursed_bundle");

    public static ResourceKey<DamageType> of(String id) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, IEPUtil.location(id));
    }

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(CURSED_BUNDLE, new DamageType(
                String.format("%s.cursed_bundle", InventoryExpansionPlus.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
    }
}
