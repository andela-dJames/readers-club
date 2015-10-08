package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Test Cases for methods in <code>ReaderClub</code>
 */
public class ReadersClubTests {
    @Test
    public void membersArenotMismatchedInList(){

        ReaderClub Andela = new ReaderClub();
        Staff tosin = new Staff(Andela);
        Staff chidi = new Staff(Andela);
        Student grace = new Student(Andela);

        Andela.addToList(tosin);
        Andela.addToList(chidi);
        Andela.addToList(grace);

        assertFalse(Andela.getStudentList().contains(tosin));

    }
    @Test
    public void membersListShouldContainNewlyAddedMembers() {

        ReaderClub Andela = new ReaderClub();
        Staff tosin = new Staff(Andela);
        Staff chidi = new Staff(Andela);

        assertTrue(Andela.getMembers().contains(tosin));
    }
    @Test
    public void membersAreAddedToCorrespondingList() {

        ReaderClub Andela = new ReaderClub();
        Staff tosin = new Staff(Andela);
        Staff chidi = new Staff(Andela);
        Student grace = new Student(Andela);

        Andela.addToList(tosin);
        Andela.addToList(chidi);
        Andela.addToList(grace);

        assertTrue(Andela.getStaffList().contains(chidi));
    }
    @Test
    public void booksAreAddedToClubBooks() throws NullBookException {

        ReaderClub Andela = new ReaderClub();
        Book book = new Book("ISBN-OQW-456", "Once Upon A Time", "Obioma, Ofoamalu");
        Book book1 = new Book("ISBN-EST-2345", "Diamonds Are Forever", "Grace Omotoso");

        Andela.addBook(book, 20);
        Andela.addBook(book1, 4);

        assertEquals("ClubBooks should return 2", 2, Andela.getClubBooks().size());
    }


    @Test
    public void clubTracksNumberOfsimultaneousRequstsForABook() throws NullMemberException, NullBookException {
        ReaderClub Andela = new ReaderClub();
        Book book = new Book("ISBN-OQW-456", "Once Upon A Time", "Obioma, Ofoamalu");
        Book book1 = new Book("ISBN-EST-2345", "Diamonds Are Forever", "Grace Omotoso");
        Staff tosin = new Staff(Andela);
        Staff chidi = new Staff(Andela);
        Student daniel = new Student(Andela);

        Andela.addBook(book, 20);
        Andela.addBook(book1, 20);
        tosin.borrowBook(book1);
        chidi.borrowBook(book1);
        daniel.borrowBook(book1);
        daniel.borrowBook(book);

        assertEquals("Number of requsters for book1 should be 3", 3, book1.getNumOfRequests());

    }

    /**
     * Test if <code>resolve</code>Adds <code>Member</code> to queue if someone already requested for the book
     * and if the number of copies of that book is less than the total number of
     * people making requset.
     * @throws NullBookException
     * @throws NullMemberException
     */
    @Test
    public void membersAreAddedToQueueIfBookAlreadyIsInRequest() throws NullBookException, NullMemberException {

            ReaderClub Andela = new ReaderClub();
            Book book = new Book("ISBN-OQW-456", "Once Upon A Time", "Obioma, Ofoamalu");
            Book book1 = new Book("ISBN-EST-2345", "Diamonds Are Forever", "Grace Omotoso");
            Staff tosin = new Staff(Andela);
            Staff chidi = new Staff(Andela);
            Student daniel = new Student(Andela);

            Andela.addBook(book, 20);
            Andela.addBook(book1, 2);
            daniel.borrowBook(book1);

            Andela.resolve(book1, tosin);

            assertEquals("Queue should contain 4 members", 2, Andela.getRequestQueue().size());
            //assertTrue(Andela.getRequestQueue().contains(tosin));

    }

    /**
     * test that members are removed from queue with prioroty
     * @throws NullBookException
     * @throws NullMemberException
     */
    @Test
    public void requsetIsgrantedBasedOnFIFO() throws NullBookException, NullMemberException {
        ReaderClub Andela = new ReaderClub();
        Book book = new Book("ISBN-OQW-456", "Once Upon A Time", "Obioma, Ofoamalu");
        Book book1 = new Book("ISBN-EST-2345", "Diamonds Are Forever", "Grace Omotoso");
        Staff tosin = new Staff(Andela);
        Staff chidi = new Staff(Andela);
        Student daniel = new Student(Andela);

        Andela.addBook(book, 20);
        Andela.addBook(book1, 2);
        tosin.borrowBook(book1);
        chidi.borrowBook(book1);
        daniel.borrowBook(book1);
        daniel.borrowBook(book);

        Andela.resolve(book1, daniel );
        Andela.resolve(book1, chidi);
        Andela.resolve(book1, tosin);
        Andela.lendBook(book1);
        assertFalse(Andela.getRequestQueue().contains(tosin));



    }



}
