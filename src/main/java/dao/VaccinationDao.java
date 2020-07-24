package dao;

import models.Vaccination;

import java.util.List;

public interface VaccinationDao {

    //LIST
    List<Vaccination> getAll();

    //CREATE
    void add(Vaccination vaccination);

    //READ
    Vaccination findById(int id);

    //UPDATE
    void update (int id, String vaccination_programme, int flock_number);

    //DELETE
    void deleteById(int id);
    void clearAllVaccinations();
}
