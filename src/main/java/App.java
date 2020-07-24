import models.Animal;
import models.Vaccination;
import models.Feeds;
import models.Farmer;
import models.Diagnosis;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import dao.Sql2oAnimalDao;
import dao.Sql2oDiagnosisDao;
import dao.Sql2oFarmerDao;
import dao.Sql2oFeedsDao;
import dao.Sql2oVaccinationDao;
import org.sql2o.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.get;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/cloud_shamba.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oAnimalDao animalDao = new Sql2oAnimalDao(sql2o);
        Sql2oDiagnosisDao diagnosisDao = new Sql2oDiagnosisDao(sql2o);
        Sql2oVaccinationDao vaccinationDao = new Sql2oVaccinationDao(sql2o);
        Sql2oFeedsDao feedsDao = new Sql2oFeedsDao(sql2o);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //show animals form
        get("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Animal> animals = animalDao.getAll();
            model.put("animals", animals);
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        //process animals form
        post("/animals", (request, response) -> { //new
            Map<String, Object> model = new HashMap<>();
            String animal_type = request.queryParams("animal_type");
            Animal newAnimal = new Animal(animal_type);
            animalDao.add(newAnimal);
            response.redirect("/animal.hbs");
            return null;
        }, new HandlebarsTemplateEngine());

        //show diagnosis form
        get("/diagnosis/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Diagnosis> diagnoses = diagnosisDao.getAll();
            model.put("diagnoses", diagnoses);
            return new ModelAndView(model, "diagnosis-form.hbs");
        }, new HandlebarsTemplateEngine());

        //process diagnosis form
        post("/diagnosis", (request, response) -> { //new
            Map<String, Object> model = new HashMap<>();
            String sex = request.queryParams("sex");
            String age = request.queryParams("age");
            String breed = request.queryParams("breed");
            String location = request.queryParams("location");
            String clinical_signs = request.queryParams("clinical_signs");
            int herd_number = Integer.parseInt(request.queryParams("herd_number"));
            int number_dead = Integer.parseInt(request.queryParams("number_dead"));
            int number_sick = Integer.parseInt(request.queryParams("number_sick"));
            String photo_url=request.queryParams("photo_url");
            Diagnosis newDiagnosis = new Diagnosis(sex, age, breed, location, clinical_signs, herd_number, number_dead, number_sick, photo_url);
            diagnosisDao.add(newDiagnosis);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //show vaccination form
        get("/vaccinations/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Vaccination> vaccinations = vaccinationDao.getAll();
            model.put("vaccinations", vaccinations);
            return new ModelAndView(model, "vaccination-form.hbs");
        }, new HandlebarsTemplateEngine());

        //process vaccination form
        post("/vaccinations", (request, response) -> { //new
            Map<String, Object> model = new HashMap<>();
            String vaccination_programme = request.queryParams("vaccination_programme");
            int flock_number = Integer.parseInt(request.queryParams("flock_number"));
            Vaccination newVaccination = new Vaccination(vaccination_programme, flock_number);
            vaccinationDao.add(newVaccination);
            response.redirect("/vaccination.hbs");
            return null;
        }, new HandlebarsTemplateEngine());

        //show feeds form
        get("/feeds/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Feeds> feeds = feedsDao.getAll();
            model.put("feeds", feeds);
            return new ModelAndView(model, "feeds-form.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
