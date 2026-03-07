package derekahedron.invexpplus.datagen;

import derekahedron.invexpplus.InventoryExpansionPlus;
import derekahedron.invexpplus.damage.IEPDamageTypes;
import derekahedron.invexpplus.datagen.models.IEPItemModelProvider;
import derekahedron.invexpplus.datagen.recipes.IEPRecipeProvider;
import derekahedron.invexpplus.datagen.tags.IEPDamageTypeTagsProvider;
import derekahedron.invexpplus.datagen.tags.IEPItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = InventoryExpansionPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IEPDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        RegistrySetBuilder registrySetBuilder = new RegistrySetBuilder();
        registrySetBuilder.add(Registries.DAMAGE_TYPE, IEPDamageTypes::bootstrap);
        DatapackBuiltinEntriesProvider builtinProvider =
                generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(
                        output, lookupProvider, registrySetBuilder,
                        Set.of(InventoryExpansionPlus.MOD_ID)));

        generator.addProvider(event.includeClient(), new IEPItemModelProvider(
                output, existingFileHelper));

        generator.addProvider(event.includeServer(), new IEPItemTagsProvider(
                output, lookupProvider, CompletableFuture.completedFuture(TagsProvider.TagLookup.empty()), existingFileHelper));

        generator.addProvider(event.includeServer(), new IEPDamageTypeTagsProvider(
                output, builtinProvider.getRegistryProvider(), existingFileHelper));

        generator.addProvider(event.includeServer(), new IEPRecipeProvider(
                output));
    }
}
