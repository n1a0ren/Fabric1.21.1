package com.rickyli.datagen;

import com.rickyli.ModBlocks.Blocks;
import com.rickyli.ModItems.Items;
import com.rickyli.RickyLiMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> rubyore = List.of(Blocks.rubyore);
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.ruby,
                RecipeCategory.BUILDING_BLOCKS, Blocks.rubyblock);
        offerSmelting(exporter, rubyore, RecipeCategory.MISC, Items.ruby, 0.7f, 200, "ruby");
        offerBlasting(exporter, rubyore, RecipeCategory.MISC, Items.ruby, 0.7f, 100, "ruby");
        /*ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ruby, 3)
                .pattern("###")
                .input('#', Ingredient.ofItems(Items.ruby))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.ruby))
                .offerTo(exporter, Identifier.of(RickyLiMod.MOD_ID, "shimingzi"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.rubyore)
                .input(Items.ruby)
                .input(net.minecraft.item.Items.STONE)
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.ruby))
                .criterion("has_item", RecipeProvider.conditionsFromItem(net.minecraft.item.Items.STONE))
                .offerTo(exporter, Identifier.of(RickyLiMod.MOD_ID, "shimingzi"));**/
    }
}
