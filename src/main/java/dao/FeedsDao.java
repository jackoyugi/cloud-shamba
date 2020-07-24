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

    //UPDATE
    void update (int id, String feed_type, String location, int price, int quantity);

    //DELETE
    void deleteById(int id);
    void clearAllFeeds();
}
