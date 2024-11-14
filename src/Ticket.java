import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
//   Prevents from multiple threads reading at the same time
    private static final AtomicInteger  idCounter = new AtomicInteger(0);
    private final int ticketId;

    public Ticket(){
//        generates a unique ticket id
        this.ticketId = idCounter.incrementAndGet();//automatically increments by 1
    }

    public int getTicketId(){
        return ticketId;
    }
}
