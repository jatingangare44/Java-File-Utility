package task_1;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtility { 

    // Method to write content to a file with append option
    public static void writeFile(String filePath, String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(content);
            writer.newLine();
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file with line numbers
    public static void readFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("⚠️ File does not exist.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNum = 1;
            System.out.println("📄 File Contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNum++ + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Method to modify a file (replaces target word with replacement)
    public static void modifyFile(String filePath, String target, String replacement) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("⚠️ File does not exist.");
            return;
        }

        // Create backup before modifying
        try {
            Files.copy(Paths.get(filePath), Paths.get(filePath + ".bak"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("🗂️ Backup created: " + filePath + ".bak");
        } catch (IOException e) {
            System.out.println("❌ Error creating backup: " + e.getMessage());
        }

        StringBuilder modifiedContent = new StringBuilder();

        // Step 1: Read the file content
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                modifiedContent.append(line.replaceAll(target, replacement)).append("\n");
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file for modification: " + e.getMessage());
            return;
        }

        // Step 2: Write modified content back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(modifiedContent.toString());
            System.out.println("✏️ File modified successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing modified content: " + e.getMessage());
        }
    }

    // Main method to demonstrate all operations
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n--- Java File Handling Utility ---");

            // Step 1: Get filename from user
            System.out.print("Enter filename (with extension, e.g., myfile.txt): ");
            String filePath = scanner.nextLine();

            // Step 2: Provide user with a loop of options
            while (true) {
                System.out.println("\n🔹-------------------------🔹");
                System.out.println("Choose an option:");
                System.out.println("1. Write content");
                System.out.println("2. Modify content");
                System.out.println("3. Read content");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1/2/3/4): ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("Enter the content you want to write in the file:");
                        String content = scanner.nextLine();
                        System.out.print("Do you want to append the content? (yes/no): ");
                        boolean append = scanner.nextLine().equalsIgnoreCase("yes");

                        System.out.println("\n[1] Writing to file...");
                        writeFile(filePath, content, append);

                        System.out.println("\n[2] Reading from file...");
                        readFile(filePath);
                        break;

                    case "2":
                        System.out.println("\n[3] Modifying file content...");
                        System.out.print("Enter word to replace: ");
                        String target = scanner.nextLine();
                        System.out.print("Enter replacement word: ");
                        String replacement = scanner.nextLine();
                        modifyFile(filePath, target, replacement);
                        break;

                    case "3":
                        System.out.println("\n📄 Reading file...");
                        readFile(filePath);
                        break;

                    case "4":
                        System.out.println("👋 Exiting program. Goodbye!");
                        return;

                    default:
                        System.out.println("❌ Invalid choice. Please try again.");
                }
            }
        }
    }
}
