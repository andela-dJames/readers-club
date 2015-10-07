package checkpoint.andela;

import checkpoint.andela.main.*;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;


public class Main {

    public static void main(String[] args) throws NullBookException, NullMemberException {
        ReadersClub RC = new ReadersClub();
        Book bk = new Book("12345");
        bk.setNoOfCopies(20);
        int x = bk.getNoOfCopies();
        System.out.println(bk.getiSBN()+ x);
//        RC.addBook(bk, 20);
//        RC.addBook(bk, 20);
        System.out.println(bk.getiSBN() + " "+ bk.getNoOfCopies());
        // write your code here
	// write your code here
        Member member = new Member("1234", "daniel");
        Member member2 = new Member("1234", "daniel");
        ReaderClub andela = new ReaderClub();
        //andela.addMember(member);
        Staff staff = new Staff(andela);
        staff.setNumber("2000");
        Student student = new Student(andela);
        Book books = new Book(andela);
        books.setiSBN("ssgdyy");
        andela.addBook(books, 10);
        staff.borrowBook(books);
        student.borrowBook(books);
        student.borrowBook(books);
        andela.lendBook(books, staff.getNumber());
        System.out.println(staff.getDateOfRegistration() + " " + books.getNoOfCopies() + " " + books.isInRequest() + " " + books.getNumOfRequests());
        System.out.println(andela.getTotalRequst());

    }


}
