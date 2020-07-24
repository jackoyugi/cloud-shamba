package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getId() {
        Animal testAnimal = setupAnimal();
        assertEquals(0, testAnimal.getId());
    }

    @Test
    public void setId() {
        Animal testAnimal = setupAnimal();
        testAnimal.setId(1);
        assertEquals(1, testAnimal.getId());
    }

    @Test
    public void getAnimal_type() {
        Animal testAnimal = setupAnimal();
        assertEquals("animals", testAnimal.getAnimal_type());
    }

    @Test
    public void setAnimal_type() {
        Animal testAnimal = setupAnimal();
        testAnimal.setAnimal_type("animals");
        assertNotEquals("Kuku", testAnimal.getAnimal_type());
    }

    public Animal setupAnimal(){
        return new Animal("animals");
    }
}