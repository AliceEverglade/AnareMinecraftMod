package com.aliceeverglade.anare.block.custom;

import com.aliceeverglade.anare.item.ModItems;
import com.aliceeverglade.anare.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ArcaneAnvilBlock extends Block {
    public ArcaneAnvilBlock(Settings settings) {
        super(settings);
    }
    public enum EElement{
        None,Fire,
    }
    private static final Map<EElement, Item> ANVIL_MAP =
            Map.of(
                    EElement.Fire,ModItems.FIRE_ESSENCE
            );
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack stack = player.getMainHandStack();
        boolean success = false;
        if(stack.isOf(ModItems.MYTHRIL_HAMMER))
        {
            List<Entity> colliding = world.getOtherEntities(
                    null,
                    state.getOutlineShape(world, pos)
                            .getBoundingBox()
                            .offset(pos.getX(), pos.getY()+1, pos.getZ())
            );
            int currentDmg = stack.getDamage();
            int appliedDmg = 0;
            for (Entity entity : colliding)
            {
                if (entity instanceof ItemEntity itemEntity)
                {
                    EElement element = getElement(itemEntity.getStack());
                    if(element != EElement.None)
                    {
                        if(currentDmg + appliedDmg + itemEntity.getStack().getCount() < stack.getMaxDamage())
                        {
                            success = true;
                            itemEntity.setStack(new ItemStack(ANVIL_MAP.get(element),itemEntity.getStack().getCount()));
                            appliedDmg += itemEntity.getStack().getCount();
                        }
                    }
                }
            }
            if(success)
            {
                stack.setDamage(currentDmg + appliedDmg);
                world.playSound(player,pos, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS,1f,1f);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.FAIL;
    }

    private EElement getElement(ItemStack stack){
        if(stack.isIn(ModTags.Items.ESSENCE_DEGRADABLE_FIRE)) return EElement.Fire;
        return EElement.None;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.anare.arcane_anvil_block"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
