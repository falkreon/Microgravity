package blue.endless.microgravity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class Microgravity implements ModInitializer {
	public static Logger log = LogManager.getLogger("Microgravity");

	@Override
	public void onInitialize() {
		log.info("Gravity removed.");
		
		/*ServerTickEvents.START_SERVER_TICK.register((MinecraftServer server)  -> {
			ServerPlayerEntity player = server.getPlayerManager().getPlayer("Falkreon");
			if (player!=null) System.out.println(player.getPos());
		});*/
	}

}
