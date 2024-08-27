package net.bamboooz.fentanyl.block.syringe;

import net.bamboooz.fentanyl.entity.damage.ModDamageTypes;
import net.bamboooz.fentanyl.item.ModItems;
import net.bamboooz.fentanyl.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Collections;
import java.util.List;

public abstract class AbstractSyringeBlock extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 0.5, 15.0);

    public AbstractSyringeBlock(Settings settings) {
        super(settings);
    }

    public abstract void onPrick(World world, BlockPos pos, LivingEntity entity);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();

        return hasTopRim(world, blockPos) || sideCoversSmallSquare(world, blockPos, Direction.UP);
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        return Collections.singletonList(ModItems.BROKEN_SYRINGE.getDefaultStack());
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world.isClient) {
            return;
        }

        if (entity instanceof LivingEntity living) {
            world.playSound(null, living.getBlockPos(), ModSounds.PRICK, SoundCategory.NEUTRAL, 1f, 1f);

            living.damage(ModDamageTypes.of(world, ModDamageTypes.PRICKING), 1);

            Block.dropStack(world, pos, ModItems.BROKEN_SYRINGE.getDefaultStack());

            world.setBlockState(pos, Blocks.AIR.getDefaultState());

            onPrick(world, pos, living);
        }
    }
}
