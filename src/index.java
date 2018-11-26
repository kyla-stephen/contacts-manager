import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.StandardOpenOption;

public class index {

//    SHOW CONTACTS
    public static void showContacts(Path p, List<String> file){
        try {
            file = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String contact: file){
            System.out.println(contact);
        }

    }

    // ADD CONTACTS
    public static void addContact(Path p, List<String> newContact){
        try{
            Files.write(p, newContact, StandardOpenOption.APPEND);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

//    SEARCH
    public static List<String> searchContact(Path p, List<String> file, String search){
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

//    SHOW FILTERED CONTACTS
    public static void showFilteredContacts(List<String> file){
        for (String contact: file){
            System.out.println(contact);
        }

    }


//    MAIN
    public static void main(String[] args){
//        Variables
        Path p = Paths.get("contacts.txt");
        List<String> file = new ArrayList<>();

//        showContacts(p, file);

//        List<String> newContact = Arrays.asList("John Smith 2105555555");
//        addContact(p, newContact);
//        showContacts(p, file);


//        showContacts(p, file);
//        List<String> search = searchContact(p, file, "John Smith");
//        showFilteredContacts(search);
        deleteContact(p, "John Smith");
        showContacts(p, file);



    }
}
