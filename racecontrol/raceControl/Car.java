package raceControl;

public class Car {

	protected String model = "";
	protected String brand = "";
	protected String garage = "";
	
	protected int currentSpeed = 0;
	protected int maxSpeed = 200;
	
	protected int points = 0;
	
	// El coche no gira el volante.
	//os coches frenan y aceleran de forma aleatoria. La velocidad del coche siempre aumenta o disminuye un número fijo estipulado, por ejemplo 10 km/h.
	
	
	
	// --------------
	// CONSTRUCTOR
	// --------------
	public Car(String model, String brand, String garage) {
		super();
		this.model = model;
		this.brand = brand;
		this.garage = garage;
	}
	
	
	// --------------
	// GETTER SETTERS
	// --------------
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	
	// --------------
	// MÉTODOS
	// --------------
	
	public void accelerate() {
		if (currentSpeed < maxSpeed) {
			currentSpeed += 10;
		}
	}
	
	public void deccelerate() {
		if (currentSpeed > 0) {
			currentSpeed -= 10;
		}
	}
	
}
