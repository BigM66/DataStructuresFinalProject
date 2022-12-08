import java.util.*;

/**
 * launches our airport simulation.
 * @author mpars
 *
 */
public class Application {
	
	/**
	 * creates our airport simulation
	 * @param args
	 */
	public static void main(String[] args) {
		AirPort airport = new AirPort();
		airport.simulate(0.35);
	}
}
