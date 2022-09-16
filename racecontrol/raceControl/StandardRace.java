package raceControl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardRace extends Race {
	protected int duration;
	
	// CONSTRUCTOR
	
	public StandardRace(String name, Set<Garage> participatingGarages, int points, int duration) {
		super(name, participatingGarages, points);
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
		
		System.out.println("--- CARREIRA ESTÁNDAR: "+ name.toUpperCase() +" ---");
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
		System.out.println("✰✰✰ PODIO DE GANADORES DE " + name.toUpperCase() + " ✰✰✰");
		raceCars.sort(Comparator.comparingInt(Car::getTraveledDistance).reversed());
		
		for (int p = 0; p < 3; p++) { // hay que hacer este loop de asignación de podio para dar puntos con el siguiente método y poder reflejar la puntuación en el anuncio
			podiumPlaces.add(raceCars.get(p));
		}
		giveOutScores();
		
		for (int p = 0; p < 3; p++) {
			System.out.println((p+1) + "º: " + raceCars.get(p).brand + " " + raceCars.get(p).model +
					"(" + raceCars.get(p).garage + "), " + raceCars.get(p).traveledDistance +
					" no-kilómetros. Puntos totales: " + raceCars.get(p).score);
		}
	}
	
	@Override
	public void giveOutScores() {
		podiumPlaces.get(0).setScore(points);
		podiumPlaces.get(1).setScore(points/2);
		podiumPlaces.get(2).setScore(points/4);
	}
	
}
