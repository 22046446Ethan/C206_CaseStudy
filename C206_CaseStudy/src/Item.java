public class Item {
    private String name;
    private String description;
    private double startingBid;


    public Item(String name, String description, double startingBid) {
        this.name = name;
        this.description = description;
        this.startingBid = startingBid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getStartingBid() {
        return startingBid;
    }
 
}