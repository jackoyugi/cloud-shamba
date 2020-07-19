package models;

import java.util.Objects;

public class Animal {
    private int id;
    private String animal_type;

    public Animal (String animal_type) {
        this.animal_type = animal_type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String kuku) {
        this.animal_type = animal_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getId() == animal.getId() &&
                getAnimal_type().equals(animal.getAnimal_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnimal_type());
    }


}
