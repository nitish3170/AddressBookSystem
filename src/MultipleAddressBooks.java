import java.util.HashMap;
import java.util.Scanner;

public class MultipleAddressBooks {
    private static void searchInCity(HashMap<String, AddressBookSystem> addressBooks, String cityName) {
        System.out.println("Search Results in City \"" + cityName + "\":");
        addressBooks.values().stream()
                .flatMap(book -> book.getContacts().stream()) // Flatten all contacts from all address books
                .filter(contact -> contact.isInCity(cityName)) // Filter contacts in the specified city
                .forEach(contact -> {
                    System.out.println(contact);
                    System.out.println(); // Print each matching contact
                });
    }
    private static void searchInState(HashMap<String, AddressBookSystem> addressBooks, String stateName) {
        System.out.println("Search Results in State \"" + stateName + "\":");
        addressBooks.values().stream()
                .flatMap(book -> book.getContacts().stream()) // Flatten all contacts from all address books
                .filter(contact -> contact.isInState(stateName)) // Filter contacts in the specified state
                .forEach(contact -> {
                    System.out.println(contact);
                    System.out.println(); // Print each matching contact
                });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, AddressBookSystem> addressBooks = new HashMap<>();
        System.out.println("Welcome to Address Book System");

        boolean check = true;
        while (check) {
            System.out.println("Enter the name of the address book:");
            String name = sc.next();
            if (addressBooks.containsKey(name)) {
                System.out.println("Address book with this name already exists. Please choose another name.");
                continue;
            }
            AddressBookSystem newAddressBook = new AddressBookSystem();
            addressBooks.put(name, newAddressBook);
            System.out.println("Address Book \"" + name + "\" created.");

            boolean operate = true;
            while (operate) {
                System.out.println("\nEnter operation for Address Book \"" + name + "\":");
                System.out.println("1. Add Contact\n2. Edit Contact\n3. Delete Contact\n4. Print Contacts\n5. Search in City\n6. Search in State\n7. Exit");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        newAddressBook.addContact();
                        break;
                    case 2:
                        newAddressBook.editContact();
                        break;
                    case 3:
                        newAddressBook.deleteContact();
                        break;
                    case 4:
                        newAddressBook.print();
                        break;
                    case 5:
                        System.out.println("Enter city name to search:");
                        String city = sc.nextLine();
                        searchInCity(addressBooks, city);
                        break;
                    case 6:
                        System.out.println("Enter state name to search:");
                        String state = sc.nextLine();
                        searchInState(addressBooks, state);
                        break;
                    case 7:
                        operate = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }
            }

            System.out.println("Do you want to add another Address Book? (y/n)");
            String ch = sc.next();
            if (ch.equalsIgnoreCase("n")) {
                check = false;
            }
        }

    }
}
