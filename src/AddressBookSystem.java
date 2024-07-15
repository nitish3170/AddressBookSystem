import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class AddressBookSystem {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;
    private static Scanner sc = new Scanner(System.in);

    private ArrayList<AddressBookSystem> contacts = new ArrayList<>();
    AddressBookSystem(){

        boolean check=true;
        while (check){
            System.out.println("Enter 1 to Add Contacts\nEnter 2 to edit contact\nEnter 3 to delete contact\nEnter 4 to exit");
            int i= sc.nextInt();
            sc.nextLine();
            switch (i){
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
//                    print();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    check=false;
                    break;
            }
        }
//        print();
    }
    AddressBookSystem(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email){
        this.firstName=firstName;
        this.lastName = lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
    @Override
    public String toString() {
        return "FirstName: "+firstName + "\nLastName: " + lastName + "\nAddress: "+address+"\nCity: "+city+"\nState: "+state+"\nZIP: "+zip+"\nPhone Number: "+phoneNumber+"\nEmail: "+email;
    }
    void print(){
        System.out.println("\nContact List");
        for(AddressBookSystem contact: contacts){
            System.out.println(contact);
            System.out.println();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBookSystem that = (AddressBookSystem) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }
    private void addContact(){
        System.out.println("Enter contact details:");
        System.out.print("Enter first name: ");
        String fn = sc.nextLine();
        System.out.print("Enter last name: ");
        String ln = sc.nextLine();
        System.out.print("Enter address: ");
        String add = sc.nextLine();
        System.out.print("Enter city: ");
        String city = sc.nextLine();
        System.out.print("Enter state: ");
        String state = sc.nextLine();
        System.out.print("Enter zip: ");
        String zip = sc.nextLine();
        System.out.print("Enter PhoneNo.: ");
        String phn = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        AddressBookSystem con =new AddressBookSystem(fn, ln, add, city, state, zip, phn, email);
        if (contacts.contains(con)) {
            System.out.println("This contact already exists.");
            return;
            }
        contacts.add(con);
    }
    private void editContact(){
        System.out.println("Existing contacts:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, contacts.get(i).firstName);
        }
        System.out.println("Enter the number of the contact you want to edit:");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        AddressBookSystem contact = contacts.get(index);

        System.out.println("Choose the number of the field you want to edit:");
        System.out.println("1. First Name\n2. Last Name\n3. Address\n4. City\n5. State\n6. ZIP\n7. Phone Number\n8. Email");
        int field = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the updated value:");
        String updated = sc.nextLine();

        switch (field) {
            case 1:
                contact.firstName = updated;
                break;
            case 2:
                contact.lastName = updated;
                break;
            case 3:
                contact.address = updated;
                break;
            case 4:
                contact.city = updated;
                break;
            case 5:
                contact.state = updated;
                break;
            case 6:
                contact.zip = updated;
                break;
            case 7:
                contact.phoneNumber = updated;
                break;
            case 8:
                contact.email = updated;
                break;
            default:
                System.out.println("Invalid field number.");
        }
    }
    private void deleteContact(){
        System.out.println("Existing contacts:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, contacts.get(i).firstName);
        }
        System.out.println("Enter the number of the contact you want to delete:");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        contacts.remove(index);
        System.out.println("Contact has been deleted.");
    }

    public static void main(String[] args) {}
}