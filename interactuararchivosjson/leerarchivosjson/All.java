package interactuararchivosjson.leerarchivosjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class All {
    private static final String ruta = "./interactuararchivosjson/leerarchivosjson/matricula.json";

    public static void leerObj(JSONObject jsonObj) {
        Set<String> keys = jsonObj.keySet();

        for (String string : keys) {

            if (!(jsonObj.get(string) instanceof JSONArray) && !(jsonObj.get(string) instanceof JSONObject)) {
                System.out.println(string.toUpperCase() + ": " + jsonObj.get(string));
            } else if (jsonObj.get(string) instanceof JSONObject) {
                System.out.println("---------" + string.toUpperCase() + "----------");
                leerObj(jsonObj.getJSONObject(string));

            } else if (jsonObj.get(string) instanceof JSONArray) {
                System.out.println(string);

                JSONArray obj = jsonObj.getJSONArray(string);
                for (int i = 0; i < obj.length(); i++) {

                    leerObj(obj.getJSONObject(i));
                    System.out.println("----");
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        String stringFicheroJSON = new String(Files.readAllBytes(Paths.get(ruta)));
        JSONObject jsonObj = new JSONObject(stringFicheroJSON);
        leerObj(jsonObj);
    }
}
