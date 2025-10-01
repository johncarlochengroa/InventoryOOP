import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SaveManager {
    public static String[] loadFile() {
        String[] itemProperties = new String[7];
        File file = new File("save.txt");

        try (Scanner myReader = new Scanner(file)) {
            int i = 0;
            while (myReader.hasNextLine() && i < itemProperties.length) {
                itemProperties[i] = myReader.nextLine();
                i++;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            return null;
        }
        return itemProperties;
    }

    public static void saveFile(String[] itemProperties) {
        File file = new File("save.txt");

        try (FileWriter writer = new FileWriter(file)) {
            for (String line : itemProperties) {
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error: An error occurred while saving the item.");
        }
    }

    public static void deleteFile() {
        File file = new File("save.txt");
        Path filePath = Paths.get("save.txt");
        try {
            Files.deleteIfExists(filePath);
            System.out.println("Item deleted successfully.");
        } catch (IOException e) {
            System.err.println("Error: An error occurred while deleting the item.");
        }
    }
}
