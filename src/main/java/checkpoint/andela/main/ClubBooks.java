package checkpoint.andela.main;

import exceptions.NullBookException;
import exceptions.NullMemberException;

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

    private ArrayList<BookRecords> records;

    /**
     * Creates a new ClubBooks Object
     */
    public ClubBooks() {
        books = new ArrayList<Book>();
        records = new ArrayList<BookRecords>();
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
            bookRecord.setRequester(member);
            records.add(bookRecord);
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    private BookRecords getBookRecord() {
        return bookRecord;
    }
    public Member getRequester() {
        return getBookRecord().getRequester();
    }

//    public int getNumberOfRequesters(Book book) {
//
//    }

    /**
     * Creates a record of books in clubBooks
     */

    private class BookRecords{
        private Book book;
        private Member requester;

        private int numberOfRequests;

        public BookRecords(Book bk) {
            book = bk;
        }

        public Member getRequester() {
            return requester;
        }

        public void setRequester(Member requester) {
            this.requester = requester;
        }

        public int getNumberOfRequests() {
            return numberOfRequests;
        }

        public void setNumberOfRequests(int numberOfRequests) {
            this.numberOfRequests = numberOfRequests;
        }

        public Book getBook() {
            return book;
        }
    }
}
