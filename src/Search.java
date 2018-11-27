import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Search {

    //    SEARCH
    public static void searchContact(Path p, List<String> file, String search){
        System.out.println();
        try {
            file = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String contact: file){
            if(contact.contains(search)){
                System.out.println(contact.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
            }
        }
    }
}
