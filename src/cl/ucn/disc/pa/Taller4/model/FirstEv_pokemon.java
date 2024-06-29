package cl.ucn.disc.pa.Taller4.model;

/**
 * The FirstEv_Pokemon
 *
 * @author Paolo Vera Rivera - Bruce Munizaga
 */

public final class FirstEv_pokemon extends Pokemon {
    /**
     * The nextEvolucion
     */
    private String nextEvolucion;
    /**
     * The prevEvolucion;
     */
    private String prevEvolucion;


    /**
     * The Constructor
     *
     * @param id Id del Pokemon
     * @param nombre Nombre del Pokemon
     * @param etapa Etapa del pokemon
     * @param first_tipo Primer tipo del Pokemon
     * @param second_tipo Segundo tipo del Pokemon
     * @param nextEvolucion Evolucion Siguiente del Pokemon
     * @param prevEvolucion Evolucion Previa del Pokemon
     */
    public FirstEv_pokemon(int id, String nombre, String etapa,String nextEvolucion, String prevEvolucion, String first_tipo, String second_tipo) {
        super(id, nombre, etapa, first_tipo, second_tipo);
        this.nextEvolucion = nextEvolucion;
        this.prevEvolucion = prevEvolucion;
    }

    /**
     * @return The Evolucion siguiente
     */
    public String getNextEvolucion() {
        return this.nextEvolucion;
    }

    /**
     * @return The Evolucion anterior
     */
    public String getPrevEvolucion() {
        return this.prevEvolucion;
    }


    public String toString() {
        return super.toString() + "\nSiguiente Evolucion: " + nextEvolucion + "\nEvolucion Previa: " + prevEvolucion;
    }
}


