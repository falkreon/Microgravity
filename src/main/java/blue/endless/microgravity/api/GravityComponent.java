package blue.endless.microgravity.api;

/**
 * Represents gravity information for a given context, usually a Dimension.
 */
public interface GravityComponent {
	
	
	/**
	 * Gets the strength of gravity in this context. For comparison:
	 * @return 1.0 if earth-gravity.
	 */
	public double getGravityStrength();
}
