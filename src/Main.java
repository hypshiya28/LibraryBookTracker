public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(int bookId, String title, String author, boolean issued) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = issued;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return bookId + "," + title + "," + author + "," + issued;
    }
}
