package checkpoint.andela.main;

import java.util.ArrayList;

/**
 * Class for manipulating club Books
 */
public class ClubBooks {
    /**
     * A book
     */
    private Book book;
    /**
     * An array list of books
     */
    private ArrayList<Book> books;
    /**
     * A record of a book
     */
    private BookRecords bookRecord;

    /**
     * Creates a new ClubBooks Object
     */
    public ClubBooks() {
        books = new ArrayList<Book>();
    }

    /**
     * adds a book with the given parameters
     * @param book <code>Book</code> to be added
     * @param copies the number of copies
     */
    public void addBook(Book book, int copies) {
        if (books.contains(book)){
            int n = book.getNoOfCopies();
            book.setNoOfCopies(n + copies);
        }
        else {
            books.add(book);
            book.setNoOfCopies(copies);
        }
    }

    /**
     * Initiates a boorow book Request by a member
     * @param member a requester
     * @param book a book to be borrowed
     * @throws NullBookException
     */
    public void borrowBook(Member member, Book book) throws NullBookException, NullMemberException {
        if (!books.contains(book)){
            throw new NullBookException();
        }
        else {
            bookRecord = new BookRecords(book);
            bookRecord.setRequster(member);
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public BookRecords getBookRecord() {
        return bookRecord;
    }

    /**
     *
     */

    public class BookRecords{
        private Member requster;

        private boolean inRequest;

        public BookRecords(Book bk) {
            book = bk;
        }

        public Member getRequster() {
            return requster;
        }

        public void setRequster(Member requster) {
            this.requster = requster;
        }
    }

    public class Requsters{
        private int numOfRequest;

        public int getNumOfRequest() {
            return this.numOfRequest;
        }

        public void setNumOfRequest(int numOfRequest) {
            this.numOfRequest = numOfRequest;
        }
    }

}
