import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketPool {
    private  final Queue<Ticket> ticketQueue = new LinkedList<>();
    private final int maxCapacity;// maximum number of tickets that the ticket queue can hold
    private final AtomicInteger remainingTickets;

    public TicketPool(int maxCapacity, int totalTickets){
        this.maxCapacity = maxCapacity;
        this.remainingTickets = new AtomicInteger(totalTickets);
    }


    public synchronized void addTickets(List<Ticket> tickets){
        while(ticketQueue.size() + tickets.size() > maxCapacity || remainingTickets.get() <=0){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
        }
        int ticketsToAdd = Math.min(tickets.size(), remainingTickets.get());
        for (int i = 0; i < ticketsToAdd; i++) {
            ticketQueue.add(tickets.get(i));
        }
        remainingTickets.addAndGet(-ticketsToAdd);
        notifyAll();
    }

    public synchronized Ticket removeTicket(){
        while(ticketQueue.isEmpty()){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return null;
            }
        }
        Ticket ticket = ticketQueue.poll();
        notifyAll();
        return ticket;
    }
    public int getRemainingTickets() {
        return remainingTickets.get();
    }
}
