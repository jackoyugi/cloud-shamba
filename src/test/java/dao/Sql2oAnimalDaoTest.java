package dao;

import models.Animal;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;


public class Sql2oAnimalDaoTest {
    private Sql2oAnimalDao animalDao;
    private Connection conn;

    @Before
public void setUp() throws Exception {
    String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
    String connectingString= "jdbc:postgresql://localhost:5432/cloud_shamba_test";
    Sql2o sql2o = new Sql2o(connectingString, "jackoyugi", "00100");
    animalDao = new Sql2oAnimalDao(sql2o);
    conn = sql2o.open();
}

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingAnimalSetsId() {
        Animal animal = new Animal("cow");
        int originalAnimalId = animal.getId();
        animalDao.add(animal);
        assertNotEquals(originalAnimalId, animal.getId());
    }

    @Test
    public void addedAnimalsAreReturnedFromGetAll() throws Exception {
        Animal animal = new Animal("cow");
        animalDao.add(animal);
        assertEquals(1, animalDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesAnimal() {
        Animal animal = new Animal("cow");
        animalDao.add(animal);
        animalDao.deleteById(animal.getId());
        assertEquals(0,animalDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllAnimals() {
        Animal animal = new Animal("cow");
        Animal otherAnimal = new Animal("goat");
        animalDao.add(animal);
        animalDao.add(otherAnimal);
        int daoSize = animalDao.getAll().size();
        animalDao.clearAllAnimals();
        assertTrue(daoSize > 0 && daoSize > animalDao.getAll().size());
    }
}