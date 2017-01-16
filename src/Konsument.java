import java.util.concurrent.Semaphore;

/**
 * Created by bkmiecik on 16.01.17.
 */
public class Konsument extends Thread{
    private Bufor buf;
    private int number;
    private static Semaphore sem;
    public Konsument(Bufor c, int number, Semaphore s)
    { buf = c;
        this.number = number;
        sem=s;
    }
    public void run()
    { int value = 0;
        for (int i = 0; i < 10; i++)
        {
            tryAcquire();
            value = buf.get();
            System.out.println("Konsument " +
                    this.number + " rozpoczął: " + value);

            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }

            System.out.println("Konsument " +
                    this.number + " zakończył " + value);
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
