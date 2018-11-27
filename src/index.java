import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class index {

//    SHOW CONTACTS
    public static void showContacts(Path p, List<String> file){
        System.out.println("Name \t| Phone Number\n--------------------------");
        try {
            file = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String contact: file){
            String num = contact.substring(contact.indexOf("|") + 1);
            if (num.length() < 10){
                System.out.println(contact.replaceFirst("(\\d{3})(\\d+)", "$1-$2"));
            } else {
                System.out.println(contact.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
            }

        }
        System.out.println();

    }
//    CASE 2 METHOD
    public static String returnNewContact (Scanner sc){
        System.out.println("Insert Name: ");
        String name = sc.nextLine();
        System.out.println("Insert Phone Number: ");
        String number = sc.nextLine();
        String newPerson = name + " \t| " + number;
        return newPerson;
    }


//    MAIN======================================================================================
    public static void main(String[] args){
//        Variables
        Path p = Paths.get("contacts.txt");
        List<String> file = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Search search = new Search();
        AddAndRemove edit = new AddAndRemove();

        String options = "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):";

        //Doing stuff
        int input = 0;
        do{
            //Prompts
            System.out.println("Welcome to your contact manager!");
            System.out.println(options);

            //getting input....
            input = Integer.parseInt(sc.nextLine());

            switch (input){
                case 1:
                    showContacts(p,file);
                    break;
                case 2:
                    String newPerson = returnNewContact(sc);
                    List<String> newContact = Arrays.asList(newPerson);
                    edit.addContact(p, newContact);
                    break;
                case 3:
                    System.out.println("What contact are you looking for?");
                    String searchCode = sc.nextLine();
                    search.searchContact(p, file, searchCode);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("What contact do you want to delete?");
                    String delete = sc.nextLine();
                    edit.deleteContact(p, delete);
                    System.out.println("Contact deleted!");
                    break;
                case 5:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid Input. Try Again");
            }
        } while (input != 5);
    }
} //END OF MAIN======================================================================================
