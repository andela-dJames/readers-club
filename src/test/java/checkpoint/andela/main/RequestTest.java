package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel James on 10/16/2015.
 */
public class RequestTest {
    Request request = new Request();
    Book Book1 = new Book("ISBN-3456-YOU", "The End Of Days", "Michael Rosenberg");
    Book Book2 = new Book("ISBN-1456-ERTY", "Paradoxical Thinking", "Michael Rosenberg");
    Staff Tosin = new Staff();
    Staff Tosin2 = new Staff();
    ClubBooks AndelaCL = new ClubBooks();

    @Before
    public void setUp() throws Exception {
        AndelaCL.addBook(Book1, 1);
        request.setBooks(AndelaCL.getBooks());
        request.makeRequest(Tosin, Book1);
        request.makeRequest(Tosin2, Book1);
        request.borrowBook(Tosin, Book1);
    }

    @Test
    public void requestShouldBeResolvedIfThereIsConflict(){
        assertTrue(request.shouldBeResolved(Book1));
    }

    @Test
    public void requestShouldBeGrantedIfnoConflict(){
        AndelaCL.addBook(Book2, 4);
        request.makeRequest(Tosin, Book2);
        request.makeRequest(Tosin2, Book2);
        assertFalse(request.shouldBeResolved(Book2));
    }

    @Test
    public void membersAreAddedToQueueIfThereIsConflict() {
        request.borrowBook(Tosin2, Book1);
        assertTrue(request.contains(Tosin2));
    }

}
