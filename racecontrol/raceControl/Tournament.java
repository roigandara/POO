package raceControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Tournament {
	protected String name;
	protected List<Race> tournamentRaces = new ArrayList<Race>();
	protected List<Garage> tournamentGarages = new ArrayList<Garage>();
	protected List<Car> tournamentCars = new ArrayList<Car>();
	// Si participa uno, todos sus coches entrarán en la competición. En el caso de ser más de uno, solo competirá un coche de cada Garaje, elegido de forma aleatoria.
	// Un Torneo tendrá puntuaciones para cada coche que participe. Se entregarán puntuaciones a los coches del podio de cada carrera, de mayor a menor, de manera proporcional. Estas puntuaciones son acumulativas para cada coche.
	// El ganador del torneo será el coche que más puntos tenga al finalizar el torneo. En caso de empate, se divide el premio.

	
	// --------------
	// CONSTRUCTOR
	// --------------
	public Tournament(String name, List<Race> tournamentRaces, List<Garage> tournamentGarages) {
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


	public List<Garage> getTournamentGarages() {
		return tournamentGarages;
	}


	public void setTournamentGarages(List<Garage> tournamentGarages) {
		this.tournamentGarages = tournamentGarages;
	}	

	

	
}
