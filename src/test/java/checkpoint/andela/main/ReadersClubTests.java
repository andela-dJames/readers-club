package checkpoint.andela.main;

import org.junit.Test;

/**
 * Created by Daniel James on 10/4/2015.
 */
public class ReadersClubTests {
    @Test
    public void addBookShouldAddUpadateClubBooks(){
        ReadersClub readersClub = new ReadersClub();
        Book book = new Book("123-isbn-001", "Oluwa Tosin");
        book.setNoOfCopies(20);
        int numOfcps = book.getNoOfCopies();


    }
}
