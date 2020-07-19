package models;

import java.util.Objects;

public class Diagnosis {
    private  String sex;
    private String age;
    private String breed;
    private String location;
    private String clinical_signs;
    private int herd_number;
    private int number_sick;
    private int number_dead;
    private String photo_url;

    public Diagnosis (String sex, String age, String clinical_signs, int herd_number, int number_sick, int number_dead){
        this. sex = sex;
        this.age = age;
        this.breed = "no breed listed";
        this.location = "no location listed";
        this.clinical_signs = clinical_signs;
        this.herd_number = herd_number;
        this.number_dead = number_dead;
        this.number_sick = number_sick;
        this.photo_url = "no photo_url listed";
    }

    public Diagnosis(String sex, String age, String breed, String location, String clinical_signs, int herd_number, int number_sick, int number_dead, String photo_url){
        this. sex = sex;
        this.age = age;
        this.breed = breed;
        this.location = location;
        this.clinical_signs = clinical_signs;
        this.herd_number = herd_number;
        this.number_dead = number_dead;
        this.number_sick = number_sick;
        this.photo_url = photo_url;

    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClinical_signs() {
        return clinical_signs;
    }

    public void setClinical_signs(String clinical_signs) {
        this.clinical_signs = clinical_signs;
    }

    public int getHerd_number() {
        return herd_number;
    }

    public void setHerd_number(int herd_number) {
        this.herd_number = herd_number;
    }

    public int getNumber_sick() {
        return number_sick;
    }

    public void setNumber_sick(int number_sick) {
        this.number_sick = number_sick;
    }

    public int getNumber_dead() {
        return number_dead;
    }

    public void setNumber_dead(int number_dead) {
        this.number_dead = number_dead;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnosis)) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return getHerd_number() == diagnosis.getHerd_number() &&
                getNumber_sick() == diagnosis.getNumber_sick() &&
                getNumber_dead() == diagnosis.getNumber_dead() &&
                getSex().equals(diagnosis.getSex()) &&
                getAge().equals(diagnosis.getAge()) &&
                getBreed().equals(diagnosis.getBreed()) &&
                getLocation().equals(diagnosis.getLocation()) &&
                getClinical_signs().equals(diagnosis.getClinical_signs()) &&
                getPhoto_url().equals(diagnosis.getPhoto_url());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSex(), getAge(), getBreed(), getLocation(), getClinical_signs(), getHerd_number(), getNumber_sick(), getNumber_dead(), getPhoto_url());
    }
}
