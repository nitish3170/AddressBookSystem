import java.util.ArrayList;
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
    static ArrayList<AddressBookSystem> contacts=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
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
    static void print(){
        System.out.println("\nContact List");
        for(AddressBookSystem contact: contacts){
            System.out.println(contact);
            System.out.println();
        }
    }
    private static void addContact(){
        System.out.printf("Enter contact details: \n");
        System.out.printf("Enter first name: ");
        String fn= sc.nextLine();
        System.out.printf("Enter last name: ");
        String ln= sc.nextLine();
        System.out.printf("Enter address: ");
        String add= sc.nextLine();
        System.out.printf("Enter city: ");
        String city= sc.nextLine();
        System.out.printf("Enter state: ");
        String state= sc.nextLine();
        System.out.printf("Enter zip: ");
        String zip= sc.nextLine();
        System.out.printf("Enter PhoneNo.: ");
        String  phn= sc.nextLine();
        System.out.printf("Enter email: ");
        String email= sc.nextLine();
        contacts.add(new AddressBookSystem(fn,ln,add,city,state,zip,phn,email));
    }
    private static void editContact(){
        for(int i=0;i<contacts.size();i++){
            System.out.printf("%s\n",contacts.get(i).firstName);
        }
        System.out.println("Enter the name of the contact you want to edit");
        String name= sc.nextLine();
        for(AddressBookSystem contact:contacts){
            if (contact.firstName.equals(name)){
                System.out.println("Choose the number of field you want to edit :\n1-> FirstName\n2-> LastName\n3-> Address\n4-> City\n5-> State\n6-> ZIP\n7-> Phone Number\n8-> Email");
                int i= sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the updated value");
                String updated=sc.nextLine();
                switch (i){
                    case 1:
                        contact.firstName=updated;
                        break;
                    case 2:
                        contact.lastName =updated;
                        break;
                    case 3:
                        contact.address=updated;
                        break;
                    case 4:
                        contact.city=updated;
                        break;
                    case 5:
                        contact.state=updated;
                        break;
                    case 6:
                        contact.zip=updated;
                        break;
                    case 7:
                        contact.phoneNumber=updated;
                        break;
                    case 8:
                        contact.email=updated;
                        break;
                }
            }
        }
    }
    static void deleteContact(){
        for(int i=0;i<contacts.size();i++){
            System.out.printf("%s\n",contacts.get(i).firstName);
        }
        System.out.println("Enter the name of the contact you want to delete");
        String name= sc.nextLine();
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).firstName.equals(name)){
                contacts.remove(i);
            }
        }
        System.out.println("Contact has been deleted");
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book System");
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
        print();
    }
}