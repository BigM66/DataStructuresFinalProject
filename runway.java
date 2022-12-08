
import java.util.*;


/**
 * creates our runways.
 * @author mpars
 */
public class runway {
	
	Airplanes[] runway;
	Queue<Airplanes> TakeOff;
	PriorityQueue<Airplanes> landing;
	
	
	/**
	 * creates our landing queue, our TakeOff queue, and our runway.
	 * All values are initialized to zero.
	 * @param numRunways
	 */
	public runway(int numRunways) {
	    runway = new Airplanes[numRunways];
	    TakeOff = new LinkedList<>();
	    landing = new PriorityQueue<>();
	}
	
	/**
	 * determines where our airplanes need to go based off of their values 
	 */
	public void update() {
		
		for (Airplanes plane : TakeOff) {
			plane.update();
		}
		
		if (TakeOff.peek() != null && TakeOff.peek().distance == 0) {
			Airplanes airplane = TakeOff.poll();
			
			landing.add(airplane);
		}
		
		for (Airplanes plane : landing) {
			plane.update();
		}

		for(int i = 0; i < runway.length; i++) {
			if (runway[i] != null && runway[i].timeLeftOnRunway == 0) {
				runway[i] = null;
			} else if (runway[i] != null) {
				runway[i].onRunway = true;
				runway[i].update();
			}
		}

		if (landing.peek() != null) {
			for(int i = 0; i < runway.length; i++) {
				if (runway[i] == null) {
					runway[i] = landing.poll();
					break;
				}
			}
		}
    }
}
