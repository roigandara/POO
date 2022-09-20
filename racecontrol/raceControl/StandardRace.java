package raceControl;

import java.util.Comparator;

public class StandardRace extends Race {
	protected int duration;
	
	// CONSTRUCTOR
	
	public StandardRace(String name, int points, int duration) {
		super(name, points);
		this.duration = duration;
	}



	// CON UN SET DE COCHES
	/*
	public StandardRace(String name, HashMap<Garage, Car> raceCarSet, int duration) {
		super(name, raceCarSet);
		this.duration = duration;
	}
	*/
	
	// EMPEZAR CARRERA
	@Override
	public void startRace() {
		
		System.out.println("\n --- CARREIRA ESTÁNDAR: "+ name.toUpperCase() +" ---");
		for (int minute = 0; minute < duration ; minute++) {
			for (Car c : raceCars) {
				if (minute < 10) {
					c.accelerate();
				} else {
					c.randomizeAcceleration();
				} c.addTraveledDistance(c.getCurrentSpeed()); // se añade la velocidad a la distancia recorrida, hay que hacer la conversión al final
			}
		} // cuando termina la duración de la carrera...
	}
	
	// CALCULAR PODIO
	@Override
	public void calculatePodium() {
		// Collections.sort(raceCars, Comparator.comparing(Car::getTraveledDistance));
		System.out.println("\n ✰✰✰ PODIO DE GANADORES DE " + name.toUpperCase() + " ✰✰✰");
		raceCars.sort(Comparator.comparingDouble(Car::getTraveledDistance).reversed());
		
		for (int p = 0; p < raceCars.size(); p++) { // hay que hacer este loop de asignación de podio para dar puntos con el siguiente método y poder reflejar la puntuación en el anuncio
			podiumPlaces.add(raceCars.get(p));
		}
		giveOutScores();
		
		for (int p = 0; p < raceCars.size(); p++) {
			System.out.println((p+1) + "º: " + raceCars.get(p).brand + " " + raceCars.get(p).model +
					"(" + raceCars.get(p).garage + "), " + raceCars.get(p).traveledDistance +
					" no-kilómetros. Puntos totales: " + raceCars.get(p).score);
		}
	}
	
	@Override
	public void giveOutScores() {
		int d = 1;
		for (int i = 0; i < raceCars.size(); i++) {
			podiumPlaces.get(i).setScore(points/d);
			d *= 2;
		}
	}
	
}
