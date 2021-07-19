package auctionsniper;

public class AuctionSniper implements AuctionEventListener {

    private final SniperListener listener;

    public AuctionSniper(SniperListener sniperListener) {
        this.listener = sniperListener;
    }

    @Override
    public void auctionClosed() {
        listener.sniperLost();
    }

    @Override
    public void currentPrice(int price, int increment) {

    }
}
