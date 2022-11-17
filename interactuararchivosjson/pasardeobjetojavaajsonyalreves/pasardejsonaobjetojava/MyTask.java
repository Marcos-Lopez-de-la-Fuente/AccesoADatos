package interactuararchivosjson.pasardeobjetojavaajsonyalreves.pasardejsonaobjetojava;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyTask {
    public static void main(String[] args) {
        Cicle cicle = pasarDeJsonAObjetoJava(
                "./interactuararchivosjson/pasardeobjetojavaajsonyalreves/pasardejsonaobjetojava/matricula.json");

        System.out.println(cicle.toString());

        pasarDeObjetoJavaAJson(cicle);
    }

    public static Cicle pasarDeJsonAObjetoJava(String pathFileJSON) {
        String stringFileJSON = "";

        try {
            stringFileJSON = new String(
                    Files.readAllBytes(Paths.get(pathFileJSON)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(stringFileJSON);

        JSONObject cicleObject = jsonObject.getJSONObject("cicle");

        Gson gson = new Gson();

        Cicle cicle = gson.fromJson(cicleObject.toString(), Cicle.class);

        return cicle;
    }

    public static void pasarDeObjetoJavaAJson(Cicle cicle) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String stringJson = gson.toJson(cicle);

        try {
            FileWriter file = new FileWriter(
                    "./interactuararchivosjson/pasardeobjetojavaajsonyalreves/pasardejsonaobjetojava/newMatricula.json");
            file.write(stringJson);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
