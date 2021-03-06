package t145.metalchests.inventories;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class ComparatorSensitiveItemHandler extends ItemStackHandler {

    private boolean updateComparator;

    public ComparatorSensitiveItemHandler(int size) {
        super(size);
    }

    @Override
    protected void onLoad() {
        // Perhaps usable for something?
    }

    @Override
    protected void onContentsChanged(int slot) {
        // update on the next tick, reducing comparator updates to the bare minimum
        if (!updateComparator) {
            updateComparator = true;
        }
    }

    public void tick(TileEntity te) {
        if (updateComparator) {
            updateComparator = false;
            te.getWorld().updateComparatorOutputLevel(te.getPos(), te.getBlockType());
        }
    }
}