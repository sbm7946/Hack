package DataBase;



public class User {
    

    private String email;
    private long passwordhash;


    public User(String email, String password){
        this.email = email;
        this.passwordhash = hash(password);
    }


    private long hash(String password){
        return password.hashCode();
    }

    public String getEmail(){
        return email;
    }

    public long getPasswordhash(){
        return passwordhash;
    }

}
