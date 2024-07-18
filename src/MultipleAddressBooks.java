import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MultipleAddressBooks {
    private static HashMap<String, AddressBookSystem> addressBooks = new HashMap<>();
    private static HashMap<String, List<AddressBookSystem>> cityToPersons = new HashMap<>();
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
    private static void printEntriesSortedByState() {
        System.out.println("Entries sorted by State:");
        addressBooks.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .sorted((c1, c2) -> {
                    int stateComparison = c1.getState().compareToIgnoreCase(c2.getState());
                    if (stateComparison != 0) {
                        return stateComparison;
                    } else {
                        return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
                    }
                })
                .forEach(contact -> {
                    System.out.println(contact);
                    System.out.println();
                });
    }
    private static void printEntriesSortedByCity(){
        System.out.println("Entries sorted by State:");
        addressBooks.values().stream()
                .flatMap(book-> book.getContacts().stream())
                .sorted((c1,c2)->{
                    int cityComparison =c1.getCity().compareToIgnoreCase(c2.getCity());
                    if (cityComparison!=0){
                        return cityComparison;
                    }
                    else{
                        return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
                    }
                })
                .forEach(contact ->{
                    System.out.println(contact);
                    System.out.println();
                });
    }
    private static void printEntriesSortedByZip(){
        System.out.println("Entries sorted by State:");
        addressBooks.values().stream()
                .flatMap(book-> book.getContacts().stream())
                .sorted((c1,c2)->{
                    int zipComparison =c1.getZip().compareToIgnoreCase(c2.getZip());
                    if (zipComparison!=0){
                        return zipComparison;
                    }
                    else{
                        return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
                    }
                })
                .forEach(contact ->{
                    System.out.println(contact);
                    System.out.println();
                });
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
    public void sortContacts (){

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        MultipleAddressBooks multipleAddressBooks = new MultipleAddressBooks();

        boolean check = true;
        while (check) {
            System.out.println("Enter 1 to Add Address Book\nEnter 2 to Search by City\nEnter 3 to Search by State\nEnter 4 to Count by City\nEnter 5 to Count by State\nEnter 6 to sort by City\nEnter 6 to sort by State\nEnter 6 to sort by Zip\nEnter 9 to Exit");
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
                    System.out.println("Enter city name to search:");
                    String cityCount = sc.nextLine();
                    System.out.print("Number of contacts found in "+ cityCount +": "+cityToPersons.getOrDefault(cityCount, new ArrayList<>()).size() );
                    break;
                case 5:
                    System.out.println("Enter state name to search:");
                    String stateCount = sc.nextLine();
                    System.out.print("Number of contacts found in "+ stateCount +": "+cityToPersons.getOrDefault(stateCount, new ArrayList<>()).size() );
                    break;
                case 6:
                    printEntriesSortedByCity();
                case 7:
                    printEntriesSortedByState();
                case 8:
                    printEntriesSortedByZip();
                case 9:
                    check = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

    }


}
