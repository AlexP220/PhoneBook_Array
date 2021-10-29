package phonebook;


import java.util.Scanner;

public class SwitchMenu {

	private Person[] people = new Person[0];
	private Address[] addresses = new Address[0];
	Scanner in = new Scanner(System.in);

	public SwitchMenu() {

	}

	public void menu() {
		

		int choice = 0;
		int choice1 = 0;

		do {
			menuMain();
			choice = in.nextInt();
			
			switch (choice) {
			case 1:
				if (choice == 1) {
					menu1();
					choice1 = in.nextInt();

					switch (choice1) {
					case 1:
						System.out.println("Please enter Contact Infomation");
						System.out.println("");
						in = new Scanner(System.in);
						String userInput = in.nextLine();
						System.out.println("");
						String[] testCase = createTestCase(userInput);
						String fullName = testCase[0];
						Person p1 = new Person(fullName);
						int zip = Integer.parseInt(testCase[4]);
						String phone = testCase[5];
						Address a1 = new Address(testCase[1], testCase[2], testCase[3], zip, phone, p1);
						this.people = addToArray(this.people, p1);
						p1.setAddress(a1);
						this.addresses = addToArray(this.addresses, a1);
						System.out.println("Record added");
						System.out.println(" ");
						System.out.println(userInput);


						
						break;
					case 2:
						System.out.println("Delete a record for a given phone number.");
						System.out.println("Please enter phone number.");
						String phoneNumber = in.next();

						for (int i = 0; i < addresses.length; i++) {
							Address currentAddress = addresses[i];
							Person currentPerson = people[i];
							if (currentAddress.getPhoneNum().equals(phoneNumber)) {

								this.addresses = subtractFromArray(this.addresses, currentAddress);
								this.people = subtractFromArray(this.people, currentPerson);
							}

						}

						break;
					case 3:
						System.out.println("Update a record for a given phone number.");
						System.out.println(" ");
						System.out.println("Please enter phone number.");
						String phoneNumber2 = in.next();

						System.out.println("Would you like to update first name? Y for Yes | N for No");
						String answer2 = in.next().toLowerCase();
						if (answer2.equals("y") || answer2.equals("yes")) {
							for (int i = 0; i < addresses.length; i++) {
								Address currentPerson = addresses[i];
								if (currentPerson.getPhoneNum().equals(phoneNumber2)) {
									System.out.println("Enter new first name.");
									String newFirstName = in.next();

									this.people[i].setFirstName(newFirstName);

								}
							}
							alphabeticalOrder();
							break;
						} else {
							System.out.println("Would you like to update last name?  Y for Yes | N for No");
							String answer3 = in.next().toLowerCase();
							if (answer3.equals("yes") || answer3.equals("y")) {
								for (int i = 0; i < addresses.length; i++) {
									Address currentPerson = addresses[i];
									if (currentPerson.getPhoneNum().equals(phoneNumber2)) {

										System.out.println("Enter new last name.");
										String newLastName = in.next();

										this.people[i].setLastName(newLastName);
										break;
									}
								}
								alphabeticalOrder();
								break;
							} else {
								System.out.println("Would you like to update street address? Y for Yes | N for No");
								String answer = in.next().toLowerCase();
								if (answer.equals("y") || answer.equals("yes")) {
									for (int i = 0; i < addresses.length; i++) {
										Address currentAddress = addresses[i];
										if (currentAddress.getPhoneNum().equals(phoneNumber2)) {

											System.out.println("Enter new street address.");
											String newStreet = in.next();

											this.addresses[i].setStreetAddress(newStreet);

										}

									}
									alphabeticalOrder();
									break;

								} else {
									System.out.println("Would you like to update the city? Y for Yes | N for No");
									String answer1 = in.next().toLowerCase();
									if (answer1.equals("y") || answer1.equals("yes")) {
										for (int i = 0; i < addresses.length; i++) {
											Address currentAddress = (Address) addresses[i];
											if (currentAddress.getPhoneNum().equals(phoneNumber2)) {

												System.out.println("Enter new City.");
												String newCity = in.next();

												this.addresses[i].setCity(newCity);
												break;
											}

										}
										break;

									} else {
										System.out.println("Would you like to update the state? Y for Yes | N for No");
										String answer4 = in.next().toLowerCase();
										if (answer4.equals("y") || answer4.equals("yes")) {
											for (int i = 0; i < addresses.length; i++) {
												Address currentAddress = addresses[i];
												if (currentAddress.getPhoneNum().equals(phoneNumber2)) {

													System.out.println("Enter new State.");
													String newStreet = in.next();

													this.addresses[i].setState(newStreet);
													break;
												}

											}
											alphabeticalOrder();
											break;

										} else {
											System.out.println("Would you like to update the zip? Y for Yes | N for No");
											String answer5 = in.next().toLowerCase();
											if (answer5.equals("y") || answer5.equals("yes")) {
												for (int i = 0; i < addresses.length; i++) {
													Address currentAddress = (Address) addresses[i];
													if (currentAddress.getPhoneNum().equals(phoneNumber2)) {

														System.out.println("Enter new Zip Code.");
														int newStreet = in.nextInt();

														this.addresses[i].setZip(newStreet);
														break;
													}

												}
												alphabeticalOrder();
												break;

											} else {
												System.out.println(
														"Would you like to update the phone number? Y for Yes | N for No");
												String answer6 = in.next().toLowerCase();
												if (answer6.equals("y") || answer6.equals("yes")) {
													for (int i = 0; i < addresses.length; i++) {
														Address currentAddress = addresses[i];
														if (currentAddress.getPhoneNum().equals(phoneNumber2)) {

															System.out.println("Enter new phone number.");
															String newZip = in.next();

															this.addresses[i].setPhoneNum(newZip);
															break;
														}

													}
													alphabeticalOrder();
													break;

												}
											}
										}
									}
								}
							}

						}

						break;
					default:
						choice = 0;
						break;
					}
				}
				break;
			case 2:
				System.out.println("Search by first name.");
				System.out.println(" ");
				System.out.println("Please enter first name.");
				String firstName = in.next();
				searchUsingFirstName(firstName);
				break;
			case 3:
				System.out.println("Search by last name.");
				System.out.println(" ");
				System.out.println("Please enter last name.");
				String lastName = in.next();
				searchUsingLastName(lastName);
				break;
			case 4:
				System.out.println("Search by full name.");
				System.out.println(" ");
				System.out.println("Please enter full name.");
				String fullName = "";
				in.nextLine();
				fullName += in.nextLine();
				searchUsingFullName(fullName);
				break;
			case 5:
				System.out.println("Search by telephone number.");
				System.out.println(" ");
				System.out.println("Please enter telephone number.");
				String teleNum = in.next();
				searchUsingTelephoneNum(teleNum);
				break;
			case 6:
				System.out.println("Search by city.");
				System.out.println(" ");
				System.out.println("Please enter city.");
				String city = "";
				in.nextLine();
				city += in.nextLine();
				searchUsingCity(city);
				break;
			case 7:
				System.out.println("Search by state.");
				System.out.println(" ");
				System.out.println("Please enter State.");
				String state = in.next();
				searchUsingState(state);
				break;
			default:
				break;
			}
			System.out.println("");
			System.out.println("Would you like to continue? Y for Yes | N for No");
			String runAgain = in.next().toLowerCase();
			if (runAgain.equals("y")) {
				choice = 0;

			} else if (runAgain.equals("n")) {
				choice = 10;
			}
			
		} while (choice != 10);
		
		in.close();
	}

	public void menuMain() {
		System.out.println("Please press (1) to add a new entry,");
		System.out.println("to delete a record for a given phone number");
		System.out.println("or update a record for a given phone number.");
		System.out.println("Press (2) to search by first name.");
		System.out.println("(3) to search by last name.");
		System.out.println("(4) to search by full name.");
		System.out.println("(5) to search by telephone number.");
		System.out.println("(6) to search by city.");
		System.out.println("(7) to search by state.");
		System.out.println("");
	}

	public void menu1() {
		System.out.println("Please press (1) to add an entry.");
		System.out.println("Press (2) to delete a record for a given phone number.");
		System.out.println("Press (3) to update a record for a given phone number.");
		System.out.println("Press any other to go back to the main menu.");
	}

	public static String[] createTestCase(String elem) {
		String[] casToElem = elem.split(",\s*");

		return casToElem;
	}

	public void autoInputContacts(String contact) {

		String userInput = contact;
		String[] testCase = createTestCase(userInput);
		String fullName = testCase[0];
		Person p1 = new Person(fullName);
		int zip = Integer.parseInt(testCase[4]);
		String phone = testCase[5];
		Address a1 = new Address(testCase[1], testCase[2], testCase[3], zip, phone, p1);
		p1.setAddress(a1);
		this.people = addToArray(this.people, p1);
		this.addresses = addToArray(this.addresses, a1);

	}

	public Person[] addToArray(Person[] array, Person newPerson) {
		Person[] newArray = new Person[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];

		}
		newArray[newArray.length - 1] = newPerson;
		this.people = newArray;
		alphabeticalOrder();
		return newArray;

	}

	public Address[] addToArray(Address[] array, Address newAddress) {
		Address[] newArray = new Address[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];

		}
		newArray[newArray.length - 1] = newAddress;
		this.addresses = newArray;
		alphabeticalOrder();
		return newArray;
	}

	public Person[] subtractFromArray(Person[] array, Person deletedElement) {
		Person[] newArray = new Person[array.length - 1];
		int newIndex = 0;
		for (Person item : array) {
			if (item == null)
				continue;
			if (item.getAddress().getPhoneNum().equals(deletedElement.getAddress().getPhoneNum())) {
				continue; 
			} else {
				newArray[newIndex] = item;
				newIndex++;
			}
		}

//		for (int i = 0; i < newArray.length; i++) {
//			System.out.println("Person " + newArray[i].getAllInfo());
//
//		}

		return newArray;

	}

	public Address[] subtractFromArray(Address[] array, Address deletedElement) {
		Address[] newArray = new Address[array.length - 1];

		int newIndex = 0;
		for (Address item : array) {
			if (item.getPerson().getAddress() == null)
				continue;
			if (item.getPhoneNum().equals(deletedElement.getPhoneNum())) {
				continue; // continue skips a loop when we found the item we want to delete
			} else {
				newArray[newIndex] = item;
				newIndex++;
			}
		}
//		for (int i = 0; i < newArray.length; i++) {
//			System.out.println("Address " + newArray[i].getAllInfoPlusFullName());
//
//		}
		return newArray;
	}

	public void searchUsingFirstName(String searchFor) {

		for (int i = 0; i < people.length; i++) {
			Person p1 = people[i];

			if (p1 != null) {
				if (p1.getAddress() != null) {
					if (searchFor.equals(p1.getFirstName())) {
						System.out.println(p1.getFullName() + " " + p1.getAddress().getMostInfo());
					}
				}
			}
		}
	}

	public void searchUsingLastName(String searchFor) {

		for (int i = 0; i < people.length; i++) {

			Person p1 = people[i];

			if (searchFor.equals(p1.getLastName())) {
				System.out.println(p1.getFullName() + " " + p1.getAddress().getMostInfo());

			}

		}

	}

	public void searchUsingFullName(String searchFor) {

		for (int i = 0; i < people.length; i++) {

			Person p1 = people[i];

			if (searchFor.equalsIgnoreCase(p1.getFullName())) {

				System.out.println(p1.getFullName() + " " + p1.getAddress().getMostInfo());

			}
		}
	}

	public void searchUsingTelephoneNum(String searchFor) {

		for (int i = 0; i < people.length; i++) {

			Person p1 = people[i];
			Address a1 = addresses[i];
			if (searchFor.equals(a1.getPhoneNum())) {
				System.out.println(p1.getFullName() + " " + p1.getAddress().getMostInfo());

			}
		}
	}

	public void searchUsingCity(String searchFor) {

		for (int i = 0; i < people.length; i++) {

			Address a1 = addresses[i];
			if (searchFor.equals(a1.getCity())) {
				System.out.println(a1.getPerson().getFullName() + " " + a1.getMostInfo());

			}
		}
	}

	public void searchUsingState(String searchFor) {

		for (int i = 0; i < people.length; i++) {

			Address a1 = addresses[i];
			if (searchFor.equals(a1.getState())) {
				System.out.println(a1.getPerson().getFullName() + " " + a1.getMostInfo());

			}
		}
	}
	
	
	public void alphabeticalOrder() {

		
		for (int i = 0; i < this.people.length; i++) {
			String iName = this.people[i].getFullName();
			for (int j = 0; j < this.people.length; j++) {
				String jName = this.people[j].getFullName();
				if(iName.compareToIgnoreCase(jName)<0) {
					Person temp = this.people[i];
					this.people[i] = this.people[j];
					this.people[j] = temp;
				}
			}
			
		}
		for (int i = 0; i < this.addresses.length; i++) {
			String iName = this.addresses[i].getPerson().getFullName();
			for (int j = 0; j < this.addresses.length; j++) {
				String jName = this.addresses[j].getPerson().getFullName();
				if(iName.compareToIgnoreCase(jName)<0) {
					Address temp = this.addresses[i];
					this.addresses[i] = this.addresses[j];
					this.addresses[j] = temp;
				}
			}
			
		}
	}
}
