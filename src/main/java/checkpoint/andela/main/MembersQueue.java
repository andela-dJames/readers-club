package checkpoint.andela.main;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implements the <code>PriorityQueue</code> for members in a club
 * @author  Daniel James
 * @version 0.0.1 10/1/2015.
 */
public class MembersQueue {
    /**
     * The members priority in a queue.
     */
    public static Comparator<Member> membersPriority = new Comparator<Member>(){

        @Override
        public int compare(Member member, Member member1) {
            if (member.isStaff() && member1.isStaff()) {
                return (member.getId() - member1.getId());
            }
            if (member.isStaff() && member1.isStudent()) {
                return -1;
            }
            if (member.isStudent() && member1.isStaff()) {
                return 1;
            } else
                return (member.getId() - member1.getId());
        }
    };
    /**
     * A queue of members in a list
     */
    private PriorityQueue<Member> members;

    /**
     * Creates a new Members queue
     */
    public MembersQueue() {
        members = new PriorityQueue<>(10, membersPriority);
    }

    /**
     * Adds to a queue with the given parameter
     * @param member member to be added to a queue.
     */
    public void addToQueue(Member member) {
        members.offer(member);
    }

    /**
     * Removes a member from the top of the Queue with priority
     * @return the member at the top of the queue.
     */
    public Member removeBypriority() {
        return members.poll();
    }

    public PriorityQueue<Member> getMembers() {
        return members;
    }

    public boolean contains(Member member) {
        return members.contains(member);
    }

}


