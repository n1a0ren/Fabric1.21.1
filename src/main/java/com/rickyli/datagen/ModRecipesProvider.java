package com.rickyli.datagen;

import com.rickyli.block.ModBlocks;
import com.rickyli.item.ModItems;
import com.rickyli.RickyLiMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> rubyore = List.of(ModBlocks.rubyore);
    private static final List<ItemConvertible> deepslate_rubyore = List.of(ModBlocks.deepslate_rubyore);
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ruby,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.rubyblock);
        offerSmelting(exporter, rubyore, RecipeCategory.MISC, ModItems.ruby, 0.7f, 200, "ruby");
        offerBlasting(exporter, rubyore, RecipeCategory.MISC, ModItems.ruby, 0.7f, 100, "ruby");
        offerSmelting(exporter, deepslate_rubyore, RecipeCategory.MISC, ModItems.ruby, 0.7f, 200, "ruby");
        offerBlasting(exporter, deepslate_rubyore, RecipeCategory.MISC, ModItems.ruby, 0.7f, 100, "ruby");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SWORD, 1)
                .pattern("#")
                .pattern("#")
                .pattern("X")
                .input('#', Ingredient.ofItems(ModItems.ruby))
                .input('X', Ingredient.ofItems(net.minecraft.item.Items.STICK))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ruby))
                .offerTo(exporter,Identifier.of(RickyLiMod.MOD_ID, "rubyswordrecipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL, 1)
                .pattern("#")
                .pattern("X")
                .pattern("X")
                .input('#', Ingredient.ofItems(ModItems.ruby))
                .input('X', Ingredient.ofItems(net.minecraft.item.Items.STICK))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ruby))
                .offerTo(exporter,Identifier.of(RickyLiMod.MOD_ID, "rubyshovelrecipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE, 1)
                .pattern("###")
                .pattern(" X ")
                .pattern(" X ")
                .input('#', Ingredient.ofItems(ModItems.ruby))
                .input('X', Ingredient.ofItems(net.minecraft.item.Items.STICK))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ruby))
                .offerTo(exporter,Identifier.of(RickyLiMod.MOD_ID, "rubypickaxerecipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_AXE, 1)
                .pattern("##")
                .pattern("#X")
                .pattern(" X")
                .input('#', Ingredient.ofItems(ModItems.ruby))
                .input('X', Ingredient.ofItems(net.minecraft.item.Items.STICK))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ruby))
                .offerTo(exporter,Identifier.of(RickyLiMod.MOD_ID, "rubyaxerecipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_HOE, 1)
                .pattern("##")
                .pattern(" X")
                .pattern(" X")
                .input('#', Ingredient.ofItems(ModItems.ruby))
                .input('X', Ingredient.ofItems(net.minecraft.item.Items.STICK))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ruby))
                .offerTo(exporter,Identifier.of(RickyLiMod.MOD_ID, "rubyhoerecipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', Ingredient.ofItems(ModItems.ruby))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ruby))
                .offerTo(exporter,Identifier.of(RickyLiMod.MOD_ID, "rubyhelmetrecipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', Ingredient.ofItems(ModItems.ruby))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ruby))
                .offerTo(exporter,Identifier.of(RickyLiMod.MOD_ID, "rubychestplaterecipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', Ingredient.ofItems(ModItems.ruby))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ruby))
                .offerTo(exporter,Identifier.of(RickyLiMod.MOD_ID, "rubyleggingsrecipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', Ingredient.ofItems(ModItems.ruby))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ruby))
                .offerTo(exporter,Identifier.of(RickyLiMod.MOD_ID, "rubybootsrecipe"));
        /*(ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ruby, 3)
                .pattern("###")
                .input('#', Ingredient.ofItems(Items.ruby))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.ruby))
                .offerTo(exporter, Identifier.of(RickyLiMod.MOD_ID, "shimingzi"));
        /*ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.rubyore)
                .input(Items.ruby)
                .input(net.minecraft.item.Items.STONE)
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.ruby))
                .criterion("has_item", RecipeProvider.conditionsFromItem(net.minecraft.item.Items.STONE))
                .offerTo(exporter, Identifier.of(RickyLiMod.MOD_ID, "shimingzi"));**/
    }
}
