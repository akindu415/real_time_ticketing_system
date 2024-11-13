public abstract class User implements Runnable {
    private int userId;
    private String name;
    private TicketPool ticketPool;
    private int actionInterval;

//    constructors
    public User(int userId,String name,TicketPool ticketPool, int actionInterval){
        this.userId = userId;
        this.name = name;
        this.ticketPool = ticketPool;
        this.actionInterval = actionInterval;
    }

//    implementing getters for user
    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public TicketPool getTicketPool(){
        return ticketPool;
    }

    public int getActionInterval(){
        return actionInterval;
    }
//this must be used in every class extened to user
   public abstract void performAction();

    @Override
    public void run(){
//        the loop continues until the thread is interrupted
        while(!Thread.currentThread().isInterrupted()){
            performAction();
        }
        try{
//            pause for the specified interval
            Thread.sleep(actionInterval);
        } catch (InterruptedException e) {
//            restore the interrupted status and exit the loop
            Thread.currentThread().interrupt();
        }
    }

}
