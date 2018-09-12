package User;

public class Party extends User {
	private int customerId;
	private String type;
	private String hobbies;
	private int marriageStatus;	
	
	public int getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(int marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

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
