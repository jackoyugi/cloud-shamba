package dao;

import models.Farmer;

import java.util.List;

public interface FarmerDao {

    //LIST
    List<Farmer> getAll();

    //CREATE
    void add(Farmer farmer);

    //READ
    Farmer findById(int id);

    //DELETE
    void deleteById(int id);
    void clearAllFarmers();
}
