import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Vendor extends User{
//    variable to identify how many tickets vendor releases into the ticketpool;
    private int ticketsPerRelease;

    public Vendor(int userID, TicketPool ticketPool, int actionInterval,int ticketsPerRelease){
        super(userID,ticketPool,actionInterval);
        this.ticketsPerRelease = ticketsPerRelease;
    }

    public int getTicketsPerRelease(){
        return ticketsPerRelease;
    }

    @Override
    public void performAction() {
        if (getTicketPool().getRemainingTickets() <= 0) {
            Thread.currentThread().interrupt();
            return;
        }

        List<Ticket> newTickets = createTickets(ticketsPerRelease);
        getTicketPool().addTickets(newTickets);
        System.out.println("Vendor  "+ getUserId() + " released " + ticketsPerRelease + " tickets");
    }

    private List<Ticket> createTickets(int count) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket());
        }
        return tickets;
    }


}