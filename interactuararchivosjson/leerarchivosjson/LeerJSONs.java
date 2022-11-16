package interactuararchivosjson.leerarchivosjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import org.json.*; // Librería importada localmente

public class LeerJSONs {

    public void newPrintJSON(String pathFileJSON) {
        String stringFileJSON = "";
        try {
            stringFileJSON = new String(
                    Files.readAllBytes(Paths.get(pathFileJSON)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(stringFileJSON);
        
        this.codeLeerJson(jsonObject);

    }


    public void codeLeerJson(JSONObject jsonObject) {
        Set<String> arrJsonObject = jsonObject.keySet();

        for (String jsonObjectString : arrJsonObject) {
            if (jsonObject.get(jsonObjectString) instanceof JSONObject) {
                this.codeLeerJson((JSONObject) jsonObject.get(jsonObjectString));


            } else if (jsonObject.get(jsonObjectString) instanceof JSONArray) {
                this.arrayLeerJson((JSONArray) jsonObject.get(jsonObjectString));

            } else {
                System.out.println(jsonObjectString + " --> " + jsonObject.getString(jsonObjectString));
            }

        }
    }

    public void arrayLeerJson(JSONArray jsonArray) {
        for (Object jsonObject : jsonArray) {
            if (jsonObject instanceof JSONObject) {
                this.codeLeerJson((JSONObject) jsonObject);

            } else if (jsonObject instanceof JSONArray) {
                this.arrayLeerJson((JSONArray) jsonObject);

            } else {
                System.out.println("CUIDADO: " + jsonObject);
            }
        }

    }

    public static void main(String[] args) {
        String pathFileJSON = "./interactuararchivosjson/leerarchivosjson/matricula.json";
        new LeerJSONs().newPrintJSON(pathFileJSON);
    }

}
