package Vehicle;

import java.time.LocalDate;

public class Transport {
	private int id;
	private String name;
	private String brand;
	private double price;
	private LocalDate createdDate;
	private String model;
	private String description;
	private String manufactor;
	private int seatCapacity;
	private int fuelType;
	private double mileage;
	private int tranmissionType;
	private int numberOfEngine;
	private int transportType;
	
	
	
	public int getTransportType() {
		return transportType;
	}
	public void setTransportType(int transportType) {
		this.transportType = transportType;
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
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public int getTranmissionType() {
		return tranmissionType;
	}
	public void setTranmissionType(int tranmissionType) {
		this.tranmissionType = tranmissionType;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufactor() {
		return manufactor;
	}
	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}
	//havent have image
	
}
