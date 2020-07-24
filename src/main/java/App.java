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
import org.sql2o.Sql2o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
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
    }


}
