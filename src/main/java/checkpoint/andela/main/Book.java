package checkpoint.andela.main;

/**
 * Created by Daniel James on 10/1/2015.
 */
public class Book {
    private String bookName;

    private String author;

    private int noOfCopies;

    private String iSBN;

    private boolean inRequest;

    private boolean borrowed;

    public Book() {
    }

    public Book(String isbnNumber) {
        iSBN = isbnNumber;
    }

    public Book(String isbnNumber, String name){
        this(isbnNumber);
        bookName = name;
    }

    public Book(String isbnNumber, String name, String author){
        this(isbnNumber, name);
        this.author = author;
    }



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public void rented(){
        borrowed = true;
    }

    public void returned(){
        borrowed = false;
    }

    public void SetinRequest(boolean inRequest){
        this.inRequest = inRequest;
    }

    public boolean isInRequest(){
        return inRequest;
    }

}
