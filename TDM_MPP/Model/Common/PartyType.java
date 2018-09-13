package Common;

public enum PartyType {
	CUSTOMER("CUSTOMER"),
	DEALER("DEALER"),
	ADMIN("ADMIN");

	private String s;

   private PartyType(String s) {
      this.s = s;
   }
    public String getS() {
        return this.s;
    }
}
