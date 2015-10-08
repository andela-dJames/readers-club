package checkpoint.andela.main;


import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.*;

/**
 * A test for Member class
 * @author Daniel James
 */
public class MemberTest {

    ReaderClub Andela = new ReaderClub();

    Book book = new Book("ISBN-OQW-456", "Once Upon A Time", "Obioma, Ofoamalu");

    Book book1 = new Book("ISBN-EST-2345", "Diamonds Are Forever", "Grace Omotoso");

    Book book2 = new Book("ISBN-EST-2345", "Diamonds Are Forever", "Grace Omotoso");

    Staff tosin = new Staff(Andela);

    Staff chidi = new Staff(Andela);

    Staff daniel = new Staff("ST-1001", "Daniel James");

    /**
     * Class to run before every method in test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Andela.addBook(book, 20);
        Andela.addBook(book1, 20);
        tosin.borrowBook(book1);

    }

    /**
     * test to show that members are added to members list automatically
     */
    @Test
    public void membersAreAutomaticallyAddedToClub() {


        assertEquals("members list should be 2", 2, Andela.getMembers().size());

    }

    /**
     * A tesst to show that only club members cab request for book
     * @throws NullBookException
     * @throws NullMemberException
     */
    @Test
    public void clubMembersCanRequstBook() throws NullBookException, NullMemberException {

        assertTrue(book1.isInRequest());
    }

    /**
     * A test to show that only available books can be requested
     * @throws NullMemberException
     * @throws NullBookException
     */
    @Test
    public void onlyAvailableBooksCanBeREquested() throws NullMemberException, NullBookException {

        tosin.borrowBook(book2);

        assertFalse(book2.isInRequest());

    }

}
