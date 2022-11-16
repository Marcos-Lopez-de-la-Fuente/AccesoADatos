package interactuararchivosjson.pasardeobjetojavaajsonyalreves.pasardejsonaobjetojava;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MyTask {
    public static void main(String[] args) {
        String stringFileJSON = "";
        try {
            stringFileJSON = new String(
                    Files.readAllBytes(Paths.get(
                            "./interactuararchivosjson/pasardeobjetojavaajsonyalreves/pasardejsonaobjetojava/newMatricula.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(stringFileJSON);

        JSONObject cicleObject = jsonObject.getJSONObject("cicle");

        Gson gson = new Gson();

        Cicle cicle = gson.fromJson(cicleObject.toString(), Cicle.class);

        JSONObject jsonObject2 = new JSONObject(cicle.toString());
        System.out.println(jsonObject2.toString(4));
    }



    private void pasarDeJSonAObjetoJava() {

    }
}
