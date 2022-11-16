package interactuararchivosjson.leerarchivosjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import org.json.*; // Librería importada localmente

public class LeerJSONs {
    public void printJSON(String pathFileJSON) {
        String stringFileJSON = "";
        try {
            stringFileJSON = new String(
                    Files.readAllBytes(Paths.get(pathFileJSON)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject firstJsonObject = new JSONObject(stringFileJSON);
        Set<String> arrJsonObject = firstJsonObject.keySet();

        for (String jsonObjectString : arrJsonObject) {
            if (firstJsonObject.get(jsonObjectString) instanceof JSONObject) {
                System.out.println(1);
                System.out.println(jsonObjectString);

                /////////////////////////////////
                JSONObject jsonObject2 = firstJsonObject.getJSONObject(jsonObjectString);
                Set<String> arrJsonObject2 = jsonObject2.keySet();

                for (String jsonObjectString2 : arrJsonObject2) {
                    if (jsonObject2.get(jsonObjectString2) instanceof JSONObject) {
                        System.out.println(11);
                        System.out.println(jsonObjectString2);

                    } else if (jsonObject2.get(jsonObjectString2) instanceof JSONArray) {
                        System.out.println(22);
                        System.out.println(jsonObjectString2);
                        //////////////////////////////////////////////////

                        JSONArray arrJsonObject3 = jsonObject2.getJSONArray(jsonObjectString2);

                        for (int i = 0; i < arrJsonObject3.length(); i++) {

                            if (arrJsonObject3.get(i) instanceof JSONObject) {
                                System.out.println(111);
                                System.out.println(arrJsonObject3.get(i));

                                JSONObject jsonObject4 = (JSONObject) arrJsonObject3.get(i);
                                Set<String> arrJsonObject4 = jsonObject4.keySet();

                                for (String jsonObjectString4 : arrJsonObject4) {

                                    if (jsonObject4.get(jsonObjectString4) instanceof JSONObject) {

                                        System.out.println(1111);
                                        System.out.println(jsonObjectString4);

                                    } else if (jsonObject4.get(jsonObjectString4) instanceof JSONArray) {
                                        System.out.println(2222);
                                        System.out.println(jsonObjectString4);

                                    } else {
                                        System.out.println(
                                                jsonObjectString4 + " --> " + jsonObject4.getInt(jsonObjectString4));
                                    }
                                }

                            } else if (arrJsonObject3.get(i) instanceof JSONArray) {
                                System.out.println(222);
                                System.out.println(arrJsonObject3.get(i));
                            } else {
                                System.out.println("a");
                                System.out.println(arrJsonObject3.get(i));
                            }
                        }

                    } else {
                        System.out.println(jsonObjectString2 + " --> " + jsonObject2.getString(jsonObjectString2));
                    }

                }
            } else if (firstJsonObject.get(jsonObjectString) instanceof JSONArray) {
                System.out.println(2);
                System.out.println(jsonObjectString);

            } else {
                System.out.println(jsonObjectString + " --> " + firstJsonObject.getString(jsonObjectString));
            }

        }

    }

}
