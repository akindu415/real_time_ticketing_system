import java.util.List;
import java.util.logging.Logger;

public class Vendor extends User{
//    variable to identify how many tickets vendor releases into the ticketpool;
    private int ticketsPerRelease;

    public Vendor(int userID,String name, TicketPool ticketPool, int actionInterval,int ticketsPerRelease){
        super(userID,name,ticketPool,actionInterval);
        this.ticketsPerRelease = ticketsPerRelease;
    }

    public int getTicketsPerRelease(){
        return ticketsPerRelease;
    }

    @Override
    public void performAction(){

    }


}