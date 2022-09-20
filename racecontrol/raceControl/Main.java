package raceControl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.io.File;
// import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.imatia.redsocial.Input;

public class Main {
	
	public static void main(String[] args) {
		
		Utils utils = new Utils();
		
		Set<Tournament> tournamentList = new HashSet<>();
		Set<Garage> garageList = new HashSet<>();
		Set<Race> raceList = new HashSet<>();
		Set<Garage> participatingGarages = new HashSet<>(); // escuderias selectas para el torneo
		
		// -------------
		// MENÚ
		// --------------
		
		String option = "";
		
		// do while
		do {
			String input = "";
			
			int inputNum;
			System.out.println("--- MENU ---");
			System.out.println("--- Opcións: ---");
			System.out.println("1. Xestionar escuderías");
			System.out.println("2. Xestionar carreiras");
			System.out.println("3. Xestionar torneos");
			System.out.println("4. Comezar");
			System.out.println("5. Cargar arquivo");
			option = Input.string(" \n Selección: ¿Que opción desexa realizar?: ");
			System.out.println();
			switch (option) {
				case "1": // XESTIONAR ESCUDERIAS
					
					// do {
						System.out.println("--- Opcións: ---");
						System.out.println("1. Listar escuderías");
						System.out.println("2. Engadir escudería");
						System.out.println("3. Eliminar escudería");
						System.out.println("4. Editar escudería");
						System.out.println("0. Volver");
						option = Input.string("\n Selección: ¿Que opción desexa realizar?: ");
						
						switch (option) {
						case "1":
							utils.printGarageList(garageList);
							break;
						case "2":
							option = Input.string("Indique o nome da escudería a engadir: ");
							Garage newGarage = new Garage(option);
							garageList.add(newGarage);
							System.out.println("Engadiuse " + option);
							// TODO opción de añadir coches?
							break;
						case "3":
							option = Input.string("Indique o nome da escudería a eliminar: ");
							
							garageList.remove(utils.findGarage(garageList, option));
							for (Garage g : garageList) {
								if (g.getName() == option) {
									garageList.remove(g);
								}
							}
							System.out.println("Eliminouse " + option);
							break;
						case "4":
							String editGarageInput = Input.string("Indique o nome da escudería a editar: ");
							Garage editGarage = utils.findGarage(garageList, editGarageInput);
							System.out.println("--- Opcións: ---");
							System.out.println("1. Cambiar nome");
							System.out.println("2. Engadir coche");
							System.out.println("3. Eliminar coche");
							System.out.println("0. Atrás");
							option = Input.string("\n Selección: ¿Que opción desexa realizar?: ");
							switch (option) {
							case "1":
								String newGarageName = Input.string("Indique o novo nome: ");
								editGarage.setName(newGarageName);
								break;
							case "2":
								String newCarModel = Input.string("Indique o modelo do novo coche: ");
								String newCarBrand = Input.string("Indique a marca do novo coche: ");
								Car newCar = new Car(newCarModel, newCarBrand, editGarageInput);
								editGarage.getRegisteredCars().put(newCarBrand+newCarModel, newCar);
								break;
							case "3":
								// HABERÍA QUE FACER UNHA ITERACIÓN DE HASHMAP PARA AMOSAR OS COCHES
							}
							break;
						
						}
					
					// } while (option != "0");
				
				case "2": // XESTIONAR CARREIRAS
					do {
						System.out.println("--- Opcións: ---");
						System.out.println("1. Listar carreiras");
						System.out.println("2. Engadir carreira"); 
						System.out.println("3. Eliminar carreira");
						System.out.println("4. Editar carreira");
						System.out.println("0. Volver");
						option = Input.string("\n Selección: ¿Que opción desexa realizar?: ");
						
						switch (option) {
						case "1":
							utils.printRaceList(raceList);
							break;
						case "2":
							String newRaceName = Input.string("\n Que nome quere poñerlle á carreira?: ");
							int newRaceScore = Input.integer("\n Cantos puntos debería dar a carreira?: ");
							System.out.println("1. Estándar");
							System.out.println("2. Eliminatoria"); 
							option = Input.string("\n Selección: ¿Que tipo de carreira desexa engadir?: ");
							switch (option) {
							case "1":
								int newRaceDuration = Input.integer("\n Cantos minutos debería durar a carreira?: ");
								Race newStandardRace = new StandardRace(newRaceName, newRaceScore, newRaceDuration);
								break;
							case "2":
								int newRaceWarmup = Input.integer("\n  Cantos minutos debería durar o calentamento?: ");
								Race newEliminationRace = new EliminationRace(newRaceName, newRaceScore, newRaceWarmup);
								break;
							}
							break;
						case "3":
							// LISTAR E ELIMINAR
						case "4":
							// EDITAR
						}
					} while (option != "0");
					
				case "3": // XESTIONAR TORNEOS
					do {
						System.out.println("--- Opcións: ---");
						System.out.println("1. Listar torneos");
						System.out.println("2. Engadir torneo"); 
						System.out.println("3. Eliminar torneo");
						System.out.println("4. Editar torneo");
						System.out.println("0. Volver");
						option = Input.string("\n Selección: ¿Que opción desexa realizar?: ");
						
						switch (option) {
						case "1":
							utils.printTournamentList(tournamentList);
							break;
						case "2":
							// engadir torneo
						case "3":
							// eliminar torneo
						case "4":
							String editTournamentInput = Input.string("Indique o nome do torneo a editar: ");
							Tournament editTournament = utils.findTournament(tournamentList, editTournamentInput);
							String tournamentEdit = "";

							System.out.println("--- Opcións: ---");
							System.out.println("1. Cambiar nome");
							System.out.println("2. Engadir carreira");
							System.out.println("3. Eliminar carreira");
							switch (option) {
							case "1":
								tournamentEdit = Input.string("Indique o novo nome: ");
								editTournament.setName(tournamentEdit);
							case "2":
								
								tournamentEdit = Input.string("Indique a carreira a engadir: ");
							case "3":
							}
						case "0":
							break;
						}
					} while (option != "0");
				case "4":
					// TODO a selección de escuderías debería ir antes
					System.out.println("--- ESCOLLA TORNEO: ---");
					utils.printTournamentList(tournamentList);
					System.out.println("0. Carreira individual");
					int tournamentSelect = Input.integer("\n Selección: ");
					
					if (tournamentSelect == 0) { // CARREIRAS INDIVIDUALES
						// por facer
					} else {
						System.out.println("--- ESCOLLA ESCUDERÍAS: ---");
						do {
							List<Garage> list = new ArrayList<Garage>(garageList);

							utils.printGarageList(garageList);
							System.out.println("0. Confirmar");
							inputNum = Input.integer("Seleccion: ¿Que escudería incluir?: ");
							if (inputNum == 0)
								break;
							if(participatingGarages.add(list.get(inputNum-1)) == true) {
								participatingGarages.add(list.get(inputNum-1));
								System.out.println("Engadiuse " + list.get(inputNum-1).getName());
							} else {
								System.out.println("A escudería " + list.get(inputNum-1).getName() + " xa estaba participando.");
							}
						
							} while (inputNum != 0);
						
						System.out.println("--- XERANDO TORNEO... ---");
						List<Tournament> newStartingTournament =  new ArrayList<>(tournamentList);
						newStartingTournament.get(tournamentSelect-1).setTournamentGarages(participatingGarages);
						System.out.println("--- XCARREIRAS TORNEO... ---");
						System.out.println(newStartingTournament.get(tournamentSelect-1).getTournamentRaces());
						newStartingTournament.get(tournamentSelect-1).startTournament();
					}
					
					break;
				case "5":
	
				try {
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document documento = builder.parse(new File ("src/RaceControl/cars.xml"));
					
					NodeList loadGarageList = documento.getElementsByTagName("garage");
					
					for (int i = 0 ; i < loadGarageList.getLength(); i++) { // recorre cada escuderia
						Node nodo = loadGarageList.item(i); // carga 1 escuderia en nodo
						if (nodo.getNodeType() == Node.ELEMENT_NODE) {
							Element garage =  (Element) nodo;
							Garage newGarage = new Garage(garage.getAttribute("name"));
							garageList.add(newGarage); // engadese a escudería á lista de escuderías
							
							System.out.println("--- Added garage " + newGarage.getName());
							NodeList hijos = garage.getChildNodes();
							for (int j = 0 ; j < hijos.getLength(); j++) { // recorre cada coche de una escuderia
								Node hijo = hijos.item(j);
								if(hijo.getNodeType() == Node.ELEMENT_NODE) {
									Element eHijo = (Element) hijo;
									// System.out.println(eHijo.getNodeName() + eHijo.getTextContent());
									// System.out.println(eHijo.getElementsByTagName("model").item(0).getTextContent());
									Car newCar = new Car(eHijo.getElementsByTagName("model").item(0).getTextContent(), eHijo.getElementsByTagName("brand").item(0).getTextContent(), garage.getAttribute("name"));
									System.out.println("Added car "+ newCar.getModel() + " (brand " + newCar.getBrand() + ") (garage " + newCar.getGarage());
									newGarage.addRegisteredCars(newCar.getBrand(), newCar); // engadimos o coche á lista de coches da escuderia
								}
							}
						}
					}
					
					NodeList loadTournamentList = documento.getElementsByTagName("tournament");
					List<Race> newTournamentRaces = new ArrayList<>();
					for (int i = 0 ; i < loadTournamentList.getLength(); i++) {
						Node nodo = loadTournamentList.item(i);
						if (nodo.getNodeType() == Node.ELEMENT_NODE) {
							Element tournament =  (Element) nodo;
							Tournament newTournament = new Tournament(tournament.getAttribute("name"));
							System.out.println("--- Added tournament " + newTournament.getName());
							NodeList tournamentRaces = tournament.getChildNodes();
							for (int j = 0 ; j < tournamentRaces.getLength(); j++) {
								Node tournamentRace = tournamentRaces.item( j);
								if(tournamentRace.getNodeType() == Node.ELEMENT_NODE) {
									Element eTRace = (Element) tournamentRace;
									
									// System.out.println(eTRace.getElementsByTagName("name").item(0).getTextContent() + " es una carrera tipo " + eTRace.getAttribute("type"));
									if (eTRace.getAttribute("type").equals("standard")) {
										Race newStandardRace = new StandardRace(eTRace.getElementsByTagName("name").item(0).getTextContent(), Integer.parseInt(eTRace.getElementsByTagName("points").item(0).getTextContent()), Integer.parseInt(eTRace.getElementsByTagName("time").item(0).getTextContent()));
										newTournamentRaces.add(newStandardRace);
										raceList.add(newStandardRace);
										System.out.println(eTRace.getElementsByTagName("name").item(0).getTextContent() + " es una carrera tipo " + eTRace.getAttribute("type"));
									} else {
										Race newEliminationRace = new EliminationRace(eTRace.getElementsByTagName("name").item(0).getTextContent(), Integer.parseInt(eTRace.getElementsByTagName("points").item(0).getTextContent()), Integer.parseInt(eTRace.getElementsByTagName("time").item(0).getTextContent()));
										newTournamentRaces.add(newEliminationRace);
										raceList.add(newEliminationRace);
										System.out.println(eTRace.getElementsByTagName("name").item(0).getTextContent() + " es una carrera tipo " + eTRace.getAttribute("type"));
									}
									newTournament.setTournamentRaces(newTournamentRaces);
								}
							}
							// System.out.println("LISTA DE CARRERAS AÑADIDAS A MAPLE LEAF" + newTournamentRaces);
							tournamentList.add(newTournament);
						}
					}
					
				} catch (SAXException | IOException | ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							
					
		} 
		
	} while (option != "end");
		
	}
	
}
