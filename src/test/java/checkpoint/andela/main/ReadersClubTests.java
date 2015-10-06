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
    public void addBookShouldAddUpadateClubBooks() throws NullBookException{
        ReadersClub readersClub = new ReadersClub();
        Book book = new Book("123-isbn-001", "Oluwa Tosin");
        book.setNoOfCopies(20);
        int numOfcps = book.getNoOfCopies();
        readersClub.addBook(book, 5);

        assertEquals("addBook should add 5 copies to clubBooks", 25, book.getNoOfCopies());

    }

    @Test
    public void removeBookShouldReoveBookfromClubBooks() throws NullBookException {
        ReadersClub readersClub = new ReadersClub();
        Book book = new Book("123-isbn-001", "Michael Rosenberg");
        book.setNoOfCopies(20);
        int numOfcps = book.getNoOfCopies();
        readersClub.addBook(book, 5);
        readersClub.removeBook(book, 5);

        assertEquals("addBook should add 5 copies to clubBooks", 20, book.getNoOfCopies());
    }

    @Test
    public void registerShoulAddNewStudentToClub() throws NullMemberException {
        ReadersClub readersClub = new ReadersClub();
        Member member1 = new Student("ID-15-006", "Nadaya Engesi", 'M');
        readersClub.register(member1);
        assertTrue(readersClub.getStudentMembers().contains(member1));
    }

    @Test
    public void registerShoulAddNewStaffToClub() throws NullMemberException {
        ReadersClub readersClub = new ReadersClub();
        Member member1 = new Staff("ID-15-006", "Nadaya Engesi", 'M');
        readersClub.register(member1);
        assertTrue(readersClub.getStaffmembers().contains(member1));
    }

    @Test
    public void registerShoulAddNewMemberToClub() throws NullMemberException {
        ReadersClub readersClub = new ReadersClub();
        Member member1 = new Staff("ID-15-006", "Nadaya Engesi", 'M');
        Member member = new Student("ID-15-006", "Nadaya Engesi", 'M');
        readersClub.register(member1);
        readersClub.register(member);
        assertTrue(readersClub.getClubmembers().contains(member1));
        assertTrue(readersClub.getClubmembers().contains(member));
        assertEquals("size of the club members should return 2", 2, readersClub.getClubmembers().size());
    }

    @Test
    public void validatememberShouldReturnTrueifMemberisRegistered() throws NullMemberException {
        ReadersClub readersClub = new ReadersClub();
        Member member1 = new Staff("ID-15-006", "Nadaya Engesi", 'M');
        readersClub.register(member1);
        assertTrue(readersClub.validateMember(member1));
    }
    @Test
    public void validatememberShouldReturnFalseifMemberisNotRegistered() throws NullMemberException {
        ReadersClub readersClub = new ReadersClub();
        Member member1 = new Staff("ID-15-006", "Nadaya Engesi", 'M');
        Member member = new Student("ID-15-023", "Tosin Adesanya", 'M');
        readersClub.register(member1);
        assertFalse(readersClub.validateMember(member));
    }
    @Test
    public void validateBookShouldReturnTrueifBookisinClubBooks() throws NullBookException {
        ReadersClub readersClub = new ReadersClub();
        Book book = new Book("ISBN-OQW-456", "Once Upon A Time", "Obioma, Ofoamalu");
        readersClub.addBook(book, 20);
        assertTrue(readersClub.validateBook(book));
    }
    @Test
    public void validateBookShouldReturnFalseifBookisinNotClubBooks() throws NullBookException {
        ReadersClub readersClub = new ReadersClub();
        Book book = new Book("ISBN-OQW-456", "Once Upon A Time", "Obioma, Ofoamalu");
        Book book1 = new Book("ISBN-EST-2345", "Diamonds Are Forever", "Grace Omotoso");
        readersClub.addBook(book, 20);
        assertFalse(readersClub.validateBook(book1));
    }
}
