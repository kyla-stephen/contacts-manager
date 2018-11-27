import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Search {

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
}
