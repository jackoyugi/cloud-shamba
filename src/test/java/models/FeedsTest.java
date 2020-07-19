package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FeedsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFeed_type() {
        Feeds testFeeds = setupFeeds();
        assertEquals("layers mash", testFeeds.getFeed_type());
    }

    @Test
    public void setFeed_type() {
        Feeds testFeeds = setupFeeds();
        testFeeds.setFeed_type("layers mash");
        assertNotEquals("growers mash", testFeeds.getFeed_type());
    }

    @Test
    public void getLocation() {
        Feeds testFeeds = setupFeeds();
        assertEquals("kiambu", testFeeds.getLocation());
    }

    @Test
    public void setLocation() {
        Feeds testFeeds = setupFeeds();
        testFeeds.setLocation("kiambu");
        assertNotEquals("muranga", testFeeds.getLocation());
    }

    @Test
    public void getPrice() {
        Feeds testFeeds = setupFeeds();
        assertEquals(1500, testFeeds.getPrice());
    }

    @Test
    public void setPrice() {
        Feeds testFeeds = setupFeeds();
        testFeeds.setPrice(1500);
        assertNotEquals(2000, testFeeds.getPrice());
    }

    @Test
    public void getQuantity(){
        Feeds testFeeds = setupFeeds();
        assertEquals(50, testFeeds.getQuantity());

    }
    @Test
    public void setQuantity(){
        Feeds testFeeds = setupFeeds();
        testFeeds.setQuantity(50);
        assertNotEquals(100, testFeeds.getQuantity());
    }

    public Feeds setupFeeds(){
        return new  Feeds("layers mash", "kiambu", 1500, 50);
    }
}