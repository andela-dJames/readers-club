package checkpoint.andela.main;

import checkpoint.andela.members.Student;
import exceptions.MemberAlreadyexistExeption;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel James on 10/16/2015.
 */
public class ClubMembersTest {
    @Test
    public void membersCanBeAddedToList() throws MemberAlreadyexistExeption {
        ClubMembers clubMembers = new ClubMembers();
        Member pascal = new Student();
        clubMembers.addMembers(pascal);

        assertTrue(clubMembers.contains(pascal));

    }
    @Test(expected = MemberAlreadyexistExeption.class)
    public void shouldThrowMembersAlreadyExistException() throws MemberAlreadyexistExeption {
        ClubMembers clubMembers = new ClubMembers();
        Member pascal = new Student();
        clubMembers.addMembers(pascal);
        clubMembers.addMembers(pascal);

    }
}
