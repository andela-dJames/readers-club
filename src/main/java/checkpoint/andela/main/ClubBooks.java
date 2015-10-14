package checkpoint.andela.main;

import java.util.ArrayList;

/**
 * Created by Daniel James on 10/14/2015.
 */
public class ClubBooks {

    private Book book;

    private ArrayList<Book> books;

    public ClubBooks() {
        books = new ArrayList<Book>();
    }

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

    public void borrowBook(Book book){
        this.book = book;


    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
