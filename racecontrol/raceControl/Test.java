package raceControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
	// --------------
	// CREACIÓN DE COCHES
	// --------------
	// https://www.fantasynamegenerators.com/car-names.php
	
	Car specter = new Car("RTX 2060", "ford", "nvidia");
	Car quicksilver = new Car("RTX 2070", "ford", "nvidia");
	Car hydra = new Car("RTX 2080", "chevrolet", "nvidia");
	Car empire = new Car("GTX 3080ti", "ford", "nvidia");
	
	HashMap<String, Car> nvidiaCars = new HashMap<String, Car>();
	nvidiaCars.put("specter", specter); nvidiaCars.put("quicksilver", quicksilver); nvidiaCars.put("hydra", hydra); nvidiaCars.put("empire", empire);
	
	Car spirit = new Car("RX 6800", "toyota", "amd");
	Car albatros = new Car("5600X", "chevrolet", "amd");
	Car cosmos = new Car("5600G", "toyota", "amd");
	
	HashMap<String, Car> amdCars = new HashMap<String, Car>();
	amdCars.put("spirit", spirit); amdCars.put("albatros", albatros); amdCars.put("cosmos", cosmos);
	
	Car basilisk = new Car("i5-8600", "chevrolet", "intel");
	Car prophecy = new Car("i5-12400F", "ford", "intel");
	Car voyage = new Car("i7-12700F", "toyota", "intel");
	Car turbokiller9000 = new Car("i9-14600F", "ford", "intel");
	
	HashMap<String, Car> intelCars = new HashMap<String, Car> ();
	intelCars.put("basilisk", basilisk); intelCars.put("prophecy",prophecy); intelCars.put("voyage", voyage); intelCars.put("turbokiller9000", turbokiller9000);
	
	/* 
	Car olympian = new Car("F15", "toyota", "asus");
	Car titan = new Car("G15", "ford", "asus");
	Car apex = new Car("Strix G15", "toyota", "asus");
	Car bolt = new Car("Dash F15", "toyota", "asus");
	
	List<Car> asusCars = new ArrayList<>();
	asusCars.add(olympian); asusCars.add(titan); asusCars.add(apex); asusCars.add(bolt);
	*/
	
	// --------------
	// CREACIÓN DE GARAJES
	// --------------
	Garage nvidia = new Garage("nvidia", nvidiaCars);
	Garage amd = new Garage("amd", amdCars);
	Garage intel = new Garage("intel", intelCars);
	// Garage asus = new Garage("asus", asusCars);
	
	// Tesla??
	
	// Creación de listas de TODOS los garajes existentes
	Set<Garage> garageList = new HashSet<>();
	garageList.add(nvidia); garageList.add(amd); garageList.add(intel);
	
	// Creación de garajes selectos para participar en torneos
	Set<Garage> participatingGarages = new HashSet<>();
	
	List<Garage> registeredGaragesSet0 = new ArrayList<>();
	registeredGaragesSet0.add(nvidia);
	List<Garage> registeredGaragesSet1 = new ArrayList<>();
	registeredGaragesSet1.add(nvidia); registeredGaragesSet1.add(amd);
	List<Garage> registeredGaragesSet2 = new ArrayList<>();
	registeredGaragesSet2.add(nvidia); registeredGaragesSet2.add(amd); registeredGaragesSet2.add(intel);
	
	
	// --------------
	// CREACIÓN DE CARRERAS
	// --------------
	// https://mario.fandom.com/wiki/List_of_tracks_in_the_Mario_Kart_series
	
	Race ghost = new EliminationRace("ghost valley", 10, 60);
	Race royal = new StandardRace("royal raceway", 70, 40);
	Race maple = new EliminationRace("maple treeway", 15, 70);
	
	Race brokenPier = new StandardRace("broken pier", 70, 40);
	Race moonview = new StandardRace("moonview highway", 60, 50);
	Race bone = new StandardRace("dry dunes", 50, 40);
	Race rainbow = new StandardRace("rainbow road", 70, 70);
	
	
	
	// LISTA DE TODAS LAS CARRERAS
	Set<Race> raceList = new HashSet<>();
	Collections.addAll(raceList, brokenPier, moonview, bone, rainbow, ghost, royal, maple);
	
	
	// --------------
	// CREACIÓN DE TORNEOS
	// --------------
	Set<Tournament> tournamentList = new HashSet<>();
	
	List<Race> leafCupRaces = new ArrayList<>();
	Collections.addAll(leafCupRaces, ghost, royal, maple);
	Tournament leafCup = new Tournament("leafCup", leafCupRaces, participatingGarages);
	tournamentList.add(leafCup);
}
