package dao;

import models.Diagnosis;
import models.Farmer;
import models.Feeds;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oFeedsDaoTest {
    private Sql2oFeedsDao feedsDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        feedsDao = new Sql2oFeedsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingFeedsSetsId() {
        Feeds feeds = new Feeds("poultry food", "kapenguria", 200, 3);
        int originalFeedsId = feeds.getId();
        feedsDao.add(feeds);
        assertNotEquals(originalFeedsId, feeds.getId());
    }

    @Test
    public void addedFeedsAreReturnedFromGetAll() throws Exception {
        Feeds feeds = new Feeds("poultry food", "kapenguria", 200, 3);
        feedsDao.add(feeds);
        assertEquals(1, feedsDao.getAll().size());
    }

    @Test
    public void updateChangesFeedsContent() throws Exception {
        String initialLocation = "kapenguria";
        Feeds feeds = new Feeds("poultry food", "kapenguria", 200, 3);
        feedsDao.add(feeds);
        feedsDao.update(feeds.getId(),"dog food", "kericho", 300, 4);
        Feeds updatedFeeds = feedsDao.findById(feeds.getId());
        assertNotEquals(initialLocation, updatedFeeds.getLocation());
    }

    @Test
    public void deleteByIdDeletesFeeds() {
        Feeds feeds = new Feeds("poultry food", "kapenguria", 200, 3);
        feedsDao.add(feeds);
        feedsDao.deleteById(feeds.getId());
        assertEquals(0,feedsDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllFeeds() {
        Feeds feeds = new Feeds("poultry food", "kapenguria", 200, 3);
        Feeds otherFeeds = new Feeds("dog food", "kericho", 300, 4);
        feedsDao.add(feeds);
        feedsDao.add(otherFeeds);
        int daoSize = feedsDao.getAll().size();
        feedsDao.clearAllFeeds();
        assertTrue(daoSize > 0 && daoSize > feedsDao.getAll().size());
    }
}