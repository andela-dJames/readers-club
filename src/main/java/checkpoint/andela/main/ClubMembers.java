package checkpoint.andela.main;

import exceptions.MemberAlreadyexistExeption;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * ClubMembers Class for manipulating club members
 */
public class ClubMembers {
    /**
     * An array list of members.
     */
    private ArrayList<Member> members;
    /**
     * the ID of a member
     */
    private int memberID;
    private int count;

    public ClubMembers() {
        members = new ArrayList<Member>();
    }

    /**
     * Adds members to Club list
     * @param member tobe added
     * @throws MemberAlreadyexistExeption
     */
    public void addMembers(Member member) throws MemberAlreadyexistExeption {
        if (members.contains(member)) {
            throw new MemberAlreadyexistExeption();
        }
        else {

            member.setDateOfRegistration(DateTime.now());
            setMemberID(member);
            members.add(member);
        }
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
    /**
     * Sets the Id of a member
     * @param member member of a club
     */
    private void setMemberID(Member member) {
        member.setId(count);
        count++;
    }

    public boolean contains(Member member){
        return members.contains(member);
    }
}
