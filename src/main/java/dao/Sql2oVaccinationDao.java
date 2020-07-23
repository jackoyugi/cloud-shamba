package dao;

import models.Vaccination;
import org.sql2o.*;

import java.util.List;

public class Sql2oVaccinationDao implements VaccinationDao{

    private final Sql2o sql2o;

    public Sql2oVaccinationDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Vaccination vaccination) {
        String sql = "INSERT INTO vaccinations (vaccination_programme, flock_number) VALUES (:vaccination_programme, :flock_number)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(vaccination)
                    .executeUpdate()
                    .getKey();
            vaccination.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Vaccination> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM vaccinations")
                    .executeAndFetch(Vaccination.class);
        }
    }

    @Override
    public Vaccination findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM vaccinations WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Vaccination.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from vaccinations WHERE id = :id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllVaccinations() {
        String sql = "DELETE from vacations";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
