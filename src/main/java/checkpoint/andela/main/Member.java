package checkpoint.andela.main;



import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Members of a given <code>ReadersClub</code>
 * @author  Daniel James
 * @version 0.0.1 10/1/2015.
 */
public class Member {
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
     * members date of deregistration
     */
    private DateTime dateOfRegistration;
    /**
     * members date of registration
     */
    private DateTime dateOfdeRegistration;
    /**
     * request made by a member of the club
     */
    private Request request;
    /**
     * list of books in the clubs bookstore/library
     */
    private ArrayList<Book> listOfBooks;

    /**
     * creates a new member
     */
    public Member() {
    }
    /**
     * Creates a member with this parameter
     * @param number the member's number.
     */
    public Member(String number){
        this.number = number;
        this.listOfBooks = new ArrayList<>();
    }
    /**
     * creates a staff with these parameters
     * @param number the number of the member
     * @param fullName the full name of the member.
     */
    public Member(String number, String fullName) {
        this(number);
        this.fullName = fullName;
    }
    /**
     * creates a staff with these parameters
     * @param number the number of the member
     * @param fullName the full name of the member
     * @param gender    the gender of the member.
     */
    public Member(String number, String fullName, char gender) {
        this(number, fullName);
        this.gender = gender;
    }
    /**
     * creates a staff with these parameters
     * @param number the number of the member
     * @param fullName the full name of the member
     * @param gender    the gender of the member
     * @param dateOfBirth the member's date of birth
     */
    public Member(String number, String fullName, char gender, String dateOfBirth) {
        this(number, fullName, gender);
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * creates a member with these parameters
     * @param number the number of the member
     * @param fullName the full name of the member
     * @param gender    the gender of the member
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

        return dateOfRegistration ;
    }

    public void setDateOfRegistration(DateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public DateTime getDateOfdeRegistration() {
        return dateOfdeRegistration;
    }

    public void setDateOfdeRegistration(DateTime dateOfdeRegistration) {
        this.dateOfdeRegistration = dateOfdeRegistration;
    }

    public DateTime getCurrentTime(){
        return DateTime.now();
    }

    public Book borrowBook(Book book){
        listOfBooks.add(book);
        return book;
    }

    public Book returnBook(Book book) {
        listOfBooks.remove(book);
        return book;
    }

    public boolean equals(Member member) {
        return this.getNumber().equals(member.getNumber());
    }


    public boolean isStaff(){
        return false;
    }

    public boolean isStudent() {
        return false;
    }

}
