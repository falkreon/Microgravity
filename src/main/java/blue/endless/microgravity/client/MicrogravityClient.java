package blue.endless.microgravity.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ClientModInitializer;

public class MicrogravityClient implements ClientModInitializer {
	public static Logger log = LogManager.getLogger("Microgravity(Client)");

	@Override
	public void onInitializeClient() {
		log.info("Client features enabled.");
	}
	
}
