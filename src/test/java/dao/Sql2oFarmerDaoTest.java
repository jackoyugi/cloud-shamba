package dao;

import models.Diagnosis;
import models.Farmer;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oFarmerDaoTest {
    private Sql2oFarmerDao farmerDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        farmerDao = new Sql2oFarmerDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingFarmerSetsId() {
        Farmer farmer = new Farmer("John", "nakuru", "0727396930");
        int originalFarmerId = farmer.getId();
        farmerDao.add(farmer);
        assertNotEquals(originalFarmerId, farmer.getId());
    }

    @Test
    public void addedFarmersAreReturnedFromGetAll() throws Exception {
        Farmer farmer = new Farmer("John", "nakuru", "0727396930");
        farmerDao.add(farmer);
        assertEquals(1, farmerDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesFarmer() {
        Farmer farmer = new Farmer("John", "nakuru", "0727396930");
        farmerDao.add(farmer);
        farmerDao.deleteById(farmer.getId());
        assertEquals(0,farmerDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllFarmers() {
        Farmer farmer = new Farmer("John", "nakuru", "0727396930");
        Farmer otherFarmer = new Farmer("Jane", "nairobi", "0718556386");
        farmerDao.add(farmer);
        farmerDao.add(otherFarmer);
        int daoSize = farmerDao.getAll().size();
        farmerDao.clearAllFarmers();
        assertTrue(daoSize > 0 && daoSize > farmerDao.getAll().size());
    }
}