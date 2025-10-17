package net.shockfox05.autofishfixmod;

import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.level.block.NoteBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@Mod(AutoFishFixModClient.MOD_ID)
@EventBusSubscriber(modid = AutoFishFixModClient.MOD_ID, value = Dist.CLIENT)
public class AutoFishFixModClient {
    public static final String MOD_ID = "sfautofishfix";

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getItemStack().getItem() instanceof FishingRodItem &&
            event.getLevel().getBlockState(event.getPos()).getBlock() instanceof NoteBlock &&
            event.getEntity().fishing == null) {
            
            event.setCanceled(true);
        }
    }
}