public class Toppings {
    private String tName;
    private int tPrice;

    public Toppings(String tName, int tPrice) {
        this.tName = tName;
        this.tPrice = tPrice;
    }

    public String gettName() {
        return tName;
    }

    public int gettPrice() {
        return tPrice;
    }

    @Override
    public String toString() {
        return "Toppings{" + "tName=" + tName + ", tPrice=" + tPrice + '}';
    }
    
    
    
}
