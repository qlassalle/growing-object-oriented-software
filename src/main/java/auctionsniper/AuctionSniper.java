package auctionsniper;

public class AuctionSniper implements AuctionEventListener {

    private final Auction auction;
    private final SniperListener listener;
    private boolean isWinning = false;
    private String itemId;

    public AuctionSniper(Auction auction, SniperListener sniperListener, String itemId) {
        this.auction = auction;
        this.listener = sniperListener;
        this.itemId = itemId;
    }

    @Override
    public void auctionClosed() {
        if (isWinning) {
            listener.sniperWon();
        } else {
            listener.sniperLost();
        }
    }

    @Override
    public void currentPrice(int price, int increment, PriceSource priceSource) {
        isWinning = priceSource == (PriceSource.FromSniper);
        if (isWinning) {
            listener.sniperWinning();
        } else {
            int bid = price + increment;
            auction.bid(bid);
            listener.sniperBidding(new SniperState(itemId, price, bid));
        }
    }
}
