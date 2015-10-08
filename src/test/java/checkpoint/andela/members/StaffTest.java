package checkpoint.andela.members;

import checkpoint.andela.main.Member;
import checkpoint.andela.main.ReaderClub;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel James on 10/4/2015.
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
