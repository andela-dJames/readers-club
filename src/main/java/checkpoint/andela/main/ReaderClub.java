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

    private Member member;

    private static boolean hasRequst;

    private ArrayList<Member> members;

    private ArrayList<Request> requests;

    private ArrayList<Staff> staffList;

    private ArrayList<Student> studentList;

    private ArrayList<Book> clubBooks;

    private ArrayList<Record> records;

    private Queue<Member> requestQueue;


    private int count =1;

    private DateTime regDate = DateTime.now();

    private Request request;

    /**
     * Implements <code>Comparator</code> to assign priority for members in the Queue
     */
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

    /**
     * Create a new reader club with all the necessary lists
     */
    public ReaderClub() {

        members = new ArrayList<Member>();

        clubBooks = new ArrayList<Book>();

        requests = new ArrayList<Request>();

        staffList = new ArrayList<Staff>();

        studentList = new ArrayList<Student>();

        records = new ArrayList<Record>();

        requestQueue = new PriorityQueue<Member>(10, memberPriority);

    }

    /**
     * Adds a new member and sets the date of registration
     * sets the Id of the new member
     * @param member
     */
    @Override
    public void addMember(Member member) {

            members.add(member);
            member.setDateOfRegistration(regDate);
            member.setId(count);
            count++;

    }

    /**
     * Adds member to corresponding club list, Staff/student
     * @param member
     */
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

    /**
     * Adds a new Book to the club with given parameters.
     * @param book
     * @param numberOfCopies
     * @throws NullBookException
     */
    @Override
    public void addBook(Book book, int numberOfCopies)  throws NullBookException {

        numberOfCopies = numberOfCopies + book.getNoOfCopies();
        book.setNoOfCopies(numberOfCopies);

        if (!(book.getiSBN() == null) && book.getNoOfCopies() >1) {
        clubBooks.add(book);
        }
        else {
            clubBooks.add(book);

        }
    }

    /**
     * Initiate a request for a book
     * @param book
     * @throws NullMemberException
     * @throws NullBookException
     */
    @Override
    public void borrowBook(Book book) throws NullMemberException, NullBookException {

        if (clubBooks.contains(book)) {

            book.setinRequest(true);

            count++;

            book.setNumOfRequests(book.getNumOfRequests() + 1);
        }
    }

    /**
     * lends a book from club books to Member and creates a new Record
     * @param book
     */
    @Override
    public void lendBook(Book book) {

        Member member = requestQueue.poll();

        int id = member.getId();

        Record record= new Record(book, id);

        records.add(record);

        int num = book.getNoOfCopies();

        book.setNoOfCopies(num - 1);

    }

    /**
     * gets the total number of request
     * @return
     */
    @Override
    public int getTotalRequst() {

        int total = requests.size();

        return total;

    }

    /**
     * Add member to Queue
     * @param member
     */
    @Override
    public void addToQ(Member member) {

        requestQueue.offer(member);

    }

    /**
     * Member returns Book and the record is removed
     * @param book
     * @param id the Id of the member
     */
    @Override
    public void returnBook(Book book, int id) {

        records.removeIf(record -> record.memberID == id );

        int num = book.getNumOfRequests();

        book.setNoOfCopies(num+1);

    }

    /**
     * Adds Member to Queue if the book has been requested
     * @param book
     * @param member
     * @throws NullMemberException
     * @throws NullBookException
     */
    public void resolve(Book book, Member member) throws NullMemberException, NullBookException {

       if (book.isInRequest() && book.getNumOfRequests() > book.getNoOfCopies()){

           addToQ(member);
       }

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

    public ArrayList<Book> getClubBooks() {

        return clubBooks;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    /**
     * A record of books Borrowed from A club
     */
    public class Record {

        private Book book;

        /**
         * the id of the member
         */
        private int memberID;

        /**
         * Creates a new Record with the given parameter
         * @param book a book that is borrowed
         * @param id the id of the  member that borrowed the book
         */
        public Record(Book book, int id) {
            this.book = book;
            memberID = id;
        }
    }
}
