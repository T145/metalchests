/*******************************************************************************
 * Copyright 2018 T145
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package T145.metalchests.blocks;

import javax.annotation.Nullable;

import T145.metalchests.api.immutable.BlocksMC;
import T145.metalchests.tiles.TileSortingHungryMetalChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSortingHungryMetalChest extends BlockSortingMetalChest {

	public BlockSortingHungryMetalChest() {
		super(BlocksMC.REGISTRY_SORTING_METAL_CHEST);
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileSortingHungryMetalChest(state.getValue(VARIANT));
	}

	@Override
	public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
		BlockHungryMetalChest.onEntityCollision(world, pos, state, entity, this);
	}
}
