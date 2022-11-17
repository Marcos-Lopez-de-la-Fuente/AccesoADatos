package interactuararchivosjson.pasardeobjetojavaajsonyalreves.pasardejsonaobjetojava;

import java.util.ArrayList;

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
