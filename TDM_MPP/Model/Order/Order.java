/**
 * 
 */
package Order;

import java.time.LocalDate;
import java.util.List;

import Vehicle.Transport;

/**
 * @author ptkie
 *
 */
public class Order {
	
	private int id;
	private double amount;
	private LocalDate orderDate;
	private int customerID;
	
	private String customerName;
		
	private int dealerID;
	private String dealerName;
	
	private List<Transport> transports;	
	
	public List<Transport> getTransports() {
		return transports;
	}
	public void setTransports(List<Transport> transports) {
		this.transports = transports;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getDealerID() {
		return dealerID;
	}
	public void setDealerID(int dealerID) {
		this.dealerID = dealerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getTransportType() {
		return transportType;
	}
	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}



	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	private String transportType;
	private String brand;
	private double price; 

}
