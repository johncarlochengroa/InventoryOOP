import java.io.*;
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
        } catch (FileNotFoundException e) {
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
            System.out.println("Error: An error occurred while writing to the file.");
        }
    }
}
