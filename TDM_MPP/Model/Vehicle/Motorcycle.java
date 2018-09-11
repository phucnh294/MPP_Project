package Vehicle;

public class Motorcycle {
	private int fuelType;
	private int numberOfEngine;
	private int tranmissionType;
	public int getTranmissionType() {
		return tranmissionType;
	}
	public void setTranmissionType(int tranmissionType) {
		this.tranmissionType = tranmissionType;
	}
	public int getNumberOfEngine() {
		return numberOfEngine;
	}
	public void setNumberOfEngine(int numberOfEngine) {
		this.numberOfEngine = numberOfEngine;
	}
	public int getFuelType() {
		return fuelType;
	}
	public void setFuelType(int fuelType) {
		this.fuelType = fuelType;
	}
}
