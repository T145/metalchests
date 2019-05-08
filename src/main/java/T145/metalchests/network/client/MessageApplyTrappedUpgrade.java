package T145.metalchests.network.client;

import java.io.IOException;

import T145.metalchests.network.MessageBase;
import T145.metalchests.tiles.TileMetalChest;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageApplyTrappedUpgrade extends MessageBase {

	private BlockPos pos;
	private boolean trapped;

	public MessageApplyTrappedUpgrade() {
		// DEFAULT CONSTRUCTOR REQUIRED
	}

	public MessageApplyTrappedUpgrade(BlockPos pos, boolean trapped) {
		this.pos = pos;
		this.trapped = trapped;
	}

	@Override
	public void serialize(PacketBuffer buf) {
		buf.writeBlockPos(pos);
		buf.writeBoolean(trapped);
	}

	@Override
	public void deserialize(PacketBuffer buf) throws IOException {
		pos = buf.readBlockPos();
		trapped = buf.readBoolean();
	}

	@Override
	public void process(MessageContext ctx) {
		World world = getClientWorld();

		if (world != null) {
			TileEntity te = world.getTileEntity(pos);

			if (te instanceof TileMetalChest) {
				TileMetalChest chest = (TileMetalChest) te;
				chest.setTrapped(trapped);
			}
		}
	}
}
