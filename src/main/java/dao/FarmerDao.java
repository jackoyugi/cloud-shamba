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

    //UPDATE
    void update (int id, String name, String location, String contacts);


    //DELETE
    void deleteById(int id);
    void clearAllFarmers();
}
