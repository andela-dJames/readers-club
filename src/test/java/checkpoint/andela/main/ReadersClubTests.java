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

}
