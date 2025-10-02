import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        boolean alreadyPopulated = SaveManager.fileExists();

        // Change 'Object item = null;' to 'List<Object> items = new ArrayList<>();'
        List<Object> items = new ArrayList<>();

        if (alreadyPopulated) { // 'items' is already initialized, no need to check for null
            // Assign the result of loadFile() directly to 'items'
            items = SaveManager.loadFile();
        }

        // Now, you can directly iterate over 'items'
        for (Object item : items) {
            System.out.println(item);
        }
    }
}