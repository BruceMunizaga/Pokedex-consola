package cl.ucn.disc.pa.Taller4.model;

/**
 * The Basic Pokemon
 * @author Paolo Vera Rivera - Bruce Munizaga
 */

public class BasicPokemon extends Pokemon {
    /**
     * The nextEvolucion
     */
    private String nextEvolucion;
    /**
     * The secondEvolucion
     */
    private String secondEvolucion;

    /**
     * The Constructor
     *
     * @param id La Id del Pokemon
     * @param nombre El Nombre del Pokemon
     * @param etapa La Etapa del Pokemon
     * @param nextEvolucion La Siguiente Evolucion del Pokemon
     * @param secondEvolucion La Segunda Evolucion del Pokemon
     * @param first_tipo El Primer tipo del Pokemon
     * @param second_tipo El Segundo tipo del Pokemon
     */
    public BasicPokemon(int id, String nombre, String etapa,String nextEvolucion, String secondEvolucion, String first_tipo, String second_tipo) {
        super(id, nombre, etapa, first_tipo, second_tipo);
        this.nextEvolucion = nextEvolucion;
        this.secondEvolucion = secondEvolucion;
    }

    /**
     * @return La Siguiente Evolucion
     */
    public String getNextEvolucion() {
        return this.nextEvolucion;
    }

    /**
     * @return La Segunda Evolucion
     */
    public String getSecondEvolucion() {
        return this.secondEvolucion;
    }

    /**
     * Metodo toString para que los objetos anotados en las listas sean legibles
     * @return El pokemon transformado a String
     */
    @Override
    public String toString() {
        return super.toString() +"\nSiguiente Evolucion:" + nextEvolucion + "\nSegunda Evolucion: " + secondEvolucion;
    }
}
