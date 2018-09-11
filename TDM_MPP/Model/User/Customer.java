package User;

public class Customer extends User{
	private int customerId;
	private String type;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return String.format("CustomerId: %S\nCustomerName: %s\nBirthOfDate: %s\nUsername: %s\nCustomerType: %s",
				customerId, this.getUsername(), this.getBirthDate(), this.getUsername(), type);
		
	}
}
