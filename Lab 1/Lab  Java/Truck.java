
/**
 * Like song but with more truck
 *
 * @author Braden Gerlach
 * @version 2024.17.4
 */

public class Truck {
    private String manufacturer;
    private int numAxles;
    private int mileage;
 
    public Truck(String truckManufacturer, int truckAxles) {
        manufacturer = truckManufacturer;
        numAxles = truckAxles;
        mileage = 0; // Set mileage to 0 by default
    }

    // Getters and setters
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getNumAxles() {
        return numAxles;
    }

    public void setNumAxles(int numAxles) {
        this.numAxles = numAxles;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
