package raceControl;

import java.util.List;

public class StandardRace extends Race {
	protected int duration;

	public StandardRace(String name, List<Garage> registeredGarages, List<Car> raceCars, int duration) {
		super(name, registeredGarages, raceCars); // PROLLY NEED TO CHANGE
		this.duration = duration;
	}
	
	public void startRace() {
		for (int minute = 0; minute < duration ; minute++) {
			for (Car c : raceCars)
			if (minute < 10) {
			}
		}
	}
	
}
