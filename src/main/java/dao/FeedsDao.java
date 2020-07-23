package dao;


import models.Feeds;

import java.util.List;

public interface FeedsDao {

    //LIST
    List<Feeds> getAll();

    //CREATE
    void add(Feeds feeds);


    //READ
    Feeds findById(int id);

    //DELETE
    void deleteById(int id);
    void clearAllHeroes();
}
