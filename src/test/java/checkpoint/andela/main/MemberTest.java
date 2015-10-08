package checkpoint.andela.main;


import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.*;

/**
 * Created by Daniel James on 10/4/2015.
 */
public class MemberTest {
    @Test
    public void membersAreAutomaticallyAddedToClub() {

        ReaderClub Andela = new ReaderClub();
        Staff tosin = new Staff(Andela);
        Staff chidi = new Staff(Andela);

        assertEquals("members list should be 2", 2, Andela.getMembers().size());

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
    public void clubMembersCanRequstBook() throws NullBookException, NullMemberException {

        ReaderClub Andela = new ReaderClub();
        Book book = new Book("ISBN-OQW-456", "Once Upon A Time", "Obioma, Ofoamalu");
        Book book1 = new Book("ISBN-EST-2345", "Diamonds Are Forever", "Grace Omotoso");
        Staff tosin = new Staff(Andela);
        Staff chidi = new Staff(Andela);
        Staff daniel = new Staff("ST-1001", "Daniel James");

        Andela.addBook(book, 20);
        Andela.addBook(book1, 20);
        tosin.borrowBook(book1);

        assertTrue(book1.isInRequest());





    }

}
