public class AddressBookSystem {
    private String firstName;
    private String lastNames;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;
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
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        AddressBookSystem Contact1=new AddressBookSystem("Aman","Singh","12/A Malhotra Heights","Mumbai","Maharastra",208037,9876543210L,"amam@gmail.com");
    }
}