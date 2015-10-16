package checkpoint.andela.main;

import com.sun.prism.impl.Disposer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Daniel James on 10/16/2015.
 */
public class Request extends MembersQueue {

    private BookRecords record;

    private ArrayList<BookRecords> records;

    private ClubBooks clubBooks;

    private ArrayList<Book> books;

    public Request() {

        super();

        books= new ArrayList<Book>();

        records = new ArrayList<BookRecords>();
    }
   public boolean bookAvailable(Book book) {
       return books.contains(book);
   }
   public ArrayList<Book> getBooks() {
       return books;
   }

   public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

   public BookRecords makeRequest(Member member, Book book) {

       record = new BookRecords(book);

       record.setRequester(member);

       record.setNumberOfRequests(record.getNumberOfRequests()+1);

       book.setNumOfRequests(book.getNumOfRequests() +1);

       return record;
   }
    public boolean shouldBeResolved(Book book) {

        return book.getNumOfRequests() > book.getNoOfCopies();
    }

   public void borrowBook(Member member, Book book) {

    if (shouldBeResolved(book)){

        addToQueue(member);
    }
       else {
        record = new BookRecords(book, member);
        record.setRequester(member);
        records.add(record);
    }
   }
   public Member resolveRequests() {
       Member member = new Member();
       if (getMembers().isEmpty()){
           return null;
       }
       else {
           return member;

       }
   }

    /**
     * Creates a record of books in clubBooks
     */
    public class BookRecords{
        /**
         * A book
         */
        public Book book;
        /**
         * A member who requsts for book
         */
        private Member requester;
        /**
         * the number of requests
         */
        private int numberOfRequests;

        public BookRecords(Book bk) {
            book = bk;
        }

        public BookRecords(Book bk , Member member) {
            this(bk);
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
