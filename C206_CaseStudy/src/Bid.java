import java.util.ArrayList;
	import java.util.Comparator;
	import java.util.List;
	import java.util.Collections;

public class Bid {
	
	  private String bidder;
	  private double bidAmount;
	  private AuctionItem item;
	  private List<Bid> bids;

	  public Bid(String bidder, double bidAmount, AuctionItem item) {
	    this.bidder = bidder;
	    this.bidAmount = bidAmount;
	    this.item = item;
	    this.bids = new ArrayList<>();
	  }
	  public AuctionItem getItem() {
	    return item;
	  }

	  public String getBidder() {
	    return bidder;
	  }

	  public double getBidAmount() {
	    return bidAmount;
	  }

	  public List<Bid> getAllBids() {
	    Collections.sort(bids, new Comparator<Bid>() {
	      public int compare(Bid b1, Bid b2) {
	        return Double.compare(b2.getBidAmount(), b1.getBidAmount());
	      }
	    });
	    return bids;
	  }

	  public void setBidder(String bidder) {
	    this.bidder = bidder;
	  }

	  public void setBidAmount(double bidAmount) {
	    this.bidAmount = bidAmount;
	  }

	  public boolean addBid(Bid bid) {
		    double highestAmount = 0.0;
		    // Find the highest bid amount among all existing bids
		    for (Bid existingBid : bids) {
		        if (existingBid.getBidAmount() > highestAmount) {
		            highestAmount = existingBid.getBidAmount();
		        }
		    }
		    if (bid.getBidAmount() > highestAmount) {
		        bids.add(bid);
		        return true; // Bid accepted
		    } else {
		        return false; // Bid not accepted
		    }
		}
	  private boolean addBidToList(List<Bid> bidList, Bid bidToAdd) {
		    double highestAmount = 0.0;
		    // Find the highest bid amount among all existing bids
		    for (Bid existingBid : bidList) {
		        if (existingBid.getBidAmount() > highestAmount) {
		            highestAmount = existingBid.getBidAmount();
		        }
		    }
		    if (bidToAdd.getBidAmount() > highestAmount) {
		        bidList.add(bidToAdd);
		        return true; // Bid accepted
		    } else {
		        return false; // Bid not accepted
		    }
		}

	  public boolean removeBid(Bid bid) {
	    return bids.remove(bid);
	  }
	}

