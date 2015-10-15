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

    public void isStaffShouldreturnfalse(){
        Student student = new Student();
        assertFalse(student.isStaff());

    }

}
