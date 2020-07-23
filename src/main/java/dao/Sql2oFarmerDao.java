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
    public List<Diagnosis> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM diagnosis")
                    .executeAndFetch(Diagnosis.class);
        }
    }

    @Override
    public Diagnosis findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM diagnosis WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Diagnosis.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from diagnosis WHERE id = :id"; //raw sql
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
        String sql = "DELETE from diagnosis";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
}
