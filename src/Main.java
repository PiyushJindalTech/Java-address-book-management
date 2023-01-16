import java.util.Scanner;

import services.AddressBook;
import services.Contact;

class Main {
    Contact contact = new Contact();

    public static void main(String args[]) {
        Main objMain = new Main();
        while (true) {
            objMain.Initiate();
        }
    }

    private void Initiate() {
        System.out.println("Press 1 for Create AddressBook \n");
        System.out.println("Press 2 Select Address");

        AddressBook addressBook = new AddressBook();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addressBook.CreateAddressBook();
                    break;

                case 2:
                    addressBook.GetAddressBookNames();
                    System.out.println("Select Address Book Name");
                    String addressBookName = scanner.nextLine();
                    int addressBookId = addressBook.GetAddressBookId(addressBookName);
                    EditAddressBook(addressBookId);
                    break;

                default:
                    System.out.println("Invalid Option, try again!");
            }
        }
    }

    private void EditAddressBook(int addressBookId) {
        try {
            System.out.println("Press 1 for ADD CONTACT ");
            System.out.println("Press 2 for EDIT CONTACT ");
            System.out.println("Press 3 for DELETE CONTACT ");
            System.out.println("Press 4 for DISPALY CONTACT ");
            int input = new Scanner(System.in).nextInt();
            switch (input) {
                case 1:
                    contact.AddContact(addressBookId);
                    System.out.println("Contact Added! ");
                    break;
                case 2:
                    System.out.println("Enter Name for Edit Contact");
                    String contactNameForEdit = (new Scanner(System.in)).nextLine();
                    contact.EditContact(contactNameForEdit);
                    System.out.println("Contact Updated Successfully! ");
                    break;
                case 3:
                    System.out.println("Enter Name for Delete Contact");
                    String contactNameForDelete = (new Scanner(System.in)).nextLine();
                    contact.DeleteContact(contactNameForDelete);
                    break;
                case 4:
                    contact.DisplayContactList(addressBookId);
                    break;
                default:
                    System.out.println("INVALID");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}