package chai.divinen.datagen;

import chai.divinen.block.ModBlocks;
import chai.divinen.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALTAR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.AMBROSIA, Models.GENERATED);
        itemModelGenerator.register(ModItems.IDOL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZEUS_IDOL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CERAMIC_PIECE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIVINE_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRIED_HERBS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRESH_HERBS, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIVINE_IRON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIVINE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIVINE_EMERALD, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIVINE_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_SHARDS, Models.GENERATED);
    }
}
