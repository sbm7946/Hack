package DataBase;



public class User {
    

    private String email;
    private long passwordhash;


    public User(String email, String password){
        this.email = email;
        this.passwordhash = hashPassword(password);
    }


    private long hashPassword(String password){
        long hash = 0;
        for (int x = 0; x < password.length(); ++x){
            hash += password.charAt(x);
        }

        return 1;
    }

}
