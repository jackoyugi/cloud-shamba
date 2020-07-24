package dao;

import models.Diagnosis;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oDiagnosisDaoTest {
    private Sql2oDiagnosisDao diagnosisDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        String connectingString= "jdbc:postgresql://localhost:5432/cloud_shamba_test";
        Sql2o sql2o = new Sql2o(connectingString, "jackoyugi", "00100");
        diagnosisDao = new Sql2oDiagnosisDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingDiagnosisSetsId() {
        Diagnosis diagnosis = new Diagnosis("male", "5", "aberdeen angus", "nakuru", "running nose", 5, 2, 0, "");
        int originalDiagnosisId = diagnosis.getId();
        diagnosisDao.add(diagnosis);
        assertNotEquals(originalDiagnosisId, diagnosis.getId());
    }

    @Test
    public void addedDiagnosisAreReturnedFromGetAll() throws Exception {
        Diagnosis diagnosis = new Diagnosis("male", "5", "aberdeen angus", "nakuru", "running nose", 5, 2, 0, "");
        diagnosisDao.add(diagnosis);
        assertEquals(2, diagnosisDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesDiagnosis() {
        Diagnosis diagnosis = new Diagnosis("male", "5", "aberdeen angus", "nakuru", "running nose", 5, 2, 0, "");
        diagnosisDao.add(diagnosis);
        diagnosisDao.deleteById(diagnosis.getId());
        assertEquals(2, diagnosisDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllDiagnosis() {
        Diagnosis diagnosis = new Diagnosis("male", "5", "aberdeen angus", "nakuru", "running nose", 5, 2, 0, "");
        Diagnosis otherDiagnosis = new Diagnosis("female", "3", "aberdeen angus", "nakuru", "lack of appetite", 2, 1, 0, "");
        diagnosisDao.add(diagnosis);
        diagnosisDao.add(otherDiagnosis);
        int daoSize = diagnosisDao.getAll().size();
        diagnosisDao.clearAllDiagnosis();
        assertTrue(daoSize > 0 && daoSize > diagnosisDao.getAll().size());
    }
}