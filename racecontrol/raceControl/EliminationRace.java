package raceControl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EliminationRace extends Race {
	int warmupDuration;
	
	// CONSTRUCTOR
	public EliminationRace(String name, Set<Garage> raceGarages, int points, int warmupDuration) {
		super(name, raceGarages, points);
		this.warmupDuration = warmupDuration;
	}


	// CONSTRUCTOR


	// EMPEZAR CARRERA
	@Override
	public void startRace() {
		System.out.println("--- CARREIRA ELIMINATORIA: "+ name.toUpperCase() +" ---");
		for (int minute = 0; minute < warmupDuration ; minute++) {
			for (Car c : raceCars) {
				if (minute < 10) {
					c.accelerate();
				} else {
					c.randomizeAcceleration();
				} c.addTraveledDistance(c.getCurrentSpeed()); // se añade la velocidad a la distancia recorrida, hay que hacer la conversión al final
			}
		} // cuando termina la duración del calentamiento...

		while (raceCars.size() > 1) {
			for (Car c : raceCars) {
				c.randomizeAcceleration();
				c.addTraveledDistance(c.getCurrentSpeed());
			}
			raceCars.sort(Comparator.comparingInt(Car::getTraveledDistance).reversed()); // SORT
			
			System.out.println("--- posiciones:");
			for (Car c : raceCars) {
				System.out.println(c.getBrand() + c.getModel() + c.getGarage() + c.getTraveledDistance());
			}
			raceCars.remove(raceCars.size()-1);
		}
		
	}
	
	// CALCULAR PODIO
	@Override
	public void calculatePodium() {
			System.out.println("✰✰✰ GANADOR DE " + name.toUpperCase() + " ✰✰✰");
			
			podiumPlaces.add(raceCars.get(0));
			giveOutScores();
			System.out.println(raceCars.get(0).brand + " " + raceCars.get(0).model + "(" + raceCars.get(0).garage + "), "
			+ raceCars.get(0).traveledDistance + " no-kilómetros. Puntos totales: " + raceCars.get(0).score);
				
			
	}
	
	@Override
	public void giveOutScores() {
		podiumPlaces.get(0).setScore(points);
	}
}
