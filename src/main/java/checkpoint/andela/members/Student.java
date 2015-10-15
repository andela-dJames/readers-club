package checkpoint.andela.members;

import checkpoint.andela.main.Member;

/**
 * Student member of a given <code>ReadersClub</code>
 * @author  Daniel James
 * @version 0.0.1 10/1/2015.
 */
public class Student extends Member {
    /**
     * the class of the student in a <code>ReadersClub</code>
     */
    private String studentClasss;

    public Student() {

    }
    /**
     * creates a <code>Student</code> with these parameters
     * @param number the number of the Student
     * @param fullName the full name of the Student
     */
    public Student(String number, String fullName) {
        super(number, fullName);
    }
    /**
     * creates a <code>Student</code> with these parameters
     * @param number the number of the Student
     * @param fullName the full name of the Student
     * @param gender    the gender of the Student
     */
    public Student(String number, String fullName, char gender) {
        super(number, fullName, gender);
    }
    /**
     * creates a <code>Student</code> with these parameters
     * @param number the number of the Student
     * @param fullName the full name of the Student
     * @param gender    the gender of the Student
     * @param dateOfBirth the Student's date of birth
     */
    public Student(String number, String fullName, char gender, String dateOfBirth) {
        super(number, fullName, gender, dateOfBirth);
    }
    /**
     * creates a <code>Student</code> with these parameters
     * @param number the number of the Student
     * @param fullName the full name of the Student
     * @param gender    the gender of the Student
     * @param dateOfBirth the Student's date of birth
     * @param phoneNumber the Student's pone number
     */
    public Student(String number, String fullName, char gender, String dateOfBirth, String phoneNumber) {
        super(number, fullName, gender, dateOfBirth, phoneNumber);
    }

    public String getStudentClasss() {
        return studentClasss;
    }

    public void setStudentClasss(String studentClasss) {
        this.studentClasss = studentClasss;
    }

    /**
      * @return <code>true</code> for student member
     */
    public boolean isStudent(){
        return true;
    }
}
