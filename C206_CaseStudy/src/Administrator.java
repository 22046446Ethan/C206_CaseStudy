import java.util.List;

public class Administrator {
  
    public void viewAllAuctions(AuctionSystem auctionSystem) {
        List<Auction> auctions = auctionSystem.getAllAuctions();
        for (Auction auction : auctions) {
            System.out.println(auction);
        }
    }
}