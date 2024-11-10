public abstract class User {
    private int userId;
    private String name;

    public User(int userId,String name){
        this.userId = userId;
        this.name = name;
    }

    public int getUserId(int userId){
        return userId;
    }

    public String getName(String name){
        return name;
    }

}
