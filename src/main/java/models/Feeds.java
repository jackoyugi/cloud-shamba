package models;

import java.util.Objects;

public class Feeds {
    private String feed_type;
    private String location;
    private int price;
    private int quantity;

    public Feeds(String feed_type, String location, int price, int quantity){
        this.location=location;
        this.feed_type=feed_type;
        this.price=price;
        this.quantity=quantity;
    }

    public String getFeed_type() {
        return feed_type;
    }

    public void setFeed_type(String feed_type) {
        this.feed_type = feed_type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feeds)) return false;
        Feeds feeds = (Feeds) o;
        return getPrice() == feeds.getPrice() &&
                getFeed_type().equals(feeds.getFeed_type()) &&
                getLocation().equals(feeds.getLocation())&&
                getQuantity()==feeds.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFeed_type(), getLocation(), getPrice(), getQuantity());
    }
}
