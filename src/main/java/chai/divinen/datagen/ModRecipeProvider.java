package chai.divinen.datagen;

import chai.divinen.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                // Ambrosia
                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.FOOD, ModItems.AMBROSIA)
                        .input(Items.HONEYCOMB)
                        .input(Items.GOLD_NUGGET)
                        .input(ModItems.DRIED_HERBS)
                        .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                        .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                        .offerTo(exporter);

                // Idol
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.IDOL).pattern(" i ").pattern(" d ").pattern("ccc")
                        .input('i', Items.IRON_INGOT)
                        .input('d', ModItems.DIVINE_ESSENCE)
                        .input('c', ModItems.CERAMIC_PIECE)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .criterion(hasItem(ModItems.DIVINE_ESSENCE), conditionsFromItem(ModItems.DIVINE_ESSENCE))
                        .criterion(hasItem(ModItems.CERAMIC_PIECE), conditionsFromItem(ModItems.CERAMIC_PIECE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
