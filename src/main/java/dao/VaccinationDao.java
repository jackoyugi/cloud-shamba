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

    //DELETE
    void deleteById(int id);
    void clearAllVaccinations();
}
