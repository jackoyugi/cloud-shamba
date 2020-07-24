package dao;

import models.Diagnosis;
import models.Farmer;
import models.Feeds;
import models.Vaccination;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oVaccinationDaoTest {
    private Sql2oVaccinationDao vaccinationDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        vaccinationDao = new Sql2oVaccinationDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingVaccinationSetsId() {
        Vaccination vaccination = new Vaccination("weekly injections",  3);
        int originalVaccinationId = vaccination.getId();
        vaccinationDao.add(vaccination);
        assertNotEquals(originalVaccinationId, vaccination.getId());
    }

    @Test
    public void addedVaccinationAreReturnedFromGetAll() throws Exception {
        Vaccination vaccination = new Vaccination("weekly injections",  3);
        vaccinationDao.add(vaccination);
        assertEquals(1, vaccinationDao.getAll().size());
    }

    @Test
    public void updateChangesVaccinationContent() throws Exception {
        int initialFlockNumber = 3;
        Vaccination vaccination = new Vaccination("weekly injections",  3);
        vaccinationDao.add(vaccination);
        vaccinationDao.update(vaccination.getId(),"daily tablets", 6);
        Vaccination updatedVaccination = vaccinationDao.findById(vaccination.getId());
        assertNotEquals(initialFlockNumber, updatedVaccination.getFlock_number());
    }

    @Test
    public void deleteByIdDeletesVaccinations() {
        Vaccination vaccination = new Vaccination("weekly injections",  3);
        vaccinationDao.add(vaccination);
        vaccinationDao.deleteById(vaccination.getId());
        assertEquals(0,vaccinationDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllVaccinations() {
        Vaccination vaccination = new Vaccination("weekly injections",  3);
        Vaccination otherVaccination = new Vaccination("daily tablets", 6);
        vaccinationDao.add(vaccination);
        vaccinationDao.add(otherVaccination);
        int daoSize = vaccinationDao.getAll().size();
        vaccinationDao.clearAllVaccinations();
        assertTrue(daoSize > 0 && daoSize > vaccinationDao.getAll().size());
    }
}