public class Customer extends User{
    private int customerRetrieval_rate;

    public Customer(int userId,String name,int customerRetrieval_rate,TicketPool ticketPool,int actioninterval){
        super(userId,name,ticketPool, actioninterval);
        this.customerRetrieval_rate = customerRetrieval_rate;
    }

    public int getCustomerRetrieval_rate(){
        return customerRetrieval_rate;
    }
    @Override
    public void performAction(){
        Ticket ticket = getTicketPool().removeTicket();
    }
}

