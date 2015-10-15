package checkpoint.andela.main;

import exceptions.MemberAlreadyexistExeption;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by Daniel James on 10/13/2015.
 */
public class ClubMembers {
    private ArrayList<Member> members;


    private int memberID;

    private int count;

    public ClubMembers() {
        members = new ArrayList<Member>();
    }

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

    private void setMemberID(Member member) {
        member.setId(count);
        count++;

    }
}
