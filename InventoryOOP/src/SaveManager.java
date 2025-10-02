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
            System.err.println("Warning: The file was not found at path: " + FILE_PATH + ". Returning empty list.");
            return items;
        }

        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String row = scanner.nextLine();
                if (row.trim().isEmpty()) continue;

                String[] parts = row.split(CSV_DELIMITER);
                if (parts.length == 0) continue;

                String itemType = parts[0].trim();;

                Object newItem = null;
                try {
                    if ("Food".equals(itemType)) {
                        newItem = Food.fromCsvParts(row, CSV_DELIMITER);
                    }
                    else if ("Item".equals(itemType)) {
                        newItem = Item.fromCsvParts(row, CSV_DELIMITER);
                    }
                } catch (Exception parseException) {
                    System.err.println("Data Error: Could not parse item on line " + lineNumber +
                            " (Row: '" + row + "'). The row will be skipped.");
                    parseException.printStackTrace();
                    continue;
                }

                if (newItem != null) {
                    items.add(newItem);
                } else {
                    System.err.println("Data Error: Unknown or unhandled item type '" + itemType +
                            "' on line " + lineNumber + ".");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Error: Attempted to open file at " + FILE_PATH + ", but it was not found.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("I/O Error: An unexpected error occurred while reading the file.");
            e.printStackTrace();
        }

        return items;
    }

    public static void saveItem(Object... items) {
        File file = new File(FILE_PATH);

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, false))) { // false for overwrite
            int itemsSaved = 0;
            for (Object obj : items) {
                if (obj instanceof Item item) {
                    writer.println(item.toCsvRow(CSV_DELIMITER));
                    itemsSaved++;
                } else if (obj instanceof Food food) {
                    writer.println(food.toCsvRow(CSV_DELIMITER));
                    itemsSaved++;
                } else {
                    System.err.println("Save Error: Skipped object of unknown type: " + (obj != null ? obj.getClass().getName() : "null"));
                }
            }
            if (writer.checkError()) {
                System.err.println("I/O Error: An error occurred while writing data to the file, possibly due to low space or permissions.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Error: Could not create/open the file for writing at " + FILE_PATH + ". Check directory permissions.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O Error: An unexpected error occurred while saving the item to CSV at " + FILE_PATH);
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        Path filePath = Paths.get(FILE_PATH);
        try {
            boolean deleted = Files.deleteIfExists(filePath);
            if (!deleted) {
                System.err.println("Warning: Attempted to delete file at " + filePath + ", but it did not exist.");
            }
        }
        catch (IOException e){
            System.err.println("I/O Error: Failed to delete the file at " + filePath + ". Check file permissions or if another process is using it.");
            e.printStackTrace();
        }
    }
}