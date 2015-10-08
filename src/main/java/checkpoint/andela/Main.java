package checkpoint.andela;

import checkpoint.andela.main.*;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;

import java.util.PriorityQueue;
import java.util.Queue;


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
        ReaderClub Andela = new ReaderClub();
        Staff staff = new Staff(Andela);
        Student student = new Student(Andela);
        Staff staff1 = new Staff(Andela);
        Student student1 = new Student(Andela);
//        Staff staff = new Staff(Andela);
//        Student student = new Student(Andela)
//        Staff staff = new Staff(Andela);
//        Student student = new Student(Andela)

        Andela.addToQ(student1);
        Andela.addToQ(student);
        Andela.addToQ(staff1);
        Andela.addToQ(staff);
        staff.setNumber("1234");
        staff1.setNumber("234");
        student.setNumber("student");
        student1.setNumber("student2");
        Queue P = new PriorityQueue<>();
        P = Andela.getRequestQueue();
        Member m = new Member(Andela);

            m = (Member) P.poll();
            System.out.println(Andela.getRequestQueue().size() + " " + m.getNumber() + " "+m.getId());
        m = (Member) P.poll();
        System.out.println(Andela.getRequestQueue().size() + " " + m.getNumber()+ " "+m.getId());
        m = (Member) P.poll();
        System.out.println(Andela.getRequestQueue().size() + " " + m.getNumber()+ " "+m.getId());
        m = (Member) P.poll();
        System.out.println(Andela.getRequestQueue().size() + " " + m.getNumber()+ " "+m.getId());
        System.out.println(student.getId());


//
    }


}
