import java.util.HashMap;
import java.util.Scanner;

public class MultipleAddressBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, AddressBookSystem> addressBooks = new HashMap<>();
        System.out.println("Welcome to Address Book System");

        boolean check = true;
        while (check) {
            System.out.println("Enter the name of the address book:");
            String name = sc.next();
            if (addressBooks.containsKey(name)) {
                System.out.println("Address book with this name already exists. Please choose a different name.");
            } else {
                addressBooks.put(name, new AddressBookSystem());
                System.out.println("Address Book \"" + name + "\" created.");
            }
            System.out.println("Do you want to add a new Address Book? (y/n)");
            String ch = sc.next();
            if (ch.equalsIgnoreCase("n")) {
                check = false;
            }
        }

        for (String key : addressBooks.keySet()) {
            System.out.printf("Details of Address Book \"%s\":\n", key);
            addressBooks.get(key).print();
        }

    }
}
