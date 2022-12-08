
/**
 * creates our airplanes
 * @author mpars
 */
public class Airplanes implements Comparable<Airplanes> {
	int planeNumber;
	int distance;
	boolean onRunway;
	int timeLeftOnRunway;
	boolean emergency;

	/**
	 * creates our airplanes
	 * initializes all values
	 */
	public Airplanes() {
		distance = 5000;
		planeNumber = (int) (Math.random() * 100);
		timeLeftOnRunway = 300;
		emergency = false;
		
		
	}
	
	/**
	 * gets our planes number
	 * @return
	 */
	public int getPlaneNumber() {
		return planeNumber;	
	}
	
	/**
	 * gets the distance from runway
	 * @return
	 */
	public int getDistance() {
		return distance;
	}
	
	
	/**
	 * creates our emergency 
	 * @return emergency
	 */
	public boolean createEmergency() {
    	if(emergency == false) {
    		double rand = Math.random();
    	
    		if(rand>0.95) {
    			emergency = true;
    		}
    		
    	}
    	
    	return true;
	}
	
	/**
	 * determines if their is a priority or not 
	 * @return distance
	 */
	public int getPriority() {
		if (emergency) {
			return distance - 4000;
		} else {
			return distance;
		}
	}
	
	/**
	 * updates our planes accordingly
	 */
	public void update() {
		if (onRunway) {
			timeLeftOnRunway -= 50;
		} else {
			createEmergency();
			distance -= 500;
			if (distance < 0) {
				distance = 0;
			}
		}
	}
	
	/**
	 * formats our planes as a string accordingly
	 */
	public String toString() {
		if (onRunway) {
			return String.format("number: %02d, emergency: %b, Time Remaining on runway: %4d", planeNumber, emergency, timeLeftOnRunway);
		} else {
			return String.format("number: %02d, emergency: %b, distance: %4d", planeNumber, emergency, distance);
		}
	}

	@Override
	public int compareTo(Airplanes o) {
		return getPriority() - o.getPriority();
	}
}
