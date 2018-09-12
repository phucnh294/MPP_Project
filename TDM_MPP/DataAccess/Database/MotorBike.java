package Database;

public class MotorBike extends Transport {

	private int fuelType;
	private int numberOfEngine;
	private TRANMISSIONTYPE tranmissionType;
	
	public enum TRANMISSIONTYPE {
		AUTO, MANUAL
	}
	/**
	 * @return the fuelType
	 */
	public int getFuelType() {
		return fuelType;
	}
	/**
	 * @param fuelType the fuelType to set
	 */
	public void setFuelType(int fuelType) {
		this.fuelType = fuelType;
	}
	/**
	 * @return the numberOfEngine
	 */
	public int getNumberOfEngine() {
		return numberOfEngine;
	}
	/**
	 * @param numberOfEngine the numberOfEngine to set
	 */
	public void setNumberOfEngine(int numberOfEngine) {
		this.numberOfEngine = numberOfEngine;
	}
	/**
	 * @return the tranmissionType
	 */
	public TRANMISSIONTYPE getTranmissionType() {
		return tranmissionType;
	}
	/**
	 * @param tranmissionType the tranmissionType to set
	 */
	public void setTranmissionType(TRANMISSIONTYPE tranmissionType) {
		this.tranmissionType = tranmissionType;
	}
	
	
	
}
