package Vehicle;

public class Car extends Transport {
	
	private int seatCapacity;
	private int fuelType;
	private double mileage;
	private int tranmissionType;
	public int getTranmissionType() {
		return tranmissionType;
	}
	public void setTranmissionType(int tranmissionType) {
		this.tranmissionType = tranmissionType;
	}
	public int getFuelType() {
		return fuelType;
	}
	public void setFuelType(int fuelType) {
		this.fuelType = fuelType;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

}
