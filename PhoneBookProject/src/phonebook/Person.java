package phonebook;

public class Person extends Contact {

	private String fullName;
	private String firstName;
	private String middleName;
	private String lastName;
	private Address addresses;

	public Person() {

	}

	public Person(String fullName, String firstName, String middleName, String lastName, Address addresses) {
		this.fullName = fullName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.addresses = addresses;
	}

	public Person(String fullName) {
		this.fullName = fullName;
		String[] nameArr = fullName.split(" ");

		if (nameArr.length == 2) {
			this.firstName = nameArr[0];
			this.lastName = nameArr[1];
		} else if (nameArr.length > 2) {
			this.firstName = nameArr[0];
			this.lastName = nameArr[nameArr.length - 1];
			for (int i = 1; i < nameArr.length - 1; i++) {
				this.middleName = nameArr[i];
			}

		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getInfo() {
		return fullName;
	}

	public Address getAddress() {
		return addresses;
	}

	public void setAddress(Address address) {
		this.addresses = address;
	}

	public String getFullName() {
		String[] fullNameArr = fullName.split(" ");
		String fullNames = "";
		if (fullNameArr.length < 3) {
			fullNames = firstName + " " + lastName;
		} else {
			fullNames = firstName + " " + middleName + " " + lastName;

		}
		return fullNames;
	}

	public String getAllInfo() {
		return getFullName() + " " + addresses.getStreetAddress() + " " + addresses.getCity() + " "
				+ addresses.getState() + " " + addresses.getZip() + " " + addresses.getPhoneNum();
	}
	
}
