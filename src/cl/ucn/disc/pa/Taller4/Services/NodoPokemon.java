package cl.ucn.disc.pa.Taller4.Services;

import cl.ucn.disc.pa.Taller4.model.Pokemon;

/**
 * The Nodo
 *
 * author @Paolo Vera Rivera - Bruce Munizaga
 */

public class NodoPokemon {
    /**
     * The Pokemon
     */
    private Pokemon pokemon;
    /**
     * The Siguiente
     */
    private NodoPokemon next;
    /**
     * The Anterior
     */
    private NodoPokemon prev;

    /**
     * The Constructor
     * @param pokemon
     */
    public NodoPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.next = null;
        this.prev = null;
    }

    /**
     * @return The Pokemon
     */
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     * @return The Siguiente
     */
    public NodoPokemon getNext() {
        return this.next;
    }
    /**
     * @return The Anterior
     */
    public NodoPokemon getPrev() {
        return this.prev;
    }

    /**
     * @param next The siguiente to set
     */
    public void setNext(NodoPokemon next) {
        this.next = next;
    }

    /**
     * @param prev The anterior to set
     */
    public void setPrev(NodoPokemon prev) {
        this.prev = prev;
    }
}
