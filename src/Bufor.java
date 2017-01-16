

/**
 * Created by bkmiecik on 16.01.17.
 */
public class Bufor {
    private int contents;
    private boolean available = false;
    public synchronized int get()
    {
        available = false;
        return contents;
    }
    public synchronized void put(int value)
    {
        contents = value;
        //available = true;
    }
}
