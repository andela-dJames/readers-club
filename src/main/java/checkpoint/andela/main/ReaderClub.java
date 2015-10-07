package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by Daniel James on 10/6/2015.
 */
public class ReaderClub implements Club{

    private ArrayList<Member> members;
    private ArrayList<Request> requests;
    private ArrayList<Staff> staffList;
    private ArrayList<Student> studentList;

    private int count;

    private DateTime regDate = DateTime.now();

    private ArrayList<Book> clubBooks;

    private Request request;

    private int memberPriority;

    public ReaderClub() {
        members = new ArrayList<Member>();
        clubBooks = new ArrayList<Book>();
        requests = new ArrayList<Request>();
    }


    @Override
    public void addMember(Member member) {

            members.add(member);
            member.setDateOfRegistration(regDate);

    }

    @Override
    public void addBook(Book book, int numberOfCopies)  throws NullBookException {
        numberOfCopies = numberOfCopies + book.getNoOfCopies();
        book.setNoOfCopies(numberOfCopies);
        if (!(book.getiSBN() == null) && book.getNoOfCopies() >1){
        clubBooks.add(book);
        }
        else {
            clubBooks.add(book);
            throw new NullBookException(numberOfCopies);
        }
    }

    @Override
    public void borrowBook(Book book) throws NullMemberException, NullBookException {
        if (clubBooks.contains(book)){
            book.setinRequest(true);
            count++;
            book.setNumOfRequests(book.getNumOfRequests()+ 1);
        }
    }

    @Override
    public void lendBook(Book book, String num) {
        if (book.getNoOfCopies() > 1){
            request = new Request(num, book);
            requests.add(request);
        }
    }

    @Override
    public int getTotalRequst() {
        int total = requests.size();
        return total;
    }


}
