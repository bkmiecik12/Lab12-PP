import java.util.concurrent.Semaphore;

/**
 * Created by bkmiecik on 16.01.17.
 */
public class Producent extends Thread {
    private Bufor buf;
    private int number;
    private static Semaphore sem = new Semaphore(1);

    public Producent(Bufor c, int number)
    { buf = c;
        this.number = number;
    }
    public void run()
    {
        for (int i = 0; i < 10; i++) {
            tryAcquire();
            int y = (int) Math.random() * 4500 + 500;
            buf.put(y);
            sem.release();
        }
    }
    private void tryAcquire() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
