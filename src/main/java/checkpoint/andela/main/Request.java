package checkpoint.andela.main;

import org.joda.time.DateTime;

/**
 * A <code>Request</code> that can be initiated by any <code>member</code>
 * or many members
 * @author Daniel James
 *@version  0.0.1 10/1/2015.
 */
public class Request implements Comparable<Request> {
    /**
     * The date a <code>Request</code> is made
     */
    private DateTime requestDate;
    /**
     * A <code>Member</code> making request
     */
    private Member member;

    /**
     * creates an empty <code>Request</code>
     */
    public Request() {
    }

    /**
     * Creates a new <code>Request</code> with the following parameter
     * @param member
     */
    public Request(Member member) {
        this.member = member;
        requestDate = DateTime.now();
    }

    /**
     * Creates a new <code>Request</code> with the following parameters
     * @param member
     * @param date
     */
    public Request(Member member, DateTime date) {
        this(member);
        requestDate = date;
    }

    public DateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(DateTime requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public int compareTo(Request request) {
        if(this.getMember().isStaff() && request.getMember().isStaff()) {
            return getRequestDate().compareTo(request.getRequestDate());
        }
        else if (this.getMember().isStudent() && request.getMember().isStudent()) {
            return getRequestDate().compareTo(request.getRequestDate());
        }
        else if (this.getMember().isStaff() && request.getMember().isStudent()) {
            return 1;
        }
        else if (this.getMember().isStudent() && request.getMember().isStaff()) {
            return -1;
        }
        else return 0;

    }
    /**
     * @return <code>Member</code> that initiated request
     */
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
