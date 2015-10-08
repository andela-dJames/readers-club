package checkpoint.andela.members;


import checkpoint.andela.main.ReaderClub;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A test for Staff Class
 */
public class StaffTest {

    @Test
    public void isStaffShouldReturnTrue() {

        ReaderClub Andela = new ReaderClub();
        Staff tosin = new Staff(Andela);
        Staff chidi = new Staff(Andela);

        assertTrue(tosin.isStaff());
    }

    @Test
    public void isStudentShouldreturnFalse() {

        ReaderClub Andela = new ReaderClub();
        Staff tosin = new Staff(Andela);
        Staff chidi = new Staff(Andela);

        assertFalse(tosin.isStudent());
    }

}
