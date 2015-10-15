package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import exceptions.MemberAlreadyexistExeption;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Test Cases for methods in <code>ReaderClub</code>
 * @author Daniel James
 */
public class ReadersClubTests {

    @Test
    public void addMemberShouldAddmemberToMembersList() throws MemberAlreadyexistExeption {
        Student pascal = new Student();
        Student pascal2 = new Student();

        ClubMembers AndelaClubMembers = new ClubMembers();
        AndelaClubMembers.addMembers(pascal);

        assertTrue(AndelaClubMembers.getMembers().contains(pascal));
    }

    @Test
    public void addBookShouldAddnewBookToClubBooks() {
        ClubBooks AndelaClubBooks = new ClubBooks();
        Book Book1 = new Book("ISBN-3456-YOU", "The End Of Days", "Michael Rosenberg");

        AndelaClubBooks.addBook(Book1, 5);

        assertTrue(AndelaClubBooks.getBooks().contains(Book1));
    }
    @Test
    public void addBookShouldUpdateClubBooks() {
        ClubBooks AndelaClubBooks = new ClubBooks();
        Book Book1 = new Book("ISBN-3456-YOU", "The End Of Days", "Michael Rosenberg");

        AndelaClubBooks.addBook(Book1, 5);
        AndelaClubBooks.addBook(Book1, 5);

        assertEquals("Book1 number of copies should be 10", 10, Book1.getNoOfCopies());
    }

    @Test
    public void membersCanBeAddedToQueue(){
        MembersQueue andelamembersQ = new MembersQueue();
        Member pascal = new Student();
        Member pascal2 = new Staff();
        andelamembersQ.addToQueue(pascal);
        andelamembersQ.addToQueue(pascal2);

        assertEquals("The queue size should be 2", 2, andelamembersQ.getMembers().size());

    }

    @Test
    public void membersAreGivenPriorityBasedOnRank() throws MemberAlreadyexistExeption {

        ClubMembers andelaClubmembers = new ClubMembers();
        MembersQueue andelamembersQ = new MembersQueue();
        Member pascal = new Student();
        Student marshal = new Student();
        Student michael = new Student();
        Member pascal2 = new Staff();

        andelaClubmembers.addMembers(michael);
        andelaClubmembers.addMembers(marshal);
        andelaClubmembers.addMembers(pascal);
        andelaClubmembers.addMembers(pascal2);

        andelamembersQ.addToQueue(marshal);
        andelamembersQ.addToQueue(michael);
        andelamembersQ.addToQueue(pascal);
        andelamembersQ.addToQueue(pascal2);

        assertTrue(andelamembersQ.removeBypriority() == pascal2);

    }

    @Test
    public void membersAreGivenPriorityBasedOnTimeOfRegistration() throws MemberAlreadyexistExeption {
        ClubMembers andelaClubmembers = new ClubMembers();
        MembersQueue andelamembersQ = new MembersQueue();
        Member pascal = new Student();
        Student marshal = new Student();
        Student michael = new Student();
        Member pascal2 = new Staff();
        Member prosper = new Staff();

        andelaClubmembers.addMembers(michael);
        andelaClubmembers.addMembers(marshal);
        andelaClubmembers.addMembers(pascal);
        andelaClubmembers.addMembers(prosper);
        andelaClubmembers.addMembers(pascal2);

        andelamembersQ.addToQueue(marshal);
        andelamembersQ.addToQueue(michael);
        andelamembersQ.addToQueue(pascal);
        andelamembersQ.addToQueue(prosper);
        andelamembersQ.addToQueue(pascal2);

        assertFalse("The top of the queue should be Prosper", andelamembersQ.removeBypriority() == pascal2);

    }

    @Test
    public void membersAreGivenPriorityBasedOnTimeOfEntry() throws MemberAlreadyexistExeption {

        ClubMembers andelaClubmembers = new ClubMembers();
        MembersQueue andelamembersQ = new MembersQueue();
        Member pascal = new Student();
        Student marshal = new Student();
        Student michael = new Student();
        Member pascal2 = new Staff();
        Member prosper = new Staff();

        andelaClubmembers.addMembers(michael);
        andelaClubmembers.addMembers(marshal);
        andelaClubmembers.addMembers(pascal);
        andelaClubmembers.addMembers(prosper);
        andelaClubmembers.addMembers(pascal2);

        andelamembersQ.addToQueue(marshal);
        andelamembersQ.addToQueue(michael);
        andelamembersQ.addToQueue(pascal);
        andelamembersQ.addToQueue(prosper);
        andelamembersQ.addToQueue(pascal2);

        assertTrue("The top of the queue should be Prosper", andelamembersQ.removeBypriority() == prosper);

    }

}
