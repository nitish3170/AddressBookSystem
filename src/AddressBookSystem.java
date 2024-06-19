import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystem {
    private String firstName;
    private String lastNames;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;
    static ArrayList<AddressBookSystem> contacts=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    AddressBookSystem(String firstName,String lastNames,String address,String city,String state,int zip,long phoneNumber,String email){
        this.firstName=firstName;
        this.lastNames=lastNames;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
    @Override
    public String toString() {
        return "FirstName: "+firstName + "\nLastName: " + lastNames + "\nAddress: "+address+"\nCity: "+city+"\nState: "+state+"\nZIP: "+zip+"\nPhone Number: "+phoneNumber+"\nEmail: "+email;

    }
    static void print(){
        for(AddressBookSystem contact: contacts){
            System.out.println(contact);
        }
    }
    private static void addContacts(){
        System.out.println("Enter contact details");
        System.out.println("Enter first name:");
        String fn= sc.next();
        System.out.println("Enter last name:");
        String ln= sc.next();
        System.out.println("Enter address:");
        String add= sc.nextLine();
        System.out.println("Enter city:");
        String city= sc.next();
        System.out.println("Enter state:");
        String state= sc.next();
        System.out.println("Enter zip:");
        int zip= sc.nextInt();
        System.out.println("Enter PhoneNo.:");
        long phn= sc.nextLong();
        System.out.println("Enter email:");
        String email= sc.next();
        contacts.add(new AddressBookSystem(fn,ln,add,city,state,zip,phn,email));
    }
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book System");
//        AddressBookSystem Contact1=new AddressBookSystem("Aman","Singh","12/A Malhotra Heights","Mumbai","Maharastra",208037,9876543210L,"amam@gmail.com");
        ArrayList<AddressBookSystem> contacts=new ArrayList<>();
        System.out.println("Enter number of contacts");
        int n= sc.nextInt();
        for (int i=0;i<n;i++){
            addContacts();
        }
        print();

    }
}