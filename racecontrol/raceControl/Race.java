package raceControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Race {
	// Si participa un garaje en la carrera, participan todos los coches de ese garaje, pero si participan varios garajes, sólo participa un coche por garaje elegido de manera aleatoria.

	protected String name;
	
	// Standard or Elimination
	// Carrera estandar: tienes por ejemplo 3h (eso lo determina cada uno). Al terminar las 3horas tienes que mirar la distancia de cada uno y el que más a recorrido es el que gana. La carrera termina con el mismo numero de corredores que al inicio.
	// Carrera de Elminación: la carrera dura un tiempo determinado (3h por ejemplo tambien) y cada 20 mins por ejemplo (tambien determina tu el tiempo) se va eliminando el que menos ha recorrido por lo que al terminar la carrera habrá menos corredores que empezaron
	// Eliminación (que tienen una serie de minutos previos para que los pilotos se hagan a la pista, y al terminar esos minutos de calentamiento, se irá retirando el coche que va en la última posición, cada minuto, hasta que sólo quede un coche).
	
	protected Set<Garage> raceGarageSet = new HashSet<Garage>();
	// ^ Si participa uno, todos sus coches entrarán en la competición. En el caso de ser más de uno, solo competirá un coche de cada Garaje, elegido de forma aleatoria.
	protected List<Car> raceCars = new ArrayList<Car>();
	
	protected List<Car> podiumPlaces = new ArrayList<Car>();
	// El resultado de cualquier carrera dependerá de la distancia recorrida en el mismo tiempo por cada coche que participa en la carrera.
	// El podio de una carrera son los 3 Coches que más distancia hayan recorrido en el mismo tiempo.
	// Se entregarán puntuaciones a los coches del podio de cada carrera, de mayor a menor, de manera proporcional. Estas puntuaciones son acumulativas para cada coche.



	
	public void generateRacingGarages(ArrayList<Garage> tournamentGarages) { // se le pasa los garajes que participan en el torneo
		raceGarageSet = new HashSet<Garage>(tournamentGarages);
		for (int i = 1; i <= tournamentGarages.size() ; i++) {
			int randomIndex = new Random().nextInt(tournamentGarages.size());
			Garage randomGarage = tournamentGarages.get(randomIndex);
			raceGarageSet.add(randomGarage);
		}
	}
	
	public void generateRacingCars() {
		if (raceGarageSet.size() == 1) { // si solo hay un garaje, corren todos sus coches
			for (Car c : raceGarageSet.get(0).getRegisteredCars().values()) {
				raceCars.add(c);
			} 
		} else { // elegimos un coche de cada garaje aleatoriamente
			for (Garage g : raceGarageSet) { // por cada garaje...
				List<Car> listOfCars = new ArrayList<Car>(g.getRegisteredCars().values()); // ... obtenemos su hashmap de coches y lo metemos en una lista
				int randomIndex = new Random().nextInt(listOfCars.size());
				Car randomCar = listOfCars.get(randomIndex);
				raceCars.add(randomCar);
			}
		}
	}
	

	// veo más factible empezar todos desde 0 y luego aumentar hasta x velocidad y luego que sea aleatoria
	
	
}
