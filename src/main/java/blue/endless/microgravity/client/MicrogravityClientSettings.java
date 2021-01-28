package blue.endless.microgravity.client;

public class MicrogravityClientSettings {
	private static MicrogravityClientSettings INSTANCE;
	
	public static MicrogravityClientSettings getActive() {
		if (INSTANCE==null) INSTANCE = new MicrogravityClientSettings(); //TODO: Probably throw here!
		return INSTANCE;
	}
	
	public InjectionMode injectionMode = InjectionMode.FULL;
	
	public static enum InjectionMode {
		/** */
		LIGHT,
		FULL;
	}
}
