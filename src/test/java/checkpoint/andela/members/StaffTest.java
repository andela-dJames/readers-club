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
<<<<<<< HEAD
    public void isStaffShouldReturnTrue(){
        Staff member = new Staff();
        assertTrue(member.isStaff());
    }

    @Test
    public void isStudentShouldreturnFalse(){
        Staff member = new Staff();
        assertFalse(member.isStudent());
=======
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
>>>>>>> 3d90b247ae6a5f5b27f982794852d48dcc8926e0
    }

}
