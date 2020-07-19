package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiagnosisTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSex() {
        Diagnosis testAnimal = setupDiagnosist();
        assertEquals("f", testAnimal.getSex());
    }

    @Test
    public void setSex() {
        Diagnosis testAnimal = setupDiagnosist();
        testAnimal.setSex("f");
        assertNotEquals("m", testAnimal.getSex());

    }

    @Test
    public void getAge() {
        Diagnosis testAnimal = setupDiagnosist();
        assertEquals("2 weeks old", testAnimal.getAge());
    }

    @Test
    public void setAge() {
        Diagnosis testAnimal = setupDiagnosist();
        testAnimal.setAge("2 weeks old");
        assertNotEquals("1 month old", testAnimal.getAge());
    }

    @Test
    public void getBreed() {
        Diagnosis testAnimal = setupAltRestaurant();
        assertEquals("layers", testAnimal.getBreed());
    }

    @Test
    public void setBreed() {
        Diagnosis testAnimal = setupAltRestaurant();
        testAnimal.setBreed("layers");
        assertNotEquals("broilers", testAnimal.getBreed());
    }

    @Test
    public void getLocation() {
        Diagnosis testAnimal = setupAltRestaurant();
        assertEquals("kiambu", testAnimal.getLocation());
    }

    @Test
    public void setLocation() {
        Diagnosis testAnimal = setupAltRestaurant();
        testAnimal.setLocation("kiambu");
        assertNotEquals("muranga", testAnimal.getLocation());
    }

    @Test
    public void getClinical_signs() {
        Diagnosis testAnimal = setupDiagnosist();
        assertEquals("diarrhorearing", testAnimal.getClinical_signs());
    }

    @Test
    public void setClinical_signs() {
        Diagnosis testAnimal = setupDiagnosist();
        testAnimal.setClinical_signs("diarrhorearing");
        assertNotEquals("running nose", testAnimal.getClinical_signs());
    }

    @Test
    public void getHerd_number() {
        Diagnosis testAnimal = setupDiagnosist();
        assertEquals(100, testAnimal.getHerd_number());
    }

    @Test
    public void setHerd_number() {
        Diagnosis testAnimal = setupDiagnosist();
        testAnimal.setHerd_number(100);
        assertNotEquals(200, testAnimal.getHerd_number());
    }

    @Test
    public void getNumber_sick() {
        Diagnosis testAnimal = setupDiagnosist();
        assertEquals(20, testAnimal.getNumber_sick());
    }

    @Test
    public void setNumber_sick() {
        Diagnosis testAnimal = setupDiagnosist();
        testAnimal.setNumber_sick(20);
        assertNotEquals(15, testAnimal.getNumber_sick());
    }

    @Test
    public void getNumber_dead() {
        Diagnosis testAnimal = setupDiagnosist();
        assertEquals(10, testAnimal.getNumber_dead());
    }

    @Test
    public void setNumber_dead() {
        Diagnosis testAnimal = setupDiagnosist();
        testAnimal.setNumber_dead(10);
        assertNotEquals(5, testAnimal.getNumber_dead());
    }

    @Test
    public void getPhoto_url() {
        Diagnosis testAnimal = setupAltRestaurant();
        assertEquals("http//sick_animal", testAnimal.getPhoto_url());
    }

    @Test
    public void setPhoto_url() {
        Diagnosis testAnimal = setupAltRestaurant();
        testAnimal.setPhoto_url("http//sick_animal");
        assertNotEquals("http//sick_cow", testAnimal.getPhoto_url());
    }

    public Diagnosis setupDiagnosist (){
        return new Diagnosis("f", "2 weeks old", "diarrhorearing", 100, 20, 10);
    }

    public Diagnosis setupAltRestaurant (){
        return new Diagnosis("f", "2 weeks old", "layers", "kiambu", "diarrhorearing", 100, 20, 10, "http//sick_animal");
    }
}