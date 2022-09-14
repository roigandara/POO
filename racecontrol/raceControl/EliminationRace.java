package raceControl;

import java.util.List;

public class EliminationRace extends Race {
	int warmupDuration;

	public EliminationRace(String name, List<Garage> registeredGarages, int warmupDuration) {
		super(name, registeredGarages);
		this.warmupDuration = warmupDuration;
	}
	
}
