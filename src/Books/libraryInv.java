package Books;

public abstract class libraryInv {//start of superClass libraryInv
    private String isbn;
    private int dateReleased;
    private String bookName;

    public libraryInv(String isbn, int dateReleased, String bookName) {//constructor
        this.isbn = isbn;
        this.dateReleased = dateReleased;
        this.bookName = bookName;
    }

    //getter setter
    protected String getIsbn() {
        return isbn;
    }

    protected void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    protected int getDateReleased() {
        return dateReleased;
    }

    protected void setDateReleased(int dateReleased) {
        this.dateReleased = dateReleased;
    }

    protected String getBookName() {
        return bookName;
    }

    protected void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
