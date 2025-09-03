package com.aliceeverglade.anare.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArcaneForgeBlock extends Block {
    public ArcaneForgeBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(LIT,false));
    }
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()){
            world.setBlockState(pos,state.cycle(LIT));
        }
        return ActionResult.SUCCESS;
    }
}
