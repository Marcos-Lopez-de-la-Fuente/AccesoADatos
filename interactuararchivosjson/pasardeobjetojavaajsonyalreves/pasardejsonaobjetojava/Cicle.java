package interactuararchivosjson.pasardeobjetojavaajsonyalreves.pasardejsonaobjetojava;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONObject;

import com.google.gson.Gson;

public class Cicle {
    private String tipus;
    private String codi;
    private String sigles;
    private String nom;
    private ArrayList<Curs> cursos;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Cicle [tipus=" + tipus + ", codi=" + codi + ", sigles=" + sigles + ", nom=" + nom + ", cursos=" + cursos
                + "]";
    }

}
