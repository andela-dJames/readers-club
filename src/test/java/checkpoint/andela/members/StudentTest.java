package checkpoint.andela.members;

import checkpoint.andela.main.Member;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by Daniel James on 10/4/2015.
 */
public class StudentTest {
    @Test
    public void isStudentShouldReturnTrue(){
        Student student = new Student();
        assertTrue(student.isStudent());
    }
    @Test
    public void isStaffShouldreturnfalse(){
        Member student = new Student();
        assertFalse(student.isStaff());
    }
}
