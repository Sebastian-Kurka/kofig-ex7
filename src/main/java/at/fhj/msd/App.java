package at.fhj.msd;
public class App
{
    public static void main( String[] args )
    {
        StringQueue dq = new StringQueue(3);
        dq.offer("Gin");
        dq.offer("Wein");
        dq.offer("Bier");
    }
}
