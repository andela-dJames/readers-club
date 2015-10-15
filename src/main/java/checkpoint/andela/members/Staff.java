package checkpoint.andela.members;

import checkpoint.andela.main.Club;
import checkpoint.andela.main.Member;

/**
 * A Staff who is a member of the Readers Club
 * @author  Daniel James.
 * @version 0.0.1 10/1/2015.
 */
public class Staff extends Member {
    /**
     * The net pay of the Staff Member
     */
    private double netPay;
    /**
     * creates a <code>Staff</code> member
     */
    public Staff(Club club) {

        super(club);

    }

    /**
     * creates a <code>Staff</code> with these parameters
     * @param staffNumber the number of the staff
     * @param fullName the full name of the staff
     */
    public Staff(String staffNumber, String fullName) {

        super(staffNumber, fullName);

    }
    /**
     * creates a <code>Staff</code> with these parameters
     * @param staffNumber the number of the staff
     * @param fullName the full name of the staff
     * @param gender the staff's gender
     */
    public Staff(String staffNumber, String fullName, char gender) {

        super(staffNumber, fullName, gender);

    }
    /**
     * creates a <code>Staff</code> with these parameters
     * @param staffNumber the number of the staff
     * @param fullName the full name of the staff
     * @param gender the staff's gender
     * @param dateOfBirth the date of birth of the staff member
     */
    public Staff(String staffNumber, String fullName, char gender, String dateOfBirth) {

        super(staffNumber, fullName, gender, dateOfBirth);

    }
    /**
     * creates a <code>Staff</code> with these parameters
     * @param staffNumber the number of the staff
     * @param fullName the full name of the staff
     * @param gender    the gender of the staff
     * @param dateOfBirth the staff's date of birth
     * @param phoneNumber the staff's pone number
     */
    public Staff(String staffNumber, String fullName, char gender, String dateOfBirth, String phoneNumber) {

        super(staffNumber, fullName, gender, dateOfBirth, phoneNumber);

    }

    public double getNetPay() {

        return netPay;

    }

    public void setNetPay(double netPay) {

        this.netPay = netPay;

    }

    public void assignToStudents(Student student){

    }
    /**
     * @return <code>true</code> if member is staff
     */
    public boolean isStaff(){

        return true;

    }
}
