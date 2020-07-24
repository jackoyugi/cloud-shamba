package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class VaccinationTest {

    @Test
    public void getVaccination_programme() {
        Vaccination testVaccine = setupVaccination();
        assertEquals("poultry vaccine schedule", testVaccine.getVaccination_programme());
    }

    @Test
    public void setVaccination_programme() {
        Vaccination testVaccine = setupVaccination();
        testVaccine.setVaccination_programme("poultry vaccine schedule");
        assertNotEquals("kienyeji vaccine schedule", testVaccine.getVaccination_programme());
    }

    @Test
    public void getFlock_number() {
        Vaccination testVaccine = setupVaccination();
        assertEquals(100, testVaccine.getFlock_number());
    }

    @Test
    public void setFlock_number() {
        Vaccination testVaccine = setupVaccination();
        testVaccine.setFlock_number(100);
        assertNotEquals(200, testVaccine.getFlock_number());
    }

    @Test
    public void getId() {
        Vaccination testVaccine = setupVaccination();
        assertEquals(0, testVaccine.getId(0));
    }

    @Test
    public void setId() {
        Vaccination testVaccine = setupVaccination();
        testVaccine.getId(0);
        assertNotEquals(1, testVaccine.getId(2));
    }
    public Vaccination setupVaccination(){
        return new Vaccination("poultry vaccine schedule", 100);
    }
}