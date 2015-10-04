package checkpoint.andela.members;

import checkpoint.andela.main.Member;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel James on 10/4/2015.
 */
public class StaffTest {
    @Test
    public void isStaffShouldReturnTrue(){
        Member member = new Staff();
        assertTrue(member.isStaff());
    }

    @Test
    public void isStudentShouldreturnFalse(){
        Member member = new Staff();
        assertFalse(member.isStudent());
    }
}
