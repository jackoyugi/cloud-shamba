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
        int originalVaccinationId = vaccination.getId(0);
        vaccinationDao.add(vaccination);
        assertNotEquals(originalVaccinationId, vaccination.getId(1));
    }
}