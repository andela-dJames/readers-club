package checkpoint.andela.main;

import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by Daniel James on 10/1/2015.
 */
public class Member {
    private String fullName;

    private char gender;

    private String dateOfBirth;

    private String phoneNumber;

    private String number;

    private DateTime dateOfRegistration;

    private DateTime dateOfdeRegistration;

    private Request request;

    private ArrayList<Book> listOfBooks;

    private int status;

    public Member() {

    }

    public Member(String number){
        this.number = number;
        this.listOfBooks = new ArrayList<>();

    }

    public Member(String number, String fullName) {
        this(number);
        this.fullName = fullName;
    }

    public Member(String number, String fullName, char gender) {
        this(number, fullName);
        this.gender = gender;
    }

    public Member(String number, String fullName, char gender, String dateOfBirth) {
        this(number, fullName, gender);
        this.dateOfBirth = dateOfBirth;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DateTime getCurrentTime(){
        return DateTime.now();
    }

    public Book borrowBook(Book book){
        return book;
    }

    public Book returnBook(Book book) {
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
