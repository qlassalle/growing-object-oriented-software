package auctionsniper;

import java.util.Objects;

public class SniperState {
    private String itemId;
    private int price;
    private int bid;

    public SniperState(String itemId, int price, int bid) {
        this.itemId = itemId;
        this.price = price;
        this.bid = bid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SniperState that = (SniperState) o;
        return price == that.price && bid == that.bid && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, price, bid);
    }

    @Override
    public String toString() {
        return "SniperState{" + "itemId='" + itemId + '\'' + ", price=" + price + ", bid=" + bid + '}';
    }
}
