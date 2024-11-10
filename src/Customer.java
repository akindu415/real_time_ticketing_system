public class Customer extends User{
    private int customerRetrieval_rate;

    public Customer(int userId,String name,int customerRetrieval_rate){
        super(userId, name);
        this.customerRetrieval_rate = customerRetrieval_rate;
    }
}

