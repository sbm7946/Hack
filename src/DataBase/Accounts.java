package DataBase;
import java.io.Serializable;
import java.util.HashMap;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Accounts implements Serializable{
    private static final String SAVED_ACCOUNTS_FILE_NAME = "accounts.dat";

    
    static HashMap<String, Long> accountsList;
    private static Accounts accounts_instance;

    private Accounts(){

        accountsList = loadAccounts();
    }

    public static Accounts getInstance(){
        if (accounts_instance == null){
            return new Accounts();
        }

        return accounts_instance;

    }


    


    public boolean addAccount(User user){
        if (accountsList.containsKey(user.getEmail())){
            //output email already exists
            return false;
        }
        accountsList.put(user.getEmail(), user.getPasswordhash());

        return true;
    }

    public boolean checkPassword(String userEmail, Long userPasswordhash){
        if (!accountsList.containsKey(userEmail)){
            //account does not exist
            return false;
        }

        return accountsList.get(userEmail).equals(userPasswordhash);
    }


    public void saveAccounts(){
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(SAVED_ACCOUNTS_FILE_NAME))){
            o.writeObject(accountsList);
        }
        catch(Exception e){
            System.out.println("Could not save accounts.");
        }
    }

    public HashMap<String, Long> loadAccounts(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVED_ACCOUNTS_FILE_NAME))) {
            
            return (HashMap<String, Long>) in.readObject();
        }
        catch(Exception e){

            //if file not found.
            return new HashMap<>();
        }
    }


    public boolean accountExists(String userEmail){
        return accountsList.containsKey(userEmail);
    }
}
