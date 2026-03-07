package derekahedron.invexpplus.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public class BottomlessBucketItem extends Item {
    public static final int COOLDOWN = 5;
    public static final int MAX_SEARCH = 32;

    public BottomlessBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockHitResult rayTraceResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        BlockHitResult.Type resultType = rayTraceResult.getType();

        if (resultType != BlockHitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(stack);
        } else {
            BlockPos pos = rayTraceResult.getBlockPos();
            Direction useDirection = rayTraceResult.getDirection();
            BlockPos fromPos = pos.relative(useDirection);
            if (level.mayInteract(player, pos) && player.mayUseItemAt(fromPos, useDirection, stack)) {
                BlockPos sourcePos = getSourcePos(level, pos);
                if (sourcePos != null) {
                    if (level.mayInteract(player, sourcePos)) {
                        BlockState sourceBlockState = level.getBlockState(sourcePos);
                        Block block = sourceBlockState.getBlock();
                        if (block instanceof BucketPickup bucketPickup) {
                            player.getCooldowns().addCooldown(this, COOLDOWN);
                            if (!bucketPickup.pickupBlock(level, sourcePos, sourceBlockState).isEmpty()) {
                                player.awardStat(Stats.ITEM_USED.get(this));
                                bucketPickup.getPickupSound().ifPresent(fillSound ->
                                        player.playSound(fillSound, 1.0F, 1.0F));
                                return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
                            }
                        }
                    }
                }
            }
            return InteractionResultHolder.fail(stack);
        }
    }

    @Nullable
    public static BlockPos getSourcePos(Level level, BlockPos pos) {
        FluidState fluidState = level.getFluidState(pos);
        if (!fluidState.isEmpty()) {
            Fluid baseFluid = fluidState.getType();
            Set<BlockPos> searched = new HashSet<>();
            return searchPos(level, pos, baseFluid, searched, 0);
        }
        return null;
    }

    @Nullable
    public static BlockPos searchPos(Level level, BlockPos pos, Fluid baseFluid, Set<BlockPos> searched, int depth) {
        if (searched.contains(pos)) {
            return null;
        }
        searched.add(pos);
        FluidState fluidState = level.getFluidState(pos);
        if (!fluidState.getType().isSame(baseFluid)) {
            return null;
        }
        else if (fluidState.isSource()) {
            return pos;
        }
        depth += 1;
        if (depth >= MAX_SEARCH) {
            return null;
        }

        Vec3 flow = fluidState.getFlow(level, pos);

        BlockPos searchedPos = searchPos(level, pos.above(), baseFluid, searched, depth);
        if (searchedPos != null) {
            return searchedPos;
        }

        int xFlow = flow.x <= 0 ? 1 : -1;
        int zFlow = flow.z <= 0 ? 1 : -1;
        Vec3i[] checks;
        if (Math.abs(flow.x) >= Math.abs(flow.z)) {
            checks = new Vec3i[] {
                    new Vec3i(xFlow, 0, 0),
                    new Vec3i(0, 0, zFlow),
                    new Vec3i(-xFlow, 0, 0),
                    new Vec3i(0, 0, -zFlow),
            };
        } else {
            checks = new Vec3i[] {
                    new Vec3i(0, 0, zFlow),
                    new Vec3i(xFlow, 0, 0),
                    new Vec3i(0, 0, -zFlow),
                    new Vec3i(-xFlow, 0, 0),
            };
        }

        for (Vec3i check : checks) {
            searchedPos = searchPos(level, pos.offset(check), baseFluid, searched, depth);
            if (searchedPos != null) {
                return searchedPos;
            }
        }

        return searchPos(level, pos.below(), baseFluid, searched, depth);
    }
}
