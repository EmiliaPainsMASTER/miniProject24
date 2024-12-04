import Books.Book;
import Exceptions.InvalidFileException;

import static InputOutput.Storage.loadBooks;
import static Menu.libraryUser.libraryMenu;

public class Main {
    public static void main(String[] args) throws InvalidFileException {
        Book[] books = loadBooks();
        libraryMenu(books);
    }
}