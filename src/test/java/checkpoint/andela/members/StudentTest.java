package checkpoint.andela.members;

import checkpoint.andela.main.Member;
import checkpoint.andela.main.ReaderClub;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A <code>StudentTest</code> for testing sudent class methods
 * @author  Daniel James
 * @version 0.0.1 10/1/2015.
 */
public class StudentTest {
    @Test
    public void isStudentShouldReturnTrue() {

        ReaderClub Andela = new ReaderClub();
        Student prosper = new Student(Andela);

        assertTrue(prosper.isStudent());
    }
    @Test
<<<<<<< HEAD
    public void isStaffShouldreturnfalse(){
        Student student = new Student();
        assertFalse(student.isStaff());
=======
    public void isStaffShouldreturnfalse() {

        ReaderClub Andela = new ReaderClub();
        Student prosper = new Student(Andela);

        assertFalse(prosper.isStaff());
>>>>>>> 3d90b247ae6a5f5b27f982794852d48dcc8926e0
    }


}
