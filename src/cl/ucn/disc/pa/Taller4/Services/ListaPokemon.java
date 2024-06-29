package cl.ucn.disc.pa.Taller4.Services;

import cl.ucn.disc.pa.Taller4.model.Pokemon;

import java.util.Iterator;

/**
 * The ListaPokemon {@link Pokemon}
 *
 * @author Paolo Vera Rivera - Bruce Munizaga
 */
public class ListaPokemon {

    /**
     * The head
     */
    private NodoPokemon head;
    /**
     * The tail
     */
    private NodoPokemon tail;


    /**
     * The Constructor
     */

    public ListaPokemon() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Agregar un Pokemon al inicio de la lista
     * @param pokemon
     */
    public boolean agregarPokemon(Pokemon pokemon) {

        NodoPokemon nuevo = new NodoPokemon(pokemon);

        // if the lista is vacia
        if(this.head == null) {
            this.head = nuevo;
            this.tail = nuevo;
            return true;
        }
        // if the lista is not vacia
        this.head.setPrev(nuevo);
        nuevo.setNext(this.head);

        this.head = nuevo;

        return true;
    }

    /**
     * The Iterator de la lista de pokemons
     *
     * @author Paolo Vera Rivera
     */

    public Iterator<Pokemon> iterator() {
        return new Iterator<Pokemon>() {
            private NodoPokemon current = head;

            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Pokemon next() {
                if(!hasNext()) {
                    throw new IllegalArgumentException("No hay mas elementos en la lista");
                }
                Pokemon pokemon = current.getPokemon();
                current = current.getNext();
                return pokemon;
            }

        };
    }

}
