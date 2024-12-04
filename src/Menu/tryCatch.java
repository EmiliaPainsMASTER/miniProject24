package Menu;

import Exceptions.InvalidInputException;
import Interface.libraryItem;

import static Menu.libraryUser.userInput;

public class tryCatch {
    public static int mainMenuChoice() {
        int inputChoice;
        while (true) {
            try {
                System.out.print("Please enter an index to use the program: ");
                if (!userInput.hasNextInt()) {
                    throw new InvalidInputException("Invalid input! Please enter an integer! (1-3)");
                }
                inputChoice = userInput.nextInt();
                break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                userInput.next();
            }
        }
        return inputChoice;
    }

    public static int subMenuChoice(libraryItem[] items) {
        int indexChoice;
        while (true) {
            try {
                System.out.print("Which item would you like to loan out? Alternatively, you can enter 0 to leave the submenu. (Use index 1 to " + items.length + "): ");
                if (!userInput.hasNextInt()) {
                    throw new InvalidInputException("Invalid input! Please enter an integer! (Use index 1 to " + items.length + ")");
                }
                indexChoice = userInput.nextInt();
                break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                userInput.next();
            }
        }
        return indexChoice - 1;
    }
}
