/**
 * Like Truck but with more book
 *
 * @author Braden Gerlach
 * @version 2024.17.4
 */
public class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(String bookTitle, String bookAuthor, int bookYearPublished) {
        title = bookTitle;
        author = bookAuthor;
        yearPublished = bookYearPublished;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
}
