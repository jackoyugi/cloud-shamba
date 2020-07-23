package dao;

import models.Feeds;
import org.sql2o.*;

import java.util.List;

public class Sql2oFeedsDao implements FeedsDao{
    private final Sql2o sql2o;

    public Sql2oFeedsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Feeds feeds) {
        String sql = "INSERT INTO feeds (feed_type, location, price, quantity) VALUES (:feed_type, :location, :price, :quantity)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(feeds)
                    .executeUpdate()
                    .getKey();
            feeds.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Feeds> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM feeds")
                    .executeAndFetch(Feeds.class);
        }
    }

    @Override
    public Feeds findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM feeds WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Feeds.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from feeds WHERE id = :id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllFeeds() {
        String sql = "DELETE from feeds";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
