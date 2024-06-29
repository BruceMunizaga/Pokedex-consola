package cl.ucn.disc.pa.Taller4.model;

/**
 * The SecondEv_pokemon
 *
 * @author Paolo Vera Rivera - Bruce Munizaga
 */
public final class SecondEv_pokemon extends Pokemon {
    /**
     * The prevEvolucion
     */
    private String prevEvolucion;
    /**
     * The firstEvolucion
     */
    private String firstEvolucion;


    /**
     * The Constructor
     *
     * @param id Id del pokemon
     * @param nombre Nombre del pokemon
     * @param etapa Etapa del pokemon
     * @param prevEvolucion Evolucion previa del Pokemon
     * @param firstEvolucion Primera Forma del Pokemon
     * @param first_tipo Primer tipo del Pokemon
     * @param second_tipo Segundo tipo del Pokemon
     */
    public SecondEv_pokemon(int id, String nombre, String etapa,String prevEvolucion,String firstEvolucion, String first_tipo, String second_tipo) {
        super(id, nombre, etapa, first_tipo, second_tipo);
        this.prevEvolucion = prevEvolucion;
        this.firstEvolucion = firstEvolucion;
    }

    /**
     * @return The Evolucion previa
     */
    public String getPrevEvolucion() {
        return this.prevEvolucion;
    }

    /**
     * @return The Primera Evolucion
     */
    public String getFirstEvolucion() {
        return this.firstEvolucion;
    }

    public String toString() {
        return super.toString() + "\nEvolucion Previa: " + prevEvolucion + "\nPrimera Evolucion: " + firstEvolucion;
    }
}
