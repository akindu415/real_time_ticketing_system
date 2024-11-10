public class Vendor extends User{
    private int tickets_To_release;
    private int ticketReleaseRate;

    public Vendor(int tickets_To_release, int ticketReleaseRate, int userID, String name){
        super(userID,name);
        this.tickets_To_release = tickets_To_release;
        this.ticketReleaseRate =ticketReleaseRate;
    }
}