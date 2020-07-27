import com.google.gson.Gson;
import dao.*;
//import models.Animal;
//import models.Diagnosis;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.Animal.animals;
import static spark.Spark.*;
import static spark.Spark.get;

public class App {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        Integer port;

        if (processBuilder.environment().get("PORT") != null) {
            port = Integer.parseInt(processBuilder.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);
//        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        port(port);

        Sql2oAnimalDao animalDao;
        Sql2oDiagnosisDao diagnosisDao;
        Sql2oFarmerDao farmerDao;
        Sql2oFeedsDao feedsDao;
        Sql2oVaccinationDao vaccinationDao;
//        Connection conn;
        Gson gson = new Gson();

//        String connectingString = "jdbc:postgresql://localhost:5432/cloud_shamba";
//        Sql2o sql2o = new Sql2o(connectingString,"jackoyugi","00100");
//        animalDao = new Sql2oAnimalDao(sql2o);
//        diagnosisDao = new Sql2oDiagnosisDao(sql2o);
//        farmerDao = new Sql2oFarmerDao(sql2o);
//        feedsDao = new Sql2oFeedsDao(sql2o);
//        vaccinationDao = new Sql2oVaccinationDao(sql2o);
//        conn = sql2o.open();

//        get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/animals/new", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "animal-form.hbs");
//        }, new HandlebarsTemplateEngine());

//        //show diagnosis form
//        get("/diagnosis/new", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            List< Diagnosis > diagnoses = diagnosisDao.getAll();
//            model.put("diagnoses", diagnoses);
//            return new ModelAndView(model, "diagnosis-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //process diagnosis form
//        post("/diagnosis", (request, response) -> { //new
//            Map<String, Object> model = new HashMap<>();
//            String sex = request.queryParams("sex");
//            String age = request.queryParams("age");
//            String breed = request.queryParams("breed");
//            String location = request.queryParams("location");
//            String clinical_signs = request.queryParams("clinical_signs");
//            int herd_number = Integer.parseInt(request.queryParams("herd_number"));
//            int number_dead = Integer.parseInt(request.queryParams("number_dead"));
//            int number_sick = Integer.parseInt(request.queryParams("number_sick"));
//            String photo_url=request.queryParams("photo_url");
//            Diagnosis newDiagnosis = new Diagnosis(sex, age, breed, location, clinical_signs, herd_number, number_dead, number_sick, photo_url);
//            diagnosisDao.add(newDiagnosis);
//            response.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());








    }


}
