public class AuctionOrganizer {
  
    public void createNewAuction(AuctionSystem auctionSystem, Auction auction) {
        auctionSystem.addAuction(auction);
    }

    public void deleteAuction(AuctionSystem auctionSystem, Auction auction) {
        auctionSystem.deleteAuction(auction);
    }
}
