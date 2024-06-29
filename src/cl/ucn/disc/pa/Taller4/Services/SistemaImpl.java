package cl.ucn.disc.pa.Taller4.Services;

import cl.ucn.disc.pa.Taller4.model.BasicPokemon;
import cl.ucn.disc.pa.Taller4.model.FirstEv_pokemon;
import cl.ucn.disc.pa.Taller4.model.Pokemon;
import cl.ucn.disc.pa.Taller4.model.SecondEv_pokemon;

import java.util.*;
import java.util.Iterator;

/**
 * The Implementation of the interface {@link Sistema }
 *
 * @author Paolo Vera Rivera - Bruce Munizaga
 */
public class SistemaImpl implements Sistema {
    /**
     * The lista de los pokemons
      */
    public ListaPokemon pokemons;

    /**
     * The Constructor
     *
     */
    public SistemaImpl() {
        this.pokemons = new ListaPokemon();
    }

    @Override
    public boolean agregarBasicPokemon(int id, String nombre, String etapa, String nextEvolucion, String secondEvolucion, String first_tipo, String second_tipo) {
        BasicPokemon pokemon = new BasicPokemon(id, nombre, etapa, nextEvolucion, secondEvolucion, first_tipo, second_tipo);
        return this.pokemons.agregarPokemon(pokemon);
    }

    @Override
    public boolean agregarFirstEvPokemon(int id, String nombre, String etapa, String nextEvolucion, String prevEvolucion, String first_tipo, String second_tipo) {
        FirstEv_pokemon pokemon = new FirstEv_pokemon(id, nombre, etapa, nextEvolucion, prevEvolucion, first_tipo, second_tipo);
        return this.pokemons.agregarPokemon(pokemon);
    }

    @Override
    public boolean agregarSecondEvPokemon(int id, String nombre, String etapa, String prevEvolucion, String firstEvolucion, String first_tipo, String second_tipo) {
        SecondEv_pokemon pokemon = new SecondEv_pokemon(id, nombre, etapa, prevEvolucion, firstEvolucion, first_tipo, second_tipo);
        return this.pokemons.agregarPokemon(pokemon);
    }

    public void rangePokemon(int limiteinf, int limitesup) {

        //Creamos la lista en la cual añadiremos todos los pokemons
        ArrayList<Pokemon> range = new ArrayList<>();

        // Creamos el iterador para recorrer la lista de todos los pokemons
        Iterator<Pokemon> iterator = this.pokemons.iterator();

        // Recorremos la lista con el iterador
        while(iterator.hasNext()) {
            Pokemon pokemon = iterator.next();
            // Añadimos a la lista los pokemons
            range.add(pokemon);
        }
        // Comparador para ordenar los pokemons por id
        Comparator<Pokemon> comparator = new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return Integer.compare(p1.getId(),p2.getId());
            }
        };
        // Ordenamos la lista por id
        Collections.sort(range, comparator);

        if (limitesup > range.size()){
            System.out.println("El limite superior excede en cantidad a los pokemones guardados en esta pokedex, " +
                    "por favor intentelo nuevamente");
            System.out.println("Regresando al menu de Busqueda...");
        }else{
            System.out.println("");
            // Ciclo for que nos imprimira solo los pokemons con id dentro de ese rango que nos entregan
            for(int i = limiteinf - 1; i  <= limitesup - 1 && i <= range.size(); i++) {
                System.out.println(range.get(i));
                System.out.println();
                System.out.println();
            }
        }
    }

    public void abcPokemon() {
        // Creamos la lista en la cual ordenaremos todos los pokemons por nombres
        ArrayList<Pokemon> abc  = new ArrayList<>();

        // Creamos el iterador para recorrer la lista de todos los pokemons
        Iterator<Pokemon> iterator = this.pokemons.iterator();

        // Recorremos la lista utilizando el iterador
        while(iterator.hasNext()) {
            Pokemon pokemon = iterator.next();
            boolean inlist = false;
            // Con este ciclo for vamos a ordenar los datos que se encuentran en la lista utilizando un comparador
            for(int i = 0; i < abc.size(); i++) {
                if(pokemon.getNombre().compareTo(abc.get(i).getNombre()) < 0) {
                    abc.add(i, pokemon);
                    inlist = true;
                    break;
                }
            }
            // Si los elementos no se encuentran en la lista  estas se agregaran
            if(!inlist) {
                abc.add(pokemon);
        }
    }
    // Imprimimos la lista ordenada
    for(Pokemon pokemon: abc) {
        desplegarInformacion(pokemon);
    }
}

    @Override
    public void typePokemon(String tipo) {
        // Creamos la lista por tipos la cual desplegaremos
       LinkedList<Pokemon> tipoPokemon = new LinkedList<>();

       // Creamos el iterador para recorrer la lista en la que se alojan todos los pokemons
       Iterator<Pokemon> iterator = this.pokemons.iterator();

       // Recorremos las lista con el iterador
       while(iterator.hasNext()) {
           Pokemon pokemon = iterator.next();
           if (pokemon.getFirst_tipo().equalsIgnoreCase(tipo) || pokemon.getSecond_tipo().equalsIgnoreCase(tipo)) {
               tipoPokemon.add(pokemon);
           }
       }
       // Imprimimos la lista de pokemons por tipo
        System.out.println("Esta es la lista de pokemons que es de tipo "+ tipo +": ");
        for (Pokemon pokemon : tipoPokemon) {
            desplegarInformacion(pokemon);
        }
    }


    @Override
    public void firstEvPokemon() {
        // Creamos la lista que albergaran solo los pokemons en etapa de Primera evolucion
        LinkedList<Pokemon> firstPokemon = new LinkedList<>();

        // Creamos el iterador para recorrer la lista de pokemons
        Iterator<Pokemon> iterator = this.pokemons.iterator();

        // Creamos el comparador que nos ordenara la lista en orden decreciente
        Comparator<Pokemon> comparator = new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return Integer.compare(p2.getId(), p1.getId());
            }
        };

        // Recorremos la lista de pokemons con el iterador
        while(iterator.hasNext()) {
            Pokemon pokemon = iterator.next();
            // Ciclo if que filtrara solo los pokemons de primera evolucion y los añadira a la lista
            if (pokemon.getEtapa().equalsIgnoreCase("PrimeraEvolucion")) {
                firstPokemon.add(pokemon);
            }
        }

        // Ordenamos los pokemons por id de forma decreciente
        Collections.sort(firstPokemon,comparator);

        // Imprimimos la lista de pokemons
        for(Pokemon pokemon: firstPokemon) {
            desplegarInformacion(pokemon);
        }

    }

    @Override
    public void busquedaPersonalizada(String nombre) {
        // Iterador para recorrer la lista de pokemons
        Iterator<Pokemon> iterator = this.pokemons.iterator(); {
            while(iterator.hasNext()) {
                Pokemon pokemon = iterator.next();
                // Si el nombre ingresado esta en la lista
                if(pokemon.getNombre().equalsIgnoreCase(nombre)) {
                    desplegarInformacion(pokemon);
                    return;
                }
            }
        }
        // Si el Pokemon no esta en la lista
        System.out.println("No se encontro ningun pokemon con ese nombre");
    }

    @Override
    public void desplegarInformacion(Pokemon pokemon) {
        Pokemon p1 = pokemon;
        System.out.println(p1.toString());
        System.out.println();
        System.out.println();
    }

    @Override
    public void desplegarInfoEvolucion(String nombre) {
        // Creamos el iterador para recorrer la lista de pokemons
        Iterator<Pokemon> iterator = this.pokemons.iterator();
        while(iterator.hasNext()) {
            Pokemon pokemon = iterator.next();
            // Si se encuentra el nombre del Pokemon
            if(pokemon.getNombre().equalsIgnoreCase(nombre)) {
                busquedaPersonalizada(pokemon.getNombre());
                // Si el pokemon es un Pokemon Basico y no es Eevee
                if (pokemon instanceof BasicPokemon && !pokemon.getNombre().equalsIgnoreCase("Eevee")) {
                    BasicPokemon bp = (BasicPokemon) pokemon;
                    Scanner sc = new Scanner(System.in);
                    String info;

                    // Si el pokemon no tiene Evolucion
                    if(bp.getNextEvolucion().equalsIgnoreCase("")) {
                        System.out.println("Este pokemon no tiene evolucion");
                        return;
                    }
                    // Si el Pokemon solo tiene una Evolucion
                    if(bp.getSecondEvolucion().equalsIgnoreCase("")) {
                        System.out.println("Este pokemon solo tiene la siguiente evolucion: ");
                        busquedaPersonalizada(bp.getNextEvolucion());
                        return;
                    }

                    // Pokemons Basicos con 2 Evoluciones
                    do {
                        System.out.println("De cual evolucion quiere la informacion: ");
                        System.out.println("[1] Siguiente");
                        System.out.println("[2] Segunda");
                        System.out.println("[3] Salir");
                        System.out.print("Ingrese la opcion: ");
                        info = sc.nextLine();

                        switch (info) {
                            case "1":
                                busquedaPersonalizada(bp.getNextEvolucion());
                                continue;
                            case "2":
                                busquedaPersonalizada(bp.getSecondEvolucion());
                                continue;
                            case "3":
                                System.out.println("Regresando al menu anterior...");
                                return;
                            default:
                                System.out.println("Ingrese una opcion valida");
                        }

                    }while(info != "3");

                    // Si el pokemon es Eevee
                }
                if (pokemon.getNombre().equalsIgnoreCase("Eevee")) {
                    Scanner sc = new Scanner(System.in);
                    String info;


                    do {
                        System.out.println("De cual evolucion quiere la informacion: ");
                        System.out.println("[1] Jolteon");
                        System.out.println("[2] Vaporeon");
                        System.out.println("[3] Flareon");
                        System.out.println("[4] Salir");
                        System.out.print("Ingrese la opcion: ");
                        info = sc.nextLine();

                        switch (info) {
                            case "1":
                                busquedaPersonalizada("Jolteon");
                                continue;
                            case "2":
                                busquedaPersonalizada("Vaporeon");
                                continue;
                            case "3":
                                busquedaPersonalizada("Flareon");
                                continue;
                            case "4":
                                System.out.println("Regresando al menu anterior...");
                                return;
                            default:
                                System.out.println("Ingrese una respuesta valida");
                        }

                    }while(info != "4");


                }

                // Si el Pokemon esta en etapa de Primera Evolucion
                if (pokemon instanceof FirstEv_pokemon) {
                    FirstEv_pokemon fep = (FirstEv_pokemon) pokemon;
                    Scanner sc = new Scanner(System.in);
                    String info;


                    // Si el Pokemon no tiene Siguiente Evolucion
                    if(fep.getNextEvolucion().equalsIgnoreCase("")) {
                        System.out.println("Este pokemon solo tiene la evolucion previa: ");
                        busquedaPersonalizada(fep.getPrevEvolucion());
                        return;
                    }


                    do {
                        System.out.println("De cual evolucion quiere la informacion: ");
                        System.out.println("[1] Siguiente");
                        System.out.println("[2] Previa");
                        System.out.println("[3] Salir");
                        System.out.print("Ingrese la opcion: ");
                        info = sc.nextLine();

                        switch (info) {

                            case "1":
                                busquedaPersonalizada(fep.getNextEvolucion());
                                continue;
                            case "2":
                                busquedaPersonalizada(fep.getPrevEvolucion());
                                continue;
                            case "3":
                                System.out.println("Regresando al menu anterior...");
                                return;
                            default:
                                System.out.println("Ingrese una opcion valida");
                        }

                    }while(info != "3");
                }

                // Si el Pokemon esta en etapa de Segunda Evolucion
                if (pokemon instanceof SecondEv_pokemon) {
                    SecondEv_pokemon sep = (SecondEv_pokemon) pokemon;
                    Scanner sc = new Scanner(System.in);
                    String info;

                    do {
                        System.out.println("De cual evolucion quiere la informacion: ");
                        System.out.println("[1] Anterior");
                        System.out.println("[2] Primera");
                        System.out.println("[3] Salir");
                        System.out.print("Ingrese la opcion: ");
                        info = sc.nextLine();

                        switch (info) {
                            case "1":
                                busquedaPersonalizada(sep.getPrevEvolucion());
                                continue;
                            case "2":
                                busquedaPersonalizada(sep.getFirstEvolucion());
                                continue;
                            case "3":
                                System.out.println("Regresando al menu anterior...");
                                return;
                            default:
                                System.out.println("Ingrese una respuesta valida");
                        }

                    }while(info != "3");
                }
            }
        }
        // Si el Pokemon ingresado no esta en la lista
        System.out.println("No se encontro ningun pokemon con ese nombre");

    }
}
