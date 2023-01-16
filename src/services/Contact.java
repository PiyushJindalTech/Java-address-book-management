package services;

import java.util.ArrayList;
import java.util.Scanner;
import models.ContactModel;

public class Contact {
    static ArrayList<ContactModel> contactList = new ArrayList<ContactModel>();

    public void AddContact(int addressBookId) {
        ContactModel contactModel = new ContactModel();
        contactModel.addressBookId = addressBookId;
        System.out.println("Enter your details as follows ");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter first  name ");
        contactModel.firstname = userInput.nextLine();

        System.out.println("Enter last name ");
        contactModel.lastname = userInput.nextLine();

        System.out.println("Enter your address ");
        contactModel.address = userInput.nextLine();

        System.out.println("Enter city ");
        contactModel.city = userInput.nextLine();

        System.out.println("Enter state ");
        contactModel.state = userInput.nextLine();

        System.out.println("Enter ZIP  ");
        contactModel.zip = userInput.nextLine();

        System.out.println("Enter Phone Number ");
        contactModel.phoneNumber = userInput.nextLine();

        System.out.println("Enter E-mail ");
        contactModel.email = userInput.nextLine();
        contactList.add(contactModel);
    }

    public void DisplayContactList(int addressBookId) {
        contactList.forEach((contact) -> {
            System.out.println("Name :  " + contact.firstname + " " + contact.lastname);
            System.out.println("Address :  " + contact.address);
            System.out.println("City :  " + contact.city);
            System.out.println("State :  " + contact.state);
            System.out.println("ZIP :  " + contact.zip);
            System.out.println("Phone no :  " + contact.phoneNumber);
            System.out.println("Email  :  " + contact.email);
            System.out.println("-------------------------------------");
            System.out.println("");
        });
    }

    private int getContactIndex(String name) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).firstname.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void EditContact(String name) {
        int contactIndex = getContactIndex(name);
        if (contactIndex == -1) {
            System.out.println("Contact Not Exists!");
            return;
        }

        boolean isEdit = true;
        while (isEdit) {
            System.out.println("SELECT ");
            System.out.println(
                    "1. firstname \n" +
                            "2. lastname \n" +
                            "3. address \n" +
                            "4. city \n" +
                            "5. state \n" +
                            "6. zip \n" +
                            "7. phone-number \n" +
                            "8. email \n" +
                            "9. exit ");
            int choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter First Name: ");
                    String firstName = (new Scanner(System.in)).nextLine();
                    contactList.get(contactIndex).firstname = firstName;
                    break;
                case 2:
                    System.out.println("Enter Last Name: ");
                    String lastName = (new Scanner(System.in)).nextLine();
                    contactList.get(contactIndex).lastname = lastName;
                    break;
                case 3:
                    System.out.println("Enter Address: ");
                    String address = (new Scanner(System.in)).nextLine();
                    contactList.get(contactIndex).address = address;
                    break;
                case 4:
                    System.out.println("Enter City: ");
                    String city = (new Scanner(System.in)).nextLine();
                    contactList.get(contactIndex).city = city;
                    break;
                case 5:
                    System.out.println("Enter State: ");
                    String state = (new Scanner(System.in)).nextLine();
                    contactList.get(contactIndex).state = state;
                    break;
                case 6:
                    System.out.println("Enter Zip: ");
                    String zip = (new Scanner(System.in)).nextLine();
                    contactList.get(contactIndex).zip = zip;
                    break;
                case 7:
                    System.out.println("Enter PhoneNo: ");
                    String phoneNumber = (new Scanner(System.in)).nextLine();
                    contactList.get(contactIndex).phoneNumber = phoneNumber;
                    break;
                case 8:
                    System.out.println("Enter Email Id: ");
                    String email = (new Scanner(System.in)).nextLine();
                    contactList.get(contactIndex).email = email;
                    break;
                case 9:
                    isEdit = false;
                    break;
                default:
                    System.out.println("Invalid Option!, try Again");
                    break;
            }
        }
    }

    public void DeleteContact(String name) {
        int contactIndex = getContactIndex(name);
        contactList.remove(contactIndex);
    }
}
