import java.io.*;
import java.util.*;

public class Library {
    private static final String FILE_PATH = "database/books.txt";

    public static void addBook(Book book) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);
            writer.write(book.toString() + "\n");
            writer.close();
            System.out.println("Book added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding book.");
        }
    }

    public static void viewBooks() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;

            System.out.println("\nID | Title | Author | Issued");
            System.out.println("----------------------------------");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(data[0] + " | " + data[1] + " | " + data[2] + " | " + data[3]);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading books.");
        }
    }

    public static void issueBook(int id) {
        updateStatus(id, true);
    }

    public static void returnBook(int id) {
        updateStatus(id, false);
    }

    private static void updateStatus(int id, boolean status) {
        List<String> books = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == id) {
                    data[3] = String.valueOf(status);
                }
                books.add(String.join(",", data));
            }
            reader.close();

            FileWriter writer = new FileWriter(FILE_PATH);
            for (String book : books) {
                writer.write(book + "\n");
            }
            writer.close();

            System.out.println("Book status updated.");
        } catch (IOException e) {
            System.out.println("Error updating book.");
        }
    }
}
