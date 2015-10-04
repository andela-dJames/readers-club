package checkpoint.andela;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.ReadersClub;

public class Main {

    public static void main(String[] args) {
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
    }
}
