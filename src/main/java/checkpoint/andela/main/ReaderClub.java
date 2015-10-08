package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A Concrete Mediator class that provides functionality to for clients.
 * @author Daniel James
 * @version 0.0.2
 */
public class ReaderClub implements Club{

    private ArrayList<Member> members;
    private ArrayList<Request> requests;
    private ArrayList<Staff> staffList;
    private ArrayList<Student> studentList;
    private ArrayList<Book> clubBooks;
    private Queue requestQueue;


    private int count =1;
    private DateTime regDate = DateTime.now();
    private Request request;

   //private int memberPriority;

    public static Comparator<Member> memberPriority = new Comparator<Member>() {
        @Override
        public int compare(Member member, Member member1) {
            if (member.isStaff() && member1.isStaff()) {
                return (member.getId() - member1.getId());
            }
            if (member.isStaff() && member1.isStudent()) {
                return -1;
            }
            if (member.isStudent() && member1.isStaff()) {
                return 1;
            } else
                return (member.getId() - member1.getId());
        }
    };

    public ReaderClub() {

        members = new ArrayList<Member>();
        clubBooks = new ArrayList<Book>();
        requests = new ArrayList<Request>();
        staffList = new ArrayList<Staff>();
        studentList = new ArrayList<Student>();

        requestQueue = new PriorityQueue<>(10, memberPriority);

    }


    @Override
    public void addMember(Member member) {

            members.add(member);
            member.setDateOfRegistration(regDate);
            member.setId(count);
            count++;

    }

    public void addToList(Member member) {

        if (members.contains(member)){

            if (member.isStaff()){

                staffList.add((Staff) member);

            }
            else {
                studentList.add((Student) member);
            }
        }

    }

    @Override
    public void addBook(Book book, int numberOfCopies)  throws NullBookException {

        numberOfCopies = numberOfCopies + book.getNoOfCopies();
        book.setNoOfCopies(numberOfCopies);

        if (!(book.getiSBN() == null) && book.getNoOfCopies() >1) {
        clubBooks.add(book);
        }
        else {
            clubBooks.add(book);
            throw new NullBookException(numberOfCopies);
        }
    }

    @Override
    public void borrowBook(Book book) throws NullMemberException, NullBookException {

        if (clubBooks.contains(book)) {
            book.setinRequest(true);
            count++;
            book.setNumOfRequests(book.getNumOfRequests() + 1);
        }
    }

    @Override
    public void lendBook(Book book, String num) {

        if (book.getNoOfCopies() > 1) {
            request = new Request(num, book);
            requests.add(request);
        }
    }

    @Override
    public int getTotalRequst() {

        int total = requests.size();
        return total;

    }

    @Override
    public void addToQ(Member member) {

        requestQueue.offer(member);

    }

    public int getMemberPriority(Member member) {
        if (member.isStaff()){
            return 1;
        }
        else return 0;

    }

    public Queue getRequestQueue() {
        return requestQueue;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public ArrayList<Member> getMembers() {

        return members;
    }

    public ArrayList<Staff> getStaffList() {

        return staffList;
    }

    public ArrayList<Student> getStudentList() {

        return studentList;
    }
}
