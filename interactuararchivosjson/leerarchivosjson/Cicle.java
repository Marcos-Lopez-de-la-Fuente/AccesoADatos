package interactuararchivosjson.leerarchivosjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Cicle {
    private String tipus;
    private String codi;
    private String sigles;
    private String nom;
//    private List<String> skilltree;


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Cicle [tipus=" + tipus + ", codi=" + codi + ", sigles=" + sigles + ", nom=" + nom + "]";
    }

    public static void main(String[] args) {
        String stringFileJSON = "";
        try {
            stringFileJSON = new String(
                    Files.readAllBytes(Paths.get("./interactuararchivosjson/leerarchivosjson/matricula.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialization into the `Employee` class
        Cicle cicle = new Cicle();
        try {
            cicle = objectMapper.readValue(stringFileJSON, Cicle.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            System.out.println("aaaa");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        // Print information
        System.out.println("1111: " + cicle.toString());

    }
}
