import java.util.Date;

public class Auction {
    private String title;
    private Date startTime;
    private Date endTime;
    private int numberOfItems;

    public Auction(String title, Date startTime, Date endTime, int numberOfItems) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfItems = numberOfItems;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", numberOfItems=" + numberOfItems +
                '}';
    }

    public static void main(String[] args) {
        Date startTime = new Date();  // Replace this with your actual start time
        Date endTime = new Date(startTime.getTime() + 3600000); // Add 1 hour to start time
        Auction auction = new Auction("Auction 1", startTime, endTime, 10);
        System.out.println(auction);
    }
}