package InputOutput;

import Books.Book;
import Books.bookLoaned;
import Exceptions.InvalidFileException;

import java.io.*;

public class Storage {
    public static String filename = "src/InputOutput/books.txt";

    public static Book[] loadBooks() throws InvalidFileException {
        Book[] booksArray;
        try {
            // Variable declarations
            FileReader fileReader = new FileReader(filename); // Open file
            BufferedReader bookReader = new BufferedReader(fileReader);
            int lines = 0;

            // Counting lines in the file
            while (bookReader.readLine() != null) {
                lines++;
            }

            // Initialize the array with the correct size
            booksArray = new Book[lines];

            // Resetting file readers
            bookReader.close();
            fileReader = new FileReader(filename); // Reopen file for reading
            bookReader = new BufferedReader(fileReader);

            // Reading lines and populating books array
            for (int count = 0; count < lines; count++) {
                String line = bookReader.readLine();
                String[] parts = line.split(", ");
                String bookName = parts[0];
                String author = parts[1];
                int dateReleased = Integer.parseInt(parts[2].trim());
                String isbn = parts[3];
                bookLoaned loaned = bookLoaned.valueOf(parts[4].trim());

                booksArray[count] = new Book(bookName, author, dateReleased, isbn, loaned);
            }

            // Closing file readers
            bookReader.close();
        } catch (IOException e) {
            throw new InvalidFileException("Error reading the book file: " + filename, e);
        }
        return booksArray;
    }

    public static void saveBooks(Book[] bookArray, int userIndex, boolean isReturningBook) throws InvalidFileException {
        // Check if the index is within bounds
        if (isReturningBook) {
            bookArray[userIndex].setLoaned(bookLoaned.Available);
        } else {
            bookArray[userIndex].setLoaned(bookLoaned.Loaned);
        }

        try {
            FileWriter bookFWriter = new FileWriter(filename);
            PrintWriter bookPWriter = new PrintWriter(bookFWriter);

            for (Book book : bookArray) {
                bookPWriter.println(book.toFileString());
            }

            // Closing the writer
            bookPWriter.close();
        } catch (IOException e) {
            throw new InvalidFileException("Error reading the book file: " + filename, e);
        }
    }
}
