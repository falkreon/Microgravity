package blue.endless.microgravity.api;

public class StandardGravities {
	/* Gravitational values here are actual values for the planet's surface,
	 * and are also basically correct for the 256 meters above or below the surface.
	 * That makes them excellent for usage here in this context.
	 * 
	 * Constants are listed in order from closest to furthest from the sun. Moons
	 * are listed after their host planets.
	 */
	public static final double MERCURY = 0.38;
	public static final double VENUS   = 0.904;
	
	public static final double EARTH   = 1.0;
	public static final double MOON    = 0.166; //just under 1/6 earth-G
	
	public static final double MARS    = 0.376;
	/* Mars' moons have effectively zero G. This is where Microgravity really earns its name! */
	public static final double PHOBOS  = 0.0005814;
	public static final double DEMIOS  = 0.000306;
	
	/* Ceres is a dwarf planet hangin out in the asteroid belt */
	public static final double CERES   = 0.029;
	
	/**
	 * Jupiter doesn't really have a "surface" for surface gravity, and you couldn't really
	 * walk on it. You'd fall down - plummet, really, at two and a half G's - through
	 * thin ammonia clouds, then a gap, then thick ammonia clouds with fierce 100mph winds,
	 * then through stormclouds flashing lightning brighter than anything on Earth, luminous
	 * glows from phosphorous or some kind of hydrocarbons. Through all this you'd keep falling
	 * through pure, clear hydrogen until you hit the supercritical fluid ocean. But you wouldn't
	 * splash. You might not even notice you'd hit it, the boundary is gradual, the hydrogen bit
	 * by bit stops making sense as a gas as it's crushed harder and harder. But it's too hot to
	 * be a regular fluid. And you'd just keep falling, crushing down until you finally hit the
	 * metallic hydrogen core. Not really a great Minecraft experience.
	 */
	//Inner Group
	public static final double JUPITER  = 2.528;
	public static final double METIS    = 0.001764;
	public static final double ADRASTEA = 0.0074;
	public static final double AMALTHEA = 0.002017; //Not featured in Seveneves!
	public static final double THEBE    = 0.004193;
	//Galilean Moons
	public static final double IO       = 0.183;
	public static final double EUROPA   = 0.134;
	public static final double GANYMEDE = 0.146;
	public static final double CALLISTO = 0.126;
	//Himalia Group
	public static final double LEDA     = 0.002976;
	public static final double HIMALIA  = 0.006347;
	public static final double ERSA     = 0.0001; //'S/2018 J1'
	public static final double PANDIA   = 0.0001; //'S/2017 J4'
	public static final double ELARA    = 0.003694;
	public static final double LYSITHEA = 0.002972;
	/* Dia is the one item where I can't give you a correct answer.
	 * We just don't know its mass. It's an irregular rock about 4km across, and this number
	 * here is totally made up. */
	public static final double DIA      = 0.0001;
	/*
	 * Jupiter has almost 80 moons that we know of. I could be here all day. But these are the ones
	 * you could actually visit without wasting a ton of fuel on. If you wanted to start visiting
	 * moons, I'd start in the Galilean section. They're the biggest, least fussy, more orb-like ones.
	 */
	
	/**
	 * Saturn also doesn't really have a "surface" for surface gravity, being mostly liquid
	 * helium. Additionally, its shape is so eccentric that the gravity listed here is wrong
	 * at the poles, being only 74% of Earth's.
	 */
	public static final double SATURN = 1.065;
}
