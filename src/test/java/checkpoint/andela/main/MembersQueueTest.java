package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import exceptions.MemberAlreadyexistExeption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel James on 10/16/2015.
 */
public class MembersQueueTest {
    @Test
    public void membersCanBeAddedToQueue(){
        MembersQueue andelamembersQ = new MembersQueue();
        Member pascal = new Student();
        Member pascal2 = new Staff();
        andelamembersQ.addToQueue(pascal);
        andelamembersQ.addToQueue(pascal2);

        assertEquals("The queue size should be 2", 2, andelamembersQ.getMembers().size());

    }

    @Test
    public void membersAreGivenPriorityBasedOnRank() throws MemberAlreadyexistExeption {

        ClubMembers andelaClubmembers = new ClubMembers();
        MembersQueue andelamembersQ = new MembersQueue();
        Member pascal = new Student();
        Student marshal = new Student();
        Student michael = new Student();
        Member pascal2 = new Staff();

        andelaClubmembers.addMembers(michael);
        andelaClubmembers.addMembers(marshal);
        andelaClubmembers.addMembers(pascal);
        andelaClubmembers.addMembers(pascal2);

        andelamembersQ.addToQueue(marshal);
        andelamembersQ.addToQueue(michael);
        andelamembersQ.addToQueue(pascal);
        andelamembersQ.addToQueue(pascal2);

        assertTrue(andelamembersQ.removeBypriority() == pascal2);

    }

    @Test
    public void membersAreGivenPriorityBasedOnTimeOfRegistration() throws MemberAlreadyexistExeption {
        ClubMembers andelaClubmembers = new ClubMembers();
        MembersQueue andelamembersQ = new MembersQueue();
        Member pascal = new Student();
        Student marshal = new Student();
        Student michael = new Student();
        Member pascal2 = new Staff();
        Member prosper = new Staff();

        andelaClubmembers.addMembers(michael);
        andelaClubmembers.addMembers(marshal);
        andelaClubmembers.addMembers(pascal);
        andelaClubmembers.addMembers(prosper);
        andelaClubmembers.addMembers(pascal2);

        andelamembersQ.addToQueue(marshal);
        andelamembersQ.addToQueue(michael);
        andelamembersQ.addToQueue(pascal);
        andelamembersQ.addToQueue(prosper);
        andelamembersQ.addToQueue(pascal2);

        assertFalse("The top of the queue should be Prosper", andelamembersQ.removeBypriority() == pascal2);

    }
    @Test
    public void membersAreGivenPriorityBasedOnTimeOfEntry() throws MemberAlreadyexistExeption {

        ClubMembers andelaClubmembers = new ClubMembers();
        MembersQueue andelamembersQ = new MembersQueue();
        Member pascal = new Student();
        Student marshal = new Student();
        Student michael = new Student();
        Member pascal2 = new Staff();
        Member prosper = new Staff();

        andelaClubmembers.addMembers(michael);
        andelaClubmembers.addMembers(marshal);
        andelaClubmembers.addMembers(pascal);
        andelaClubmembers.addMembers(prosper);
        andelaClubmembers.addMembers(pascal2);

        andelamembersQ.addToQueue(marshal);
        andelamembersQ.addToQueue(michael);
        andelamembersQ.addToQueue(pascal);
        andelamembersQ.addToQueue(prosper);
        andelamembersQ.addToQueue(pascal2);

        assertTrue("The top of the queue should be Prosper", andelamembersQ.removeBypriority() == prosper);

    }


}
