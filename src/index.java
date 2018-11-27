import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.StandardOpenOption;
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
            System.out.println(contact);
        }
        System.out.println();

    }

    // ADD CONTACTS
    public static void addContact(Path p, List<String> newContact){
        System.out.println();
        try{
            Files.write(p, newContact, StandardOpenOption.APPEND);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

//    SEARCH
    public static List<String> searchContact(Path p, List<String> file, String search){
        System.out.println();
        List<String> results = new ArrayList<>();
        try {
            file = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String contact: file){
            if(contact.contains(search)){
                results.add(contact);
            }
        }
        return results;
    }

    // DELETE
    public static void deleteContact(Path p, String delContact){
        System.out.println();
        List<String> originalList = new ArrayList<>();
        List<String> newContactList = new ArrayList<>();
        try {
            originalList = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String contact: originalList){
            if (!contact.contains(delContact)){
              newContactList.add(contact);
            }
        }

        try {
            Files.write(p, newContactList);
        } catch (IOException e){
            e.printStackTrace();
        }
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


//    MAIN
    public static void main(String[] args){
//        Variables
        Path p = Paths.get("contacts.txt");
        List<String> file = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String options = "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):";


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
                    addContact(p, newContact);
                    break;
                case 3:
                    System.out.println("What contact are you looking for?");
                    String search = sc.nextLine();
                    List<String> results = searchContact(p, file, search);
                    System.out.println(results);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("What contact do you want to delete?");
                    String delete = sc.nextLine();
                    deleteContact(p, delete);
                    System.out.println("Contact delete!");
                    break;
                case 5:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid Input. Try Again");
            }
        } while (input != 5);


    }
}
