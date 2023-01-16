package services;

import java.util.*;

import models.AddressBookModel;

public class AddressBook {
    public static int addressBookId = 0;
    public static ArrayList<AddressBookModel> addressBookList = new ArrayList<AddressBookModel>();

    public void CreateAddressBook() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter Address Book Name");
            String addressBookName = scanner.nextLine();

            int addressBookId = GetAddressBookId(addressBookName);

            if (addressBookId == -1) {
                System.out.println("Enter Address Book Description");
                String description = scanner.nextLine();

                AddressBookModel addressBook = new AddressBookModel();
                addressBookId++;
                addressBook.id = addressBookId;
                addressBook.name = addressBookName;
                addressBook.description = description;
                addressBookList.add(addressBook);

                System.out.println("Address Book Added!");
            }

            else {
                System.out.println("Address Already Exists with Name");
            }
        }
    }

    public int GetAddressBookId(String name) {
        for (int i = 0; i < addressBookList.size(); i++) {
            if (addressBookList.get(i).name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void GetAddressBookNames() {
        for (int i = 0; i < addressBookList.size(); i++) {
            System.out.println(addressBookList.get(i).name);
        }
    }
}