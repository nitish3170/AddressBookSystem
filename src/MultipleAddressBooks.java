import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MultipleAddressBooks {
    private HashMap<String, AddressBookSystem> addressBooks = new HashMap<>();
    private HashMap<String, List<AddressBookSystem>> cityToPersons = new HashMap<>();
    private HashMap<String, List<AddressBookSystem>> stateToPersons = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);


    private void addAddressBook(String name) {
        if (addressBooks.containsKey(name)) {
            System.out.println("Address book with this name already exists. Please choose another name.");
        } else {
            AddressBookSystem newAddressBook = new AddressBookSystem();
            addressBooks.put(name, newAddressBook);
            updateCityAndStateMappings(newAddressBook);
            System.out.println("Address Book \"" + name + "\" created.");
        }
    }
    private void updateCityAndStateMappings(AddressBookSystem addressBook) {
        for (AddressBookSystem contact : addressBook.getContacts()) {
            cityToPersons.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);
            stateToPersons.computeIfAbsent(contact.getState(), k -> new ArrayList<>()).add(contact);
        }
    }
    private void searchInCity(String cityName) {
        System.out.println("Search Results in City \"" + cityName + "\":");
        cityToPersons.getOrDefault(cityName, new ArrayList<>()).forEach(contact -> {
            System.out.println(contact);
            System.out.println();
        });
    }
    private void searchInState(String stateName) {
        System.out.println("Search Results in State \"" + stateName + "\":");
        stateToPersons.getOrDefault(stateName, new ArrayList<>()).forEach(contact -> {
            System.out.println(contact);
            System.out.println();
        });
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        MultipleAddressBooks multipleAddressBooks = new MultipleAddressBooks();

        boolean check = true;
        while (check) {
            System.out.println("Enter 1 to Add Address Book\nEnter 2 to Search by City\nEnter 3 to Search by State\nEnter 4 to Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the address book:");
                    String name = sc.nextLine();
                    multipleAddressBooks.addAddressBook(name);
                    break;
                case 2:
                    System.out.println("Enter city name to search:");
                    String city = sc.nextLine();
                    multipleAddressBooks.searchInCity(city);
                    break;
                case 3:
                    System.out.println("Enter state name to search:");
                    String state = sc.nextLine();
                    multipleAddressBooks.searchInState(state);
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

    }
}
