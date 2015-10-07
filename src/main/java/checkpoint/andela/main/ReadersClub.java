package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A <code>ReadersClub</code> with both staff and student members
 * A <code>Member</code> can be registered either as a <code>Staff</code>
 * or as a <code>Student</code>.
 * books can be added to the <code>ReadersClub</code>
 * Members can <code>Request</code> for books
 * @author  Daniel James
 * @version 0.0.1 10/1/2015.
 */
public class ReadersClub {
    /**
     * the name of the given club
     */
    private String clubName;
    /**
     * the address of the given club
     */
    private String clubAddress;
    /**
     * a list of all members in a given <code>ReadersClub</code>
     */
    private ArrayList<Member> clubmembers;
    /**
     * a list of all <code>Staff</code> members in a given <code>ReadersClub</code>
     */
    private ArrayList<Staff>staffmembers;
    /**
     * a list of all <code>Student</code> members in a given <code>ReadersClub</code>
     */
    private ArrayList<Student>studentMembers;
    /**
     * a list of all books in a given <code>ReadersClub</code>
     */
    private ArrayList<Book> clubBooks;
    /**
     * a queue of requests made by members that need to be resolved
     */
    private Queue<Member> requests;

    private BookRecords bookRecords;

    /**
     * <codee>memberPriority</codee> implements <code>Comparator<super E></></code>
     *<code>Overides</code> <code>compare</code> method.
     *
     */
    public static Comparator<Member> memberPriority = new Comparator<Member>() {
        @Override
        public int compare(Member member, Member member1) {
            if (member.isStaff() && member1.isStaff()) {
                return member.getDateOfRegistration().compareTo(member1.getDateOfRegistration());
            }
            if (member.isStaff() && member1.isStudent()) {
                return -1;
            }
            if (member.isStudent() && member1.isStaff()) {
                return 1;
            } else
                return member.getDateOfRegistration().compareTo(member1.getDateOfRegistration());
        }
    };

    /**
     * Creates a new <code>ReadersClub</code>
     */
    public ReadersClub() {
        clubmembers = new ArrayList<>();

        clubBooks = new ArrayList<>();

        staffmembers = new ArrayList<>();

        studentMembers = new ArrayList<>();

        requests = new PriorityQueue<Member>(10, memberPriority);

    }

    /**
     * creates a new <code>readersClub</code> with the following
     * @param name the name of the <code>ReadersClub</code>
     */
    public ReadersClub(String name) {

        this();
        clubName = name;
    }

    /**
     * creates a <code>ReadersClub</code> with the following
     * @param clubName the name of the <code>ReadersClub</code>
     * @param clubAddress the address of the <code>ReadersClub</code>
     */
    public ReadersClub(String clubName, String clubAddress) {

        this(clubName);

        this.clubAddress = clubAddress;
    }

    public String getClubName() {

        return clubName;
    }

    public void setClubName(String clubName) {

        this.clubName = clubName;
    }

    public String getClubAddress() {

        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {

        this.clubAddress = clubAddress;
    }

    public ArrayList<Member> getClubmembers() {

        return clubmembers;
    }

    public void setClubmembers(ArrayList<Member> clubmembers) {

        this.clubmembers = clubmembers;
    }

    public ArrayList<Staff> getStaffmembers() {

        return staffmembers;
    }

    public void setStaffmembers(ArrayList<Staff> staffmembers) {

        this.staffmembers = staffmembers;
    }

    public ArrayList<Student> getStudentMembers() {

        return studentMembers;
    }

    public void setStudentMembers(ArrayList<Student> studentMembers) {

        this.studentMembers = studentMembers;
    }

    public ArrayList<Book> getClubBooks() {

        return clubBooks;
    }

    public void setClubBooks(ArrayList clubBooks) {

        this.clubBooks = clubBooks;
    }

    /**
     * Adds a new <code>Book</code> to the library
     * @param book a book to be added
     * @param numOfCopies number of copies of the given book
     */
    public void addBook(Book book, int numOfCopies) throws NullBookException {
        if (book.getiSBN() == null && book.getNoOfCopies() < 1){
            //throw new NullBookException();
        }
        numOfCopies = numOfCopies + book.getNoOfCopies();
        book.setNoOfCopies(numOfCopies);
        clubBooks.add(book);
    }
    /**
     * Removes a new <code>Book</code> to the library
     * @param book a book to be added
     * @param numOfCopies number of copies of the given book
     */
    public void removeBook(Book book, int numOfCopies) throws NullBookException {
        if (!clubBooks.contains(book)){
            throw new NullBookException(numOfCopies);
        }
        else {
            clubBooks.remove(book);
            numOfCopies = book.getNoOfCopies() - numOfCopies;
            book.setNoOfCopies(numOfCopies);
        }

    }

    /**
     * Adds members into respective club lists
     * @param member a member to be registered
     * @param date the date of registration of the member
     */
    private void registration (Member member, DateTime date) {
        if (member.isStaff()) {
            staffmembers.add((Staff) member);
            clubmembers.add(member);
        } else if (member.isStudent()) {
            studentMembers.add((Student) member);
            clubmembers.add(member);
        }
    }

    /**
     * Registers a new member into the Club.
     * @param member to be registered
     * @throws NullMemberException if member number is not provided.
     * calls <code>registration</code> method.
     */
    public void register(Member member) throws NullMemberException{
        if (member.getNumber().equals(null)){
            throw new NullMemberException();
        }
        else {
            DateTime date = DateTime.now();
            member.setDateOfRegistration(date);
            registration(member, date);
            System.out.println(member.getFullName() + " was Successfully registered");
        }
    }

    /**
     * Acknowledges a <code>request</code> made by a member of the Club using the following parameters
     * @param member A registered member
     * @param book A Book in the club library
     */
    public void acknowledge(Member member, Book book) throws NullBookException, NullMemberException {

        bookRecords = new BookRecords(member, book);

        int number = bookRecords.getNumOfRequesters() + 1;

        bookRecords.setNumOfRequesters(number);

       // member.makeRequest(member, book);

        book.setinRequest(true);
    }

    /**
     * adds a request to the Priority queue if the book is in request by many members.
     * @param book
     * @param member
     */
    public void addRequest(Book book, Member member) {

        if (book.isInRequest() && bookRecords.getNumOfRequesters() > book.getNoOfCopies()) {
            requests.offer(member);
        }
        else
            releaseBook(member, book);
    }

    /**
     * releases a given book to a member
     * @param member Member with request.
     * @param book book in request
     */
    public void releaseBook(Member member, Book book) {

      // member.borrowBook(book);
    }
    /**
     * Validates a club member
     * @param member a member to be validated
     * @return true if member is registered
     * @throws NullMemberException
     */
    public boolean validateMember(Member member) throws NullMemberException {

        if (clubmembers.contains(member))
            return true;

        return false;
    }
    /**
     * Validates a club member
     * @param book a book to be validated
     * @return true if book is in <code>clubBooks</code>
     * @throws NullMemberException
     */
    public boolean validateBook(Book book) {

        if (clubBooks.contains(book))
            return true;

        return false;
    }

    public void processRequest() {
        Member member = requests.poll();
        //member.borrowBook(bookRecords.getBook());
    }

    /**
     * A record of books requsted by members in a club
     */
    public class BookRecords{
        /**
         * A member that made request
         */
        private Member member;
        /**
         * a book in that is being recorded
         */
        private Book book;
        /**
         * the number of people making request
         */
        private int numOfRequesters;

        /**
         * Creates a new <code>BookRecord</code>
         */
        public BookRecords() {

        }

        /**
         * Creates a new <code>BookRecord</code> with the following parameters
         * @param member a member
         */
        public BookRecords(Member member) {

            this.member = member;
        }

        /**
         * Creates a new <code>BookRecord</code> with the following parameters
         * @param member a member
         * @param book a book being recorded
         */
        public BookRecords(Member member, Book book){

            this(member);

            this.book = book;
        }

        public Member getMember() {

            return member;
        }

        public void setMember(Member member) {

            this.member = member;
        }

        public Book getBook() {

            return book;
        }

        public void setBook(Book book) {

            this.book = book;
        }

        public int getNumOfRequesters() {

            return numOfRequesters;

        }

        public void setNumOfRequesters(int numOfRequesters) {

            this.numOfRequesters = numOfRequesters;

        }
    }

}
