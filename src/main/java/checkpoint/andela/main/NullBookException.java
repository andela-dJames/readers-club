package checkpoint.andela.main;

/**
 * Created by Daniel James on 10/1/2015.
 */
public class NullBookException extends Exception {
    private int isbNumber;
    public NullBookException(int  n) {
        isbNumber= n;

    }


}
