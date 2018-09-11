/**
 * 
 */
package Database;

/**
 * @author 986338
 *
 */
public class Car extends Transport {

	private int seatCapacity;
	private FUELTYPE fuelType;
	private long mileage;
	private TRANMISSIONTYPE tranmissionType;
	
	public enum FUELTYPE {
		ONE, TWO
	}
	
	public enum TRANMISSIONTYPE {
		AUTO, MANUAL
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public FUELTYPE getFuelType() {
		return fuelType;
	}

	public void setFuelType(FUELTYPE fuelType) {
		this.fuelType = fuelType;
	}

	public long getMileage() {
		return mileage;
	}

	public void setMileage(long mileage) {
		this.mileage = mileage;
	}

	public TRANMISSIONTYPE getTramissionType() {
		return tranmissionType;
	}

	public void setTramissionType(TRANMISSIONTYPE tranmissionType) {
		this.tranmissionType = tranmissionType;
	}
	
}
