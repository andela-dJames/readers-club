package checkpoint.andela.members;

import checkpoint.andela.main.Member;

/**
 * Created by Daniel James on 10/1/2015.
 */
public class Student extends Member {
    private String studentClasss;

    public Student(){

    }

    public Student(String studentNumber){

        super(studentNumber);

    }

    public Student(String number, String fullName) {
        super(number, fullName);
    }

    public Student(String number, String fullName, char gender) {
        super(number, fullName, gender);
    }

    public Student(String number, String fullName, char gender, String dateOfBirth) {
        super(number, fullName, gender, dateOfBirth);
    }

    public Student(String number, String fullName, char gender, String dateOfBirth, String phoneNumber) {
        super(number, fullName, gender, dateOfBirth, phoneNumber);
    }

    public String getStudentClasss() {
        return studentClasss;
    }

    public void setStudentClasss(String studentClasss) {
        this.studentClasss = studentClasss;
    }
}
