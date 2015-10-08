package checkpoint.andela.main;

/**
 * Created by Daniel James on 10/6/2015.
 */
public interface Club {

    public void addMember(Member member);
    public void addBook(Book book, int nunberofCopies) throws NullBookException ;
    public void borrowBook (Book book) throws NullMemberException, NullBookException;
    public void lendBook(Book book);
    public int getTotalRequst();
    public void addToQ (Member member);
    public void returnBook(Book book, int id);


}
