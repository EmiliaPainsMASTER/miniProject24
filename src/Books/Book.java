package Books;

import Interface.libraryItem;

public class Book extends libraryInv implements libraryItem {
    private final String author;
    private bookLoaned loaned;

    public Book(String bookName, String author, int dateReleased, String isbn, bookLoaned loaned) {
        super(isbn, dateReleased, bookName);
        this.author = author;
        this.loaned = loaned;
    }

    public void loan() {
        if (loaned == bookLoaned.Available) {
            loaned = bookLoaned.Loaned;
        } else {
            System.out.println("Book is already loaned.");
        }
    }

    public void returnItem() {
        if (loaned == bookLoaned.Loaned) {
            loaned = bookLoaned.Available;
        } else {
            System.out.println("Book is already available.");
        }
    }

    public boolean isLoaned() {
        return loaned == bookLoaned.Loaned;
    }

    public void setLoaned(bookLoaned loaned) {
        this.loaned = loaned;
    }

    public String toDisplayString() {
        // Ensuring fixed-width formatting for the fields
        return String.format("%-80s %-40s %-10d %-20s %-10s",
                getBookName(),          // Book Name (60 characters wide)
                author,                 // Author (40 characters wide)
                getDateReleased(),      // Date Released (10 characters wide)
                getIsbn(),              // ISBN (20 characters wide)
                loaned.toString());     // Loaned status (10 characters wide)
    }

    //similar to above but reverts the output to what was originally in the text file (toString seems to override the PrintWriter with the toString output)
    public String toFileString() {
        return getBookName() + ", " + author + ", " + getDateReleased() + ", " + getIsbn() + ", " + loaned;
    }
}
