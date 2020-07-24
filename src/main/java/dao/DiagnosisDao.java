package dao;

import models.Diagnosis;

import java.util.List;

public interface DiagnosisDao {

    //LIST
    List<Diagnosis> getAll();

    //CREATE
    void add(Diagnosis diagnosis);

    //READ
    Diagnosis findById(int id);

    //UPDATE
    void update(int id, String sex, String age, String breed, String location, String clinical_signs, int herd_number, int number_sick, int number_dead, String photo_url);

    //DELETE
    void deleteById(int id);
    void clearAllDiagnosis();
}
