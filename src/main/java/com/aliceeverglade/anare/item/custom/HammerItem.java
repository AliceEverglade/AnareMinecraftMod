package com.aliceeverglade.anare.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class HammerItem extends Item {

    private static final Map<Block,Block> HAMMER_MAP =
            Map.of(
                    Blocks.DEEPSLATE,Blocks.TUFF,
                    Blocks.STONE, Blocks.GRAVEL,
                    Blocks.GRAVEL,Blocks.SAND,
                    Blocks.SAND,Blocks.WHITE_CONCRETE_POWDER,
                    Blocks.AMETHYST_BLOCK,Blocks.BUDDING_AMETHYST
            );
    private static final Map<Block,Integer> HAMMER_DAMAGE_MAP =
            Map.of(
                    Blocks.DEEPSLATE,1,
                    Blocks.STONE, 1,
                    Blocks.GRAVEL,1,
                    Blocks.SAND,2,
                    Blocks.AMETHYST_BLOCK,10
            );
    public HammerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        if(HAMMER_MAP.containsKey(clickedBlock)){
            if(world.isClient) return ActionResult.FAIL;
            world.setBlockState(context.getBlockPos(),HAMMER_MAP.get(clickedBlock).getDefaultState());
            context.getStack().damage(HAMMER_DAMAGE_MAP.get(clickedBlock),((ServerWorld) world),((ServerPlayerEntity)context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            world.playSound(null,context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.anare.hammer"));
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.anare.hammer.extra"));
        }
        else{
            tooltip.add(Text.translatable("tooltip.anare.shift"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
