import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Book Tracker =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author Name: ");
                    String author = sc.nextLine();

                    Library.addBook(new Book(id, title, author, false));
                    break;

                case 2:
                    Library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    Library.issueBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    Library.returnBook(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
