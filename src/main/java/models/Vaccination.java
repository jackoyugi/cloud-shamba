package models;

import java.util.Objects;

public class Vaccination {
    private String vaccination_programme;
    private int flock_number;
    private int id;

    public Vaccination(String vaccination_programme, int flock_number){
        this.vaccination_programme = vaccination_programme;
        this.flock_number = flock_number;
    }

    public String getVaccination_programme() {
        return vaccination_programme;
    }

    public void setVaccination_programme(String vaccination_programme) {
        this.vaccination_programme = vaccination_programme;
    }

    public int getFlock_number() {
        return flock_number;
    }

    public void setFlock_number(int flock_number) {
        this.flock_number = flock_number;
    }

    public int getId(int i) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaccination)) return false;
        Vaccination that = (Vaccination) o;
        return getId(1) == that.getId(1) &&
                getVaccination_programme().equals(that.getVaccination_programme()) &&
                getFlock_number()==(that.getFlock_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVaccination_programme(), getFlock_number(), getId(1));
    }
}
