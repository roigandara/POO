package raceControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Race {
	// Si participa un garaje en la carrera, participan todos los coches de ese garaje, pero si participan varios garajes, sólo participa un coche por garaje elegido de manera aleatoria.

	protected String name;
	protected int points;
	
	
	// Standard or Elimination
	// Carrera estandar: tienes por ejemplo 3h (eso lo determina cada uno). Al terminar las 3horas tienes que mirar la distancia de cada uno y el que más a recorrido es el que gana. La carrera termina con el mismo numero de corredores que al inicio.
	// Carrera de Elminación: la carrera dura un tiempo determinado (3h por ejemplo tambien) y cada 20 mins por ejemplo (tambien determina tu el tiempo) se va eliminando el que menos ha recorrido por lo que al terminar la carrera habrá menos corredores que empezaron
	// Eliminación (que tienen una serie de minutos previos para que los pilotos se hagan a la pista, y al terminar esos minutos de calentamiento, se irá retirando el coche que va en la última posición, cada minuto, hasta que sólo quede un coche).
	
	protected Set<Garage> raceGarageSet = new HashSet<Garage>(); // garajes que participan en la carrera
	// ^ Si participa uno, todos sus coches entrarán en la competición. En el caso de ser más de uno, solo competirá un coche de cada Garaje, elegido de forma aleatoria.
	protected List<Car> raceCars = new ArrayList<Car>();
	
	// protected HashMap<Garage,Car> raceCarSet = new HashMap<Garage,Car>();
	
	
	protected List<Car> podiumPlaces = new ArrayList<Car>();
	// El podio de una carrera son los 3 Coches que más distancia hayan recorrido en el mismo tiempo.
	// Se entregarán puntuaciones a los coches del podio de cada carrera, de mayor a menor, de manera proporcional. Estas puntuaciones son acumulativas para cada coche.

	
	// CONSTRUCTOR
	public Race(String name, Set<Garage> participatingGarages, int points) {
		super();
		this.name = name;
		this.raceGarageSet = participatingGarages;
		this.points = points;
	}
	
	// GETTERS SETTERS
	
	
	
	// MÉTODOS
	
	// GENERAR GARAJES
	public void generateRacingGarages(Set<Garage> tournamentGarages) { // se le pasa los garajes que participan en el torneo
		List<Garage> list = new ArrayList<Garage>(tournamentGarages); // se crea una copia de t.garages como arraylist para averiguar el index
		for (int i = 1; i <= list.size() ; i++) {
			int randomIndex = new Random().nextInt(tournamentGarages.size());
			Garage randomGarage = list.get(randomIndex);
			raceGarageSet.add(randomGarage);
			System.out.println("GARAJE SELECCIONADO DEL TORNEO: " + randomGarage);
		}
		
		for (Garage g : raceGarageSet) {
			System.out.println("Participante de carrera: " + g.getName());
		}
	}
	



	// TODO
	// LA SELECCIÓN DE COCHES TENDRÍA QUE HACERSE FUERA DE RACE PERO ESTO SE VA A DEJAR PARA MÁS TARDE
	
	// CON HASHSET PARA LOS COCHES: RACECARSET
	// -----------------------
	/*
	public void generateRacingCars() { // crea una lista de coches a participar
		if (raceGarageSet.size() == 1) { // si solo hay un garaje, corren todos sus coches
			for (Car c : raceGarageSet.iterator().next().getRegisteredCars().values()) {
				raceCars.add(c);
			} 
		} else { // elegimos un coche de cada garaje aleatoriamente
			for (Garage g : raceGarageSet) { // por cada garaje...
				List<Car> listOfCars = new ArrayList<Car>(g.getRegisteredCars().values()); // ... obtenemos su hashmap de coches y lo metemos en una lista
				int randomIndex = new Random().nextInt(listOfCars.size());
				Car randomCar = listOfCars.get(randomIndex);
				raceCarSet.put(g,randomCar); // ahora tenemos un hashmap con el coche seleccionado de cada garaje que participa
			}
		}
	}
	*/
	
	// CON LISTA PARA LOS COCHES: RACECARS
	// -------------------------------------
	public void generateRacingCars(List<Car> tournamentRepCars) { // crea una lista de coches a participar
		if (raceGarageSet.size() == 1) { // si solo hay un garaje, corren todos sus coches
			for (Car c : raceGarageSet.iterator().next().getRegisteredCars().values()) {
				raceCars.add(c);
			}
		} else { // se elige el representante de los garajes elegidos de la carrera
			for (Car c : tournamentRepCars) {
				for (Garage g : raceGarageSet) {
					if (g.getName() == c.getGarage()) {
						raceCars.add(c);
					}
				}
				
			}
		}
	}
	
	public abstract void startRace();
	public abstract void calculatePodium();
	public abstract void giveOutScores();
	
	
}
