import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class SaveManager {
    private static final String FILE_PATH = "C:\\Users\\John Carlo\\IdeaProjects\\InventoryOOP\\InventoryItems\\items.csv";
    private static final String CSV_DELIMITER = ",";

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

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (row.trim().isEmpty()) continue;

                String[] parts = row.split(CSV_DELIMITER);
                if (parts.length == 0) continue;

                String itemType = parts[0];

                Object newItem = null;

                if ("Food".equals(itemType)) {
                    newItem = Food.fromCsvParts(Arrays.toString(parts), CSV_DELIMITER);
                }
                else if ("Item".equals(itemType)) {
                    newItem = Item.fromCsvParts(Arrays.toString(parts), CSV_DELIMITER);
                }

                if (newItem != null) {
                    items.add(newItem);
                }
            }
        } catch (Exception e) {
            System.err.println("Error: An error occurred while loading the item from CSV");
        }

        return items;
    }

    public static void saveItem(Object... items) {
        File file = new File(FILE_PATH);

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, false))) { // false for overwrite
            for (Object obj : items) {
                if (obj instanceof Item item) {
                    writer.println(item.toCsvRow(CSV_DELIMITER));
                } else if (obj instanceof Food food) {
                    writer.println(food.toCsvRow(CSV_DELIMITER));
                }
            }
        } catch (IOException e) {
            System.err.println("Error: An error occurred while saving the item to CSV");
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
