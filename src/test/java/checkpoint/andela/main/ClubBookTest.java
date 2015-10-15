package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class ClubBookTest {
    @Test
    public void borrowBookSetBookRequesterToMember() throws NullBookException, NullMemberException {
        Book Book1 = new Book("ISBN-3456-YOU", "The End Of Days", "Michael Rosenberg");
        Book Book2 = new Book("ISBN-1456-ERTY", "Paradoxical Thinking", "Michael Rosenberg");
        Staff Tosin = new Staff();
        ClubBooks AndelaCL = new ClubBooks();
        AndelaCL.addBook(Book1, 10);
        AndelaCL.borrowBook(Tosin, Book1);

        assertTrue(AndelaCL.getBookRecord().getRequester() == Tosin);
    }

    @Test(expected = NullBookException.class)
    public void borrowBookShouldThrowNullBookExceptinIfBookIsNotAvailable() throws NullBookException, NullMemberException {
        Book Book1 = new Book("ISBN-3456-YOU", "The End Of Days", "Michael Rosenberg");
        Book Book2 = new Book("ISBN-1456-ERTY", "Paradoxical Thinking", "Michael Rosenberg");
        Staff Tosin = new Staff();
        ClubBooks AndelaCL = new ClubBooks();
        AndelaCL.addBook(Book1, 10);
        AndelaCL.borrowBook(Tosin, Book2);

    }
}
