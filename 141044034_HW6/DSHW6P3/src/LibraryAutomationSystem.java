import java.util.Map;
import java.util.Scanner;

/**
 * Library Automation System, it has methods for UI and data of the library .
 */
public class LibraryAutomationSystem {
    private String adminPassword;
    private Library library;
    private Scanner inputReader;
    private boolean exit;

    /**
     * Gets the password for admins.
     * @param adminPassword
     */
    public LibraryAutomationSystem(String adminPassword) {
        this.adminPassword = adminPassword;
        this.inputReader = new Scanner(System.in);
        this.library = new Library();
        exit = false;
    }


    /**
     * Main menu of the Automation system.
     */
    public void startSystem() {
        int inOption = 0;
        while (true) {
            System.out.println("Library Automation System\nChose User Type");
            System.out.println("1-Administrator to update information\n2-General User for Book Search\n3-Exit");
            try {
                inOption = Integer.parseInt(inputReader.next());
            } catch (NumberFormatException e) {
                inOption=0;
            }
            switch (inOption) {
                case 1:
                    adminPanel();
                    break;
                case 2:
                    SearchPanel();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown operation.");

            }

            if (exit == true)
                break;
        }
    }

    /**
     * General User panel to search books.
     */
    private void SearchPanel() {

        while (true) {
            System.out.println("1-Search by Book Title\n2-Search by Book Author\n3-Exit");
            boolean exitSearch = false;
            int userOption = 0;

            try {
                userOption = Integer.parseInt(inputReader.next());
            } catch (NumberFormatException e) {
                userOption=0;
            }

            switch (userOption) {
                case 1:
                    library.searchByTitle();
                    System.out.println("Book searched by title");
                    break;
                case 2:
                    library.searchByAuthor();
                    System.out.println("Book searched by author");
                    break;
                case 3:
                    exitSearch = true;
                    break;
                default:
                    System.out.println("Unknown operation.");
            }

            if (exitSearch == true)
                break;
        }

    }

    /**
     * Administrator panel to edit library data.
     */
    private void adminPanel() {

        String passCheck;
        System.out.println("Enter Password:");
        passCheck = inputReader.next();

        if (0 == adminPassword.compareTo(passCheck)) {
            while (true) {
                System.out.println("1-Add Book\n2-Delete Book\n3-Update Information\n4-Exit");
                boolean exitAdmin = false;
                int adminOption = 0;
                try {
                    adminOption = Integer.parseInt(inputReader.next());
                } catch (NumberFormatException e) {
                    adminOption=0;
                }

                switch (adminOption) {
                    case 1:

                        library.addBook();
                        System.out.println("Book added.");
                        break;
                    case 2:
                        library.removeBook();
                        System.out.println("Book removed.");
                        break;
                    case 3:
                        library.updateBook();
                        System.out.println("Book updated.");
                        break;
                    case 4:
                        exitAdmin = true;
                        break;
                    default:
                        System.out.println("Unknown operation.");
                }

                if (exitAdmin == true)
                    break;

            }
        } else
            System.out.println("Wrong Password");
    }


}
