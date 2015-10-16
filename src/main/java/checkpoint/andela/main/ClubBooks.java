package checkpoint.andela.main;

import checkpoint.andela.exceptions.NullBookException;
import checkpoint.andela.exceptions.NullMemberException;

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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean contains(Book bk) {
        return books.contains(bk);
    }

}
