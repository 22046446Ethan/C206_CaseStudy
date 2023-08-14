import java.util.ArrayList;
import java.util.List;

public class AuctionSystem {
    private List<Auction> auctions = new ArrayList<>();

    public void addAuction(Auction auction) {
        auctions.add(auction);
    }

    public List<Auction> getAllAuctions() {
        return auctions;
    }

    public void deleteAuction(Auction auction) {
        auctions.remove(auction);
    }
}
