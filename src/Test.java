import java.util.concurrent.Semaphore;

/**
 * Created by bkmiecik on 16.01.17.
 */
public class Test {
    public static void main(String[] args)
    {
        Bufor c = new Bufor();
        Semaphore s = new Semaphore(1);

        Producent p1 = new Producent(c, 1,s);
        Konsument c1 = new Konsument(c, 1,s);
        Konsument c2 = new Konsument(c, 2,s);
        Konsument c3 = new Konsument(c, 3,s);
        p1.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
