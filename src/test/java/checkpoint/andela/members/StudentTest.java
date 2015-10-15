package checkpoint.andela.members;

import org.junit.Test;

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
        assertTrue(student.isStudent());

    }

}
