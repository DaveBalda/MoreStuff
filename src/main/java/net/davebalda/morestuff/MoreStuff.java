package net.davebalda.morestuff;

import net.davebalda.morestuff.block.ModBlocks;
import net.davebalda.morestuff.item.ModItemGroups;
import net.davebalda.morestuff.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreStuff implements ModInitializer {
	public static final String MOD_ID = "morestuff";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ItemTooltipCallback.EVENT.register(((itemStack, tooltipContext, tooltipType, list) -> {
            if(itemStack.isOf(ModItems.RESTORATION_WAND))
                list.add(Text.translatable("tooltip.morestuff.restoration_wand"));
        }));
	}
}