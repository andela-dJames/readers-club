package checkpoint.andela.main;
import org.joda.time.DateTime;

/**
 * Members of a given <code>ReadersClub</code>
 * @author  Daniel James
 * @version 0.0.1 10/1/2015.
 */
public class Member {
    /**
     * The id of a member
     */
    private int id;
    /**
     * member's full name
     */
    private String fullName;
    /**
     * member's gender
     */
    private char gender;
    /**
     * members date of birth
     */
    private String dateOfBirth;
    /**
     * member's phone number
     */
    private String phoneNumber;
    /**
     * members number
     */
    private String number;
    /**
     * members date of registration
     */
    private DateTime dateOfRegistration;

    public Member() {
    }

    /**
     * Creates a member with this parameter
     *
     * @param id the member's number.
     */
    public Member(int id) {
        this.id = id;
    }

    /**
     * creates a staff with these parameters
     *
     * @param number   the number of the member
     * @param fullName the full name of the member.
     */
    public Member(String number, String fullName) {
        this.fullName = fullName;
    }

    /**
     * creates a staff with these parameters
     *
     * @param number   the number of the member
     * @param fullName the full name of the member
     * @param gender   the gender of the member.
     */
    public Member(String number, String fullName, char gender) {
        this(number, fullName);
        this.gender = gender;
    }

    /**
     * creates a staff with these parameters
     *
     * @param number      the number of the member
     * @param fullName    the full name of the member
     * @param gender      the gender of the member
     * @param dateOfBirth the member's date of birth
     */
    public Member(String number, String fullName, char gender, String dateOfBirth) {
        this(number, fullName, gender);
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * creates a member with these parameters
     *
     * @param number      the number of the member
     * @param fullName    the full name of the member
     * @param gender      the gender of the member
     * @param dateOfBirth the member's date of birth
     * @param phoneNumber the member's phone number
     */
    public Member(String number, String fullName, char gender, String dateOfBirth, String phoneNumber) {
        this(number, fullName, gender, dateOfBirth);
        this.phoneNumber = phoneNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DateTime getDateOfRegistration() {

        return dateOfRegistration;
    }

    public void setDateOfRegistration(DateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public boolean isStaff() {

        return false;
    }

    public boolean isStudent() {
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
