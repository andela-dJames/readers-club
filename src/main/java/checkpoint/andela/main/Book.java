package checkpoint.andela.main;

/**
 * A Book class
 * @author  Daniel James
 * @version 0.0.1 10/1/2015.
 */
public class Book {
    /**
     * the name a book
     */
    private String bookName;
    /**
     * The author of a book.
     */
    private String author;
    /**
     * The number of copies of books.
     */
    private int noOfCopies;
    /**
     * The international standard number of a book.
     */
    private String iSBN;

    public Book() {
    }

    /**
     * Creates a new book with the following
     * @param isbnNumber the international standard number of a book.
     */
    public Book(String isbnNumber) {
        iSBN = isbnNumber;
    }

    /**
     * Creates a new book with the following parameters
     * @param isbnNumber the international standard number of a book.
     * @param name the name of the <code>Book</code>
     */
    public Book(String isbnNumber, String name){
        this(isbnNumber);
        bookName = name;
    }

    /**
     * cretes a new <code>Book</code> with following parameters
     * @param isbnNumber the international standard number of a book.
     * @param name the name of the <code>Book</code>
     * @param author the author of the <code>Book</code>
     */
    public Book(String isbnNumber, String name, String author){
        this(isbnNumber, name);
        this.author = author;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }


}
