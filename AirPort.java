import java.io.IOException;
import java.util.*;

/**
 * this creates our airport and populates it how we want it to be populated
 * @author mpars
 */
public class AirPort {

	Airplanes Airplane = new Airplanes();

	runway runway = new runway(3);


	/**
	 * creates our simulation of our airport
	 * @param landingRate
	 */
	public void simulate(double landingRate) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int time = 0;
			public void run() {
				time++;
				if(Math.random() < landingRate) {
					Airplanes Airplane = new Airplanes();
					runway.TakeOff.add(Airplane);
				}
				runway.update();
				
				clear();
				System.out.println("AIRPORT SIMULATOR: " + time);
				System.out.println("\ntakeoff");
				for (Airplanes plane : runway.TakeOff) {
					System.out.println(plane);
				}
				
				System.out.println("\nlanding");
				for (Airplanes plane : runway.landing) {
					System.out.println(plane);
				}
				
				System.out.println("\nrunways");
				for (Airplanes plane : runway.runway) {
					if (plane != null) {
						System.out.println(plane);
					}
				}
			}
		};

		timer.scheduleAtFixedRate(task, 0, 2000);
	}
	
	/**
	 * clears our screen for us so it resets during our tick 
	 */
	public static void clear()
    {
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
