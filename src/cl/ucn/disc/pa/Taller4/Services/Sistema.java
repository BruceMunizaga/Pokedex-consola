package cl.ucn.disc.pa.Taller4.Services;

import cl.ucn.disc.pa.Taller4.model.Pokemon;

/**
 * The Sistema
 *
 * @author Paolo Vera Rivera - Bruce Munizaga
 */
public interface Sistema {


    /**
     * Agrega un pokemon en etapa Basico a la lista
     * @param id Id del Pokemon
     * @param nombre Nombre del Pokemon
     * @param etapa Etapa del Pokemon
     * @param nextEvolucion Siguiente Evolucion del Pokemon
     * @param secondEvolucion Segunda Evolucion del Pokemon
     * @param first_tipo Primer tipo del Pokemon
     * @param second_tipo Segundo Tipo del Pokemon
     * @return El pokemon agregado a la lista de Pokemons
     */
    boolean agregarBasicPokemon(int id, String nombre, String etapa, String nextEvolucion, String secondEvolucion,
                                String first_tipo, String second_tipo);

    /**
     * Agrega un pokemon en etapa de Primera Evolucion a la lista
     * @param id Id del Pokemon
     * @param nombre Nombre del Pokemon
     * @param etapa Etapa del Pokemon
     * @param nextEvolucion Siguiente Evolucion del Pokemon
     * @param prevEvolucion Evolucion previa del Pokemon
     * @param first_tipo Primer tipo del Pokemon
     * @param second_tipo Segundo Tipo del Pokemon
     * @return El pokemon agregado a la lista de Pokemons
     */
    boolean agregarFirstEvPokemon(int id, String nombre, String etapa, String nextEvolucion, String prevEvolucion,
                                  String first_tipo, String second_tipo);

    /**
     * Agrega un pokemon en etapa de Segunda Evolucion a la lista
     * @param id Id del Pokemon
     * @param nombre Nombre del Pokemon
     * @param etapa Etapa del Pokemon
     * @param prevEvolucion  Evolucion previa del Pokemon
     * @param firstEvolucion Primera Forma del Pokemon
     * @param first_tipo Primer tipo del Pokemon
     * @param second_tipo Segundo Tipo del Pokemon
     * @return El pokemon agregado a la lista de Pokemons
     */
    boolean agregarSecondEvPokemon(int id, String nombre, String etapa, String prevEvolucion, String firstEvolucion,
                                   String first_tipo, String second_tipo);

    /**
     * Despliega una lista de pokemons ordenados por su id dado un rango de numeros
     * @param limiteinf El numero de id mas bajo que se quiere obtener
     * @param limitesup El numero de id mas alto que se quiere obtener
     */
    void rangePokemon(int limiteinf, int limitesup);
    /**
     * Despliega la lista de pokemons ordenados alfabeticamente
     */
    void abcPokemon();

    /**
     * Despliega la lista de pokemons por tipo
     * @param tipo El tipo de pokemon del que queremos la lista
     */
    void typePokemon(String tipo);

    /**
     * Despliega una lista de pokemons que esten en la etapa de Primera Evolucion
     */
    void firstEvPokemon();

    /**
     * Sistema de busqueda personalizada
     *
     * @param nombre El nombre del pokemon
     */
    void busquedaPersonalizada(String nombre);

    /**
     * Despliega la informacion de un Pokemon
     * @param pokemon El pokemon del que se desplegara la informacion
     */

    void desplegarInformacion(Pokemon pokemon);

    /**
     * Despliega informacion de la Evolucion de un pokemon
     * @param nombre El nombre de la evolucion
     */
    void desplegarInfoEvolucion(String nombre);

}
