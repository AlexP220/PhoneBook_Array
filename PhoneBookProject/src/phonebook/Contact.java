package phonebook;

abstract public class Contact {

	
	public void printInfo() {
		System.out.println(getInfo());
	}

	abstract public String getInfo();

}
