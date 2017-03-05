public class Users {
    private String email;
    private String userPass;
    private int balance;

    public Users(String email, String userPass, int balance) {
        this.email = email;
        this.userPass = userPass;
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public String getUserPass() {
        return userPass;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Users{" + "email=" + email + ", userPass=" + userPass + ", balance=" + balance + '}';
    }
    
    
    
}
