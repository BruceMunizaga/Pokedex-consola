package cl.ucn.disc.pa.Taller4.model;

/**
 * The Pokemon
 *
 * author @Paolo Vera Rivera - Bruce Munizaga
 */
public abstract class Pokemon {
    /**
     * The id
     */
    private int id;
    /**
     * The nombre
     */
    private String nombre;
    /**
     * The etapa
     */
    private String etapa;
    /**
     * The first_tipo
     */
    private String first_tipo;
    /**
     * The second_tipo
     */
    private String second_tipo;

    /**
     * The Constructor
     * @param id Id del Pokemon
     * @param nombre Nombre del Pokemon
     * @param etapa Etapa del Pokemon
     * @param first_tipo Primer tipo del Pokemon
     * @param second_tipo Segundo tipo del Pokemon
     */

    public Pokemon(int id, String nombre, String etapa, String first_tipo, String second_tipo) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.first_tipo = first_tipo;
        this.second_tipo = second_tipo;
    }

    /**
     * @return La Id del Pokemon
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return El Nombre del Pokemon
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return La Etapa del Pokemon
     */
    public String getEtapa() {
        return this.etapa;
    }

    /**
     * @return El primer Tipo del Pokemon
     */
    public String getFirst_tipo() {
        return this.first_tipo;
    }

    /**
     * @return El segundo Tipo del Pokemon
     */
    public String getSecond_tipo() {
        return this.second_tipo;
    }

    public String toString() {
        return "Pokemon: " + nombre + "\nid: " + id + "\netapa: " + etapa + "\nPrimer Tipo: " + first_tipo +
                "\nSegundo Tipo:  " + second_tipo;
    }
}
