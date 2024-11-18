import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TicketPool {
    private  final Queue<Ticket> ticketQueue = new LinkedList<>();
    private final int maxCapacity;// maximum number of tickets that the ticket queue can hold

    public TicketPool(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }


    public synchronized void addTickets(List<Ticket> tickets){
        while(ticketQueue.size() + tickets.size() > maxCapacity){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        ticketQueue.addAll(tickets);
        notifyAll(); // calls the waiting customers to check for available tickets
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
}
