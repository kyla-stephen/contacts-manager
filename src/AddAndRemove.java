import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class AddAndRemove {
    // ADD CONTACTS
    public static void addContact(Path p, List<String> newContact){
        System.out.println();
        try{
            Files.write(p, newContact, StandardOpenOption.APPEND);

        } catch (IOException e){
            e.printStackTrace();
        }
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


}
