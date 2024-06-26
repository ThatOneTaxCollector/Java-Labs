import java.util.ArrayList;
/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling and braden gerlach.
 * @version 2024.05.31
 */
public class Auction {
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;
     /**
     * Create a new auction.
     */
    public Auction() {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }
    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }
    /**
     * Show the full list of lots in this auction.
     */
    public void showLots() {
        for (Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
     /**
     *  return a list of all the lots without a bid 
     */
    public ArrayList<Lot> getUnsold() {
        ArrayList<Lot> unsold = new ArrayList<>();
        for (Lot lot : lots) {
            Bid bid = lot.getHighestBid();
            if (bid == null) {
                unsold.add(lot);
            }
        }
        return unsold;
    }
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value) {
        Lot selectedLot = getLot(lotNumber);
        if (selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if (successful) {
                System.out.println("The bid for lot number " + lotNumber + " was successful.");
            } else {
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber + " already has a bid of: " + highestBid.getValue());
            }
        }
    }
   /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber) {
        for (Lot lot : lots) {
            if (lot.getNumber() == lotNumber) {
                return lot;
            }
        }
        System.out.println("Lot number: " + lotNumber + " does not exist.");
        return null;
    }

    public void close() {
        for (Lot lot : lots) {
            Bid highestBid = lot.getHighestBid();
            if (highestBid != null) {
                System.out.println("Lot " + lot.getNumber() + " closed. Sold to " + highestBid.getBidder() + " for " + highestBid.getValue());
            } else {
                System.out.println("Lot " + lot.getNumber() + " closed. No bids received.");
            }
        }
    }

    public Lot removeLot(int lotNumber) {
        Lot lotToRemove = null;
        for (Lot lot : lots) {
            if (lot.getNumber() == lotNumber) {
                lotToRemove = lot;
                break;
            }
        }
        if (lotToRemove != null) {
            lots.remove(lotToRemove);
        }
        return lotToRemove;
    }
}
