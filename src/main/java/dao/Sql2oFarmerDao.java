package dao;

import models.Farmer;
import org.sql2o.*;

import java.util.List;

public class Sql2oFarmerDao implements FarmerDao{
    private final Sql2o sql2o;

    public Sql2oFarmerDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Farmer farmer) {
        String sql = "INSERT INTO farmers (name, location, contacts) VALUES (:name, :location, :contacts)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(farmer)
                    .executeUpdate()
                    .getKey();
            farmer.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Farmer> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM farmers")
                    .executeAndFetch(Farmer.class);
        }
    }

    @Override
    public Farmer findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM farmers WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Farmer.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from farmers WHERE id = :id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllFarmers() {
        String sql = "DELETE from farmers";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
