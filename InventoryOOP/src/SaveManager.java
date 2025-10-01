import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class SaveManager {
    private static final String FILE_PATH = "C:\\Users\\John Carlo\\IdeaProjects\\InventoryOOP\\InventoryItems\\save.txt";

    public static boolean fileExists() {
        File file = new File(FILE_PATH);
        return file.exists();
    }

    public static List<Object> loadFile() {
        List<Object> items = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return items;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return Collections.singletonList(ois.readObject());
        } catch (EOFException e) {
            return null;
        } catch (FileNotFoundException e) {
            System.err.println("Error: Save file not found at " + FILE_PATH);
            return null;
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred while loading object.");
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Error: A stored class could not be found during deserialization.");
            return null;
        }
    }

    public static void saveItem(Object... items) {
        File file = new File(FILE_PATH);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Object obj : items) {
                oos.writeObject(obj);
            }
        } catch (IOException e) {
            System.err.println("Error: An error occurred while saving the item.");
        }
    }

    public static void deleteFile() {
        Path filePath = Paths.get(FILE_PATH);
        try {
            Files.deleteIfExists(filePath);
        }
        catch (IOException e){
            System.err.println("Error: An error occurred while deleting the item.");
        }
    }
}
