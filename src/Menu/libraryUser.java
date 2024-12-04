package Menu;

import Exceptions.InvalidFileException;
import Interface.libraryItem;

import java.util.Scanner;

import static InputOutput.Storage.saveBooks;
import static Menu.output.printMenu;
import static Menu.output.printVar;
import static Menu.tryCatch.mainMenuChoice;
import static Menu.tryCatch.subMenuChoice;

public class libraryUser {
    public static boolean isReturningItem;
    public static int indexChoice;
    public static Scanner userInput = new Scanner(System.in);

    public static void libraryMenu(libraryItem[] items) throws InvalidFileException {
        while (true) {
            printVar(items); // Display all items
            int inputChoice;
            printMenu();
            inputChoice = mainMenuChoice();

            if (inputChoice == 1) { // Loan an item
                loanItem(items);
            } else if (inputChoice == 2) { // Return an item
                returnItem(items);
            } else if (inputChoice == 3) { // Exit
                //TODO problem where upon menu exit the books would be shown again (issue fixed- line 16 was originally below the index inputChoice at line 21/2)
                //TODO create a transaction from the user detailing books and timestamp
                System.out.println("Menu exit, your receipt will be available to you after this happens");
                break;
            }
        }
    }

    private static void loanItem(libraryItem[] books) throws InvalidFileException {
        while (true) {
            indexChoice = subMenuChoice(books);

            if (indexChoice < 0 || indexChoice >= books.length) {
                System.out.println("Exiting loaning process.");
                break;
            } else if (books[indexChoice].isLoaned()) {
                System.out.println("This item has already been loaned.");
            } else {
                books[indexChoice].loan();
                // Save changes to storage
                saveBooks((Books.Book[]) books, indexChoice, false);
                break;
            }
        }
    }

    private static void returnItem(libraryItem[] books) throws InvalidFileException {
        while (true) {
            indexChoice = subMenuChoice(books);

            if (indexChoice < 0 || indexChoice >= books.length) {
                System.out.println("Exiting return process.");
                break;
            } else if (!books[indexChoice].isLoaned()) {
                System.out.println("This item has not been loaned out.");
            } else {
                books[indexChoice].returnItem();
                // Save changes to storage
                saveBooks((Books.Book[]) books, indexChoice, true);
                break;
            }
        }
    }
}
