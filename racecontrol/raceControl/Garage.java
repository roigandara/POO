package raceControl;


import java.util.HashMap;


public class Garage {
	protected String name;
	// protected List<Car> registeredCars = new ArrayList<Car>();
	protected HashMap<String, Car> registeredCars  = new HashMap<String, Car>();
	
	// --------------
	// CONSTRUCTOR
	// --------------
	
	public Garage(String name) {
		this.name = name;
	}
	
	public Garage(String name, HashMap<String, Car> registeredCars) {
		super();
		this.name = name;
		this.registeredCars = registeredCars;
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
	public HashMap<String, Car> getRegisteredCars() {
		return registeredCars;
	}
	public void setRegisteredCars(HashMap<String, Car> registeredCars) {
		this.registeredCars = registeredCars;
	}
	
	public void addRegisteredCars(String name, Car car) {
		this.registeredCars.put(name, car);
	}
	
	
}


