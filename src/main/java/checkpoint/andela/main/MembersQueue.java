package checkpoint.andela.main;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Daniel James on 10/14/2015.
 */
public class MembersQueue {

    public static MembersPriority membersPriority;

    private PriorityQueue<Member> members;

    public MembersQueue() {
        members = new PriorityQueue<>(10, membersPriority);
    }

    public void addToQueue(Member member) {
        members.offer(member);
    }

    public void removeBypriority() {
        members.poll();
    }

    public PriorityQueue<Member> getMembers() {
        return members;
    }

    public static class MembersPriority implements Comparator<Member>{

        @Override
        public int compare(Member member, Member member1) {
            if (member.isStaff() && member1.isStaff()) {
                return member.getDateOfRegistration().compareTo(member1.getDateOfRegistration());
            }
            if (member.isStaff() && member1.isStudent()) {
                return -1;
            }
            if (member.isStudent() && member1.isStaff()) {
                return 1;
            } else
                return member.getDateOfRegistration().compareTo(member1.getDateOfRegistration());
        }

    }
}


