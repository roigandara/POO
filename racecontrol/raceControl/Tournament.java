package raceControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import es.imatia.redsocial.TextPost;

public class Tournament {
	protected String name;
	protected List<Race> tournamentRaces = new ArrayList<Race>();
	protected Set<Garage> tournamentGarages = new HashSet<Garage>();
	protected List<Car> tournamentRepCars = new ArrayList<Car>();
	protected List<Car> podiumPlaces = new ArrayList<Car>();
	// Si participa uno, todos sus coches entrarán en la competición. En el caso de ser más de uno, solo competirá un coche de cada Garaje, elegido de forma aleatoria.
	// Un Torneo tendrá puntuaciones para cada coche que participe. Se entregarán puntuaciones a los coches del podio de cada carrera, de mayor a menor, de manera proporcional. Estas puntuaciones son acumulativas para cada coche.
	// El ganador del torneo será el coche que más puntos tenga al finalizar el torneo. En caso de empate, se divide el premio.

	
	// --------------
	// CONSTRUCTOR
	// --------------
	
	public Tournament(String name) {
		this.name = name;
	}
	
	public Tournament(String name, List<Race> tournamentRaces, Set<Garage> tournamentGarages) {
		super();
		this.name = name;
		this.tournamentRaces = tournamentRaces;
		this.tournamentGarages = tournamentGarages;
	}
	
	// --------------
	// GETTER SETTERS
	// --------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Race> getTournamentRaces() {
		return tournamentRaces;
	}

	public void setTournamentRaces(List<Race> tournamentRaces) {
		this.tournamentRaces = tournamentRaces;
	}

	public Set<Garage> getTournamentGarages() {
		return tournamentGarages;
	}

	public void setTournamentGarages(Set<Garage> tournamentGarages) {
		this.tournamentGarages = tournamentGarages;
	}
	
	// --------------
	// MÉTODOS
	// --------------

	// START
	public void startTournament() {
		generateGarageRep();
		for (Race race : tournamentRaces) {
			race.generateRacingGarages(tournamentGarages);
			race.generateRacingCars(tournamentRepCars);
			race.startRace();
			race.calculatePodium();
		}
		calculatePodium();
	}

	public void generateGarageRep() { // crea una lista de un (1) coche a participar de cada garaje
			for (Garage g : tournamentGarages) { // por cada garaje...
				List<Car> listOfCars = new ArrayList<Car>(g.getRegisteredCars().values()); // ... obtenemos su hashmap de coches y lo metemos en una lista
				int randomIndex = new Random().nextInt(listOfCars.size());
				Car randomCar = listOfCars.get(randomIndex);
				tournamentRepCars.add(randomCar); // <- SE PUEDE IDENTIFICAR TODAVÍA CON LA PEGATINA DE SU GARAJE ASÍ QUE NO HACE FALTA HASHMAP
			}
			
			System.out.println("--- ESCUDERÍAS PARTICIPANTES NO TORNEO ---");
			for (Garage g : tournamentGarages) {
				System.out.println(g.getName());
			}
			System.out.println("--- COCHES REPRESENTANTES ---");
			for (Car c : tournamentRepCars) {
				System.out.println(c.getBrand() + " " + c.getModel() + " (" + c.getGarage() + ")");
			}
	}
	
	public void calculatePodium() {
		System.out.println("\n ✰✰✰ RESULTADOS DE TORNEO ✰✰✰");
		System.out.println("\n ✰✰✰ PODIO DE GANADORES DE " + name.toUpperCase() + " ✰✰✰");
		tournamentRepCars.sort(Comparator.comparingInt(Car::getScore).reversed());
		
		for (int p = 0; p < 3; p++) { // hay que hacer este loop de asignación de podio para dar puntos con el siguiente método y poder reflejar la puntuación en el anuncio
			podiumPlaces.add(tournamentRepCars.get(p));
		}
		
		for (int p = 0; p < 3; p++) {
			System.out.println((p+1) + "º: " + tournamentRepCars.get(p).brand + " " + tournamentRepCars.get(p).model +
					"(" + tournamentRepCars.get(p).garage + "), " + " Puntos totales: " + tournamentRepCars.get(p).score);
		}
	}
	
	
	
}
