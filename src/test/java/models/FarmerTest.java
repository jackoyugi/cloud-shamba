package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        Farmer testFarmer = setupFarmer();
        assertEquals("Mwangi", testFarmer.getName());
    }

    @Test
    public void setName() {
        Farmer testFarmer = setupFarmer();
        testFarmer.setName("Mwangi");
        assertNotEquals("Mwaura", testFarmer.getName());
    }

    @Test
    public void getLocation() {
        Farmer testFarmer = setupFarmer();
        assertEquals("Kiambu", testFarmer.getLocation());
    }

    @Test
    public void setLocation() {
        Farmer testFarmer = setupFarmer();
        testFarmer.setLocation("Kiambu");
        assertNotEquals("Muranga", testFarmer.getContacts());
    }

    @Test
    public void getContacts() {
        Farmer testFarmer = setupFarmer();
        assertEquals("0000", testFarmer.getContacts());

    }

    @Test
    public void setContacts() {
        Farmer testFarmer = setupFarmer();
        testFarmer.setContacts("0000");
        assertNotEquals("00100", testFarmer.getContacts());
    }

    @Test
    public void getId() {
        Farmer testFarmer = setupFarmer();
        assertEquals(0, testFarmer.getId());
    }

    @Test
    public void setId() {
        Farmer testFarmer = setupFarmer();
        testFarmer.setId(0);
        assertNotEquals(1, testFarmer.getId());
    }

    public Farmer setupFarmer(){
        return new Farmer("Mwangi", "Kiambu", "0000");
    }
}