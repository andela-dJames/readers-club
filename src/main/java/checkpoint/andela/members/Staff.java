package checkpoint.andela.members;

import checkpoint.andela.main.Member;

/**
 * Created by Daniel James on 10/1/2015.
 */
public class Staff extends Member {
    private double netPay;



    public Staff(String staffNumber) {
        super(staffNumber);
    }

    public Staff(String staffNumber, String fullName, char gender, String dateOfBirth, String phoneNumber, String number) {
        super(staffNumber, fullName);
    }

    public Staff() {
    }

    public Staff(String staffNumber, String fullName, char gender) {
        super(staffNumber, fullName, gender);
    }

    public Staff(String staffNumber, String fullName, char gender, String dateOfBirth) {
        super(staffNumber, fullName, gender, dateOfBirth);
    }

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

    public boolean isStaff(){
        return true;
    }

}
