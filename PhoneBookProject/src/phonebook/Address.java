package phonebook;

public class Address extends Contact {

	private String streetAddress;
	private String city;
	private String state;
	private int zip;
	private String phoneNum;
	private Person person;

	public Address(String streetAddress, String city, String state, int zip, String phoneNum, Person person) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNum = phoneNum;
		this.person = person;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String getInfo() {
		return streetAddress + " " + phoneNum + " " + person.getFullName();
	}

	public String getAllInfo() {
		return streetAddress + " " + city + " " + state + " " + zip + " " + phoneNum;
	}

	public String getAllInfoPlusFullName() {
		return person.getFullName() + " " + streetAddress + " " + city + " " + state + " " + zip + " " + phoneNum;
	}

	public String getMostInfo() {
		return streetAddress + " " + city + " " + state + " " + zip + " " + phoneInFormat(phoneNum);
	}

	public String phoneInFormat(String phoneNum) {
		String[] phoneNumber = phoneNum.split("");
		String numfor = "";
		int count = 0;

		for (int i = 0; i < phoneNumber.length; i++) {
			if (count == 0) {
				numfor += "(" + phoneNumber[i];
				count++;
			} else if (count == 3) {
				numfor += ")-" + phoneNumber[i];
				count++;
			} else if (count == 6) {
				numfor += "-" + phoneNumber[i];
				count++;
			} else {
				numfor += phoneNumber[i];
				count++;
			}

		}

		return numfor;
	}

	public Person getPerson() {
		return person;
	}

	public String getFirstName() {
		return person.getFirstName();
	}
}
