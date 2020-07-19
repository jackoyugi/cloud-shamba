package models;

import java.util.Objects;

public class Farmer {
    private String name;
    private String location;
    private String contacts;
    private int id;


    public Farmer(String name, String location, String contacts){
        this.contacts=contacts;
        this.location=location;
        this.name=name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Farmer)) return false;
        Farmer farmer = (Farmer) o;
        return getId() == farmer.getId() &&
                getName().equals(farmer.getName()) &&
                getLocation().equals(farmer.getLocation()) &&
                getContacts().equals(farmer.getContacts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation(), getContacts(), getId());
    }
}
