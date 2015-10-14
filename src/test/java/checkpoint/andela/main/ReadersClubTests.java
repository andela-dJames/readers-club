package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by Daniel James on 10/4/2015.
 */
public class ReadersClubTests {

    @Test
    public void addMemberShouldAddmemberToMembersList() throws MemberAlreadyexistExeption {
        ReaderClub Andela = new ReaderClub();
        Student pascal = new Student();
        Student pascal2 = new Student();

        ClubMembers AndelaClubMembers = new ClubMembers(Andela);
        AndelaClubMembers.addMembers(pascal);
        AndelaClubMembers.addMembers(pascal);
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


}
