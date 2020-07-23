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

    //DELETE
    void deleteById(int id);
    void clearAllDiagnosis();
}
