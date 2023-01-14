import java.util.Scanner;
import services.Contact;

class main {
    Contact contact = new Contact();

    public static void main(String args[]) {
        main objMain = new main();
        int n = 0;
        while (n < 10) {
            objMain.initiate();
            n++;
        }
    }

    private void initiate() {
        try {
            System.out.println("Press 1 for ADD CONTACT ");
            System.out.println("Press 2 for EDIT CONTACT ");
            System.out.println("Press 3 for DELETE CONTACT ");
            System.out.println("Press 4 for DISPALY CONTACT ");
            int input = new Scanner(System.in).nextInt();
            switch (input) {
                case 1:
                    contact.AddContact();
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
                    contact.DisplayContactList();
                    break;
                default:
                    System.out.println("INVALID");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}