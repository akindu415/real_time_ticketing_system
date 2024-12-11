public class Customer extends User{
    private int customerRetrieval_rate;

    public Customer(int userId,TicketPool ticketPool,int actioninterval){
        super(userId,ticketPool,actioninterval);
    }

    public int getCustomerRetrieval_rate(){
        return customerRetrieval_rate;
    }
    @Override
    public void performAction(){
        if (getTicketPool().getRemainingTickets() <= 0) {
            Thread.currentThread().interrupt();
            return;
        }

        Ticket ticket = getTicketPool().removeTicket();
        if (ticket != null){
            System.out.println("Ticket "+ ticket.getTicketId() +" is retrieved by customer "+ getUserId());
        }else {
            System.out.println("customer " + getUserId()+ " found no tickets");
        }
    }
}

