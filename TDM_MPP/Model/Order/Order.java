/**
 * 
 */
package Order;

import java.time.LocalDate;

/**
 * @author ptkie
 *
 */
public class Order {
	
	private int id;
	private double amount;
	private LocalDate orderDate;
	private int customerID;
	private int dealerID;
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
	
	

}
