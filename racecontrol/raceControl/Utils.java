package raceControl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import es.imatia.redsocial.User;

public class Utils {

	public void printGarageList(Collection<Garage> garageList) {
		int i = 1;
		for (Garage g : garageList) {
			System.out.println(i + ". " + g.name);
			i++;
		}
	}
	
	public void printRaceList(Collection<Race> raceList) {
		int i = 1;
		for (Race g : raceList) {
			System.out.println(i + ". " + g.name);
			i++;
		}
	}
	
	public void printTournamentList(Collection<Tournament> tournamentList) {
		int i = 1;
		for (Tournament t : tournamentList) {
			System.out.println(i + ". " + t.name);
			i++;
		}
	}
	
	public Garage findGarage (Set<Garage> garageList, String name) {
		Garage garageFind = null;
		for (Garage garage : garageList) {
			if (garage.getName().equals(name)) {
				garageFind = garage;
			}
		}
		return garageFind;
	}
	
	public Race findRace (Set<Race> raceList, String name) {
		Race raceFind = null;
		for (Race race : raceList) {
			if (race.getName().equals(name)) {
				raceFind = race;
			}
		}
		return raceFind;
	}
	
	public Tournament findTournament (Set<Tournament> tournamentList, String name) {
		Tournament tournamentFind = null;
		for (Tournament tournament : tournamentList) {
			if (tournament.getName().equals(name)) {
				tournamentFind = tournament;
			}
		}
		return tournamentFind;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
}
