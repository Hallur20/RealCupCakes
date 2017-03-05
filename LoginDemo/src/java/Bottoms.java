public class Bottoms {
    private String bName;
    private int bPrice;

    public Bottoms(String bName, int bPrice) {
        this.bName = bName;
        this.bPrice = bPrice;
    }

    public String getbName() {
        return bName;
    }

    public int getbPrice() {
        return bPrice;
    }

    @Override
    public String toString() {
        return "Bottoms{" + "bName=" + bName + ", bPrice=" + bPrice + '}';
    }
    
    
}
