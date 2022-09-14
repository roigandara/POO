package raceControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import es.imatia.redsocial.User;
import es.imatia.redsocial.UserList;

public class Main {
	
	public static void main(String[] args) {
		// Puntuaciones: Serán la suma de los puntos de las carreras ganadas de cada coche. 
		
		// guardar Coches, Garajes, Carreras y Torneos en un fichero.
		// Este fichero debe cargarse cada vez que se inicia el programa y debe actualizarse antes de finalizar el programa.

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
		
		// Creación de listas de garajes a participar en carreras y torneos
		List<Garage> garageList = new ArrayList<>();
		
		garageList.add(nvidia); garageList.add(amd); garageList.add(intel);
		
		List<Garage> registeredGaragesSet0 = new ArrayList<>();
		registeredGaragesSet0.add(nvidia);
		List<Garage> registeredGaragesSet1 = new ArrayList<>();
		registeredGaragesSet1.add(nvidia); registeredGaragesSet1.add(amd);
		List<Garage> registeredGaragesSet2 = new ArrayList<>();
		registeredGaragesSet2.add(nvidia); registeredGaragesSet2.add(amd); registeredGaragesSet2.add(intel);
		// List<Garage> registeredGaragesSet3 = new ArrayList<>();
		// registeredGaragesSet3.add(nvidia); registeredGaragesSet3.add(amd); registeredGaragesSet3.add(intel); registeredGaragesSet3.add(asus);
		
		
		// --------------
		// CREACIÓN DE CARRERAS
		// --------------
		// https://mario.fandom.com/wiki/List_of_tracks_in_the_Mario_Kart_series
		
		Race brokenPier = new StandardRace("broken pier", registeredGaragesSet2, 60);
		Race moonview = new StandardRace("moonview highway", registeredGaragesSet2, 80);
		Race bone = new StandardRace("dry dunes", registeredGaragesSet0, 55);
		Race rainbow = new StandardRace("rainbow road", registeredGaragesSet2, 80);
		
		Race ghost = new EliminationRace("ghost valley", registeredGaragesSet1, 10);
		Race royal = new StandardRace("royal raceway", registeredGaragesSet1, 70);
		Race maple = new EliminationRace("maple treeway", registeredGaragesSet2, 15);
		
		
		// LISTA DE TODAS LAS CARRERAS
		List<Race> raceList = new ArrayList<>();
		Collections.addAll(raceList, brokenPier, moonview, bone, rainbow, ghost, royal, maple);
		// CÓMO AÑADIR LOS X PRIMEROS???
		
		// --------------
		// CREACIÓN DE TORNEOS
		// --------------
		
		List<Race> leafCupRaces = new ArrayList<>();
		leafCupRaces.add(maple); leafCupRaces.add(moonview); leafCupRaces.add(bone);
		
		Tournament leafCup = new Tournament("leafCup", leafCupRaces, registeredGaragesSet2);
		// el garagesset va a tener que hacerse luego en función de los que corran en las carreras, o viceversa. aka un array de sets de garajes
		
		
	}
	
}
