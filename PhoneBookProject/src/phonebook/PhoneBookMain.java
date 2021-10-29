package phonebook;


import java.util.Scanner;

public class PhoneBookMain {
	Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String contact1 = "Julie Fisher, 123 North St, Las Vegas, MO, 45678, 1234567890";
		String contact2 = "Mad D Child, 567 Droopy ln, Seattle, MO, 98737, 8976543219";
		String contact3 =  "John Hoe, 114 Market St, St Louis, MO, 63403, 6366435698";
		String contact4 = "John E Goe, 324 Main St, St Charles, MO, 63303, 8475390126";

		SwitchMenu sm = new SwitchMenu();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
//		sm.autoInputContacts(contact1);
//		sm.autoInputContacts(contact2);
//		sm.autoInputContacts(contact3);
//		sm.autoInputContacts(contact4);	
		System.out.println("------------------------");
		System.out.println("|  Press enter to use  |");
		System.out.println("|    the PHONE BOOK    |");
		System.out.println("------------------------");
		in.nextLine();
		

		
		sm.menu();
	}



}
