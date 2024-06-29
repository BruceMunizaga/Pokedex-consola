import cl.ucn.disc.pa.Taller4.Services.SistemaImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * The Main
 *
 * @author Paolo Vera Rivera - Bruce Munizaga
 */
public class Main {
    public static void main(String[] args) {

        // se da la bienvenida al usuario
        System.out.println("[*][*][*][*] BIENVENIDO A LA POKEDEX [*][*][*][*]");

        //se llama al metodo que desplegara el menu principal
        menuPrincipal();
    }
    public static void leerArchivo(SistemaImpl sistema) {
        // Leer el archivo
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./kanto.txt"))) {
            String linea = "";
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    linea = linea.replaceAll("\\s+", "");
                    lineas.add(linea);
                    String[] partes = linea.split(",");
                    // Agregando cada pokemon a la lista tomando todos los casos que se presentan

                    //Pokemons Basicos que no tienen Evolucion
                    if (partes[2].equalsIgnoreCase("Basico") && partes.length == 5) {
                        sistema.agregarBasicPokemon(Integer.parseInt(partes[0]), partes[1], partes[2],
                                "", "",
                                partes[3], partes[4]);
                    }
                    // Pokemons Basicos que solo tienen una evolucion
                    if (partes[2].equalsIgnoreCase("Basico") && partes.length == 6) {
                        sistema.agregarBasicPokemon(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3],
                                "", partes[4], partes[5]);
                    }
                    // Pokemons Basicos que tienen dos evoluciones
                    if (partes[2].equalsIgnoreCase("Basico") && partes.length == 7) {
                        sistema.agregarBasicPokemon(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3],
                                partes[4], partes[5], partes[6]);
                    }
                    // El caso especial de Eevee que tiene mas de una primera evolucion pero no tiene segunda
                    if (partes[1].equalsIgnoreCase("Eevee")) {
                        sistema.agregarBasicPokemon(Integer.parseInt(partes[0]), partes[1], partes[2],
                                partes[3] + ", " + partes[4] + ", " + partes[5], "", partes[6],
                                partes[7]);
                    }
                    // Pokemons de Primera Evolucion que no tiene Evolucion Siguiente
                    if (partes[2].equalsIgnoreCase("PrimeraEvolucion") && partes.length == 6) {
                        sistema.agregarFirstEvPokemon(Integer.parseInt(partes[0]), partes[1], partes[2],
                                "", partes[3], partes[4], partes[5]);
                    }
                    // Pokemons de Primera Evolucion que tienen Segunda Evolucion
                    if (partes[2].equalsIgnoreCase("PrimeraEvolucion") && partes.length == 7) {
                        sistema.agregarFirstEvPokemon(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3],
                                partes[4], partes[5], partes[6]);
                    }
                    // Pokemons de Segunda Evolucion
                    if (partes[2].equalsIgnoreCase("SegundaEvolucion")) {
                        sistema.agregarSecondEvPokemon(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3],
                                partes[4], partes[5], partes[6]);
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ordenar la lista de líneas
        Collections.sort(lineas);

    }

    private static void menuPrincipal() {

        //instancio el sistema para obtener todos sus metodos
        SistemaImpl sistema = new SistemaImpl();

        //llamo al metodo que leera el archivo txt
        leerArchivo(sistema);
        Scanner ingreso = new Scanner(System.in);
        String opcionPrincipal = null; //variable que alojara la opcion del menu principal

        //si escogera la opcion 2
        String nombrePokemon = null;

        // mientras que la opcion no sea 3, se repetira
        while (!Objects.equals(opcionPrincipal, "3")){
            System.out.println("""
                Escoga una opcion:
                
                [1] Desplegar Pokemones
                [2] Busqueda Personalizada de Pokemones
                [3] Salir de la Pokedex
                """);
            System.out.print("Ingrese su opcion aqui: ");
            opcionPrincipal = ingreso.nextLine(); //aca se alojara la opcion

            if(opcionPrincipal.equalsIgnoreCase("2")){
                System.out.print("Ingrese el nombre del pokemon que desea buscar: ");
                nombrePokemon = ingreso.nextLine();
            }



            //se evalua la opcion escogida
            switch (opcionPrincipal){
                case "1" -> menuBusqueda(sistema);
                case "2" -> sistema.desplegarInfoEvolucion(nombrePokemon);
                case "3" -> System.out.println("Hasta pronto!");
                default -> System.out.println("Opcion no valida, intente nuevamente");
            }
        }
    }

    private static void menuBusqueda(SistemaImpl sistema) {

        //instancio el sistema para obtener todos sus metodos
        Scanner ingreso = new Scanner(System.in);
        String opcionSecundaria = null; //variable que alojara la opcion del menu principal
        while (!Objects.equals(opcionSecundaria,"5")) {
            System.out.println("""
                    ¿Como desea buscar a los Pokemones?:
                                    
                    [1] Por rango de IDS
                    [2] Ordenados Alfabeticamente
                    [3] Por tipo
                    [4] Solo los de primera evolucion
                    [5] Regresar al menu anterior
                    """);
            System.out.print("Ingrese su opcion aqui: ");
            opcionSecundaria = ingreso.nextLine(); //aca se alojara la opcion

            //en caso que la opcion sea 1, se usaran estas variables
            int limiteInferior = 0; //variable que alojara el limite inferior desplegar los Pokemones por rango de IDS
            int limiteSuperior = 0;//variable que alojara el limite superior desplegar los Pokemones por rango de IDS

            //en caso que la opcion sea 3, se usara esta variable
            String tipo = null;

            //si escogio la opcion 1, entro a este if
            if (opcionSecundaria.equalsIgnoreCase("1")){

                do {
                    //Solicito el limite inferior desde pantalla
                    System.out.print("Ingrese el limite inferior del rango a desplegar: ");
                    String limiteInferiorStr = ingreso.nextLine(); //lo recibo como string

                    //entro a un try catch para evitar que se caiga el sistema al cambiar la variable a int
                    try {

                        //cambio de string a int
                        limiteInferior = Integer.parseInt(limiteInferiorStr);

                        //si no hubo error al cambiarlo, valido si es menor o igual que cero
                        if (limiteInferior <= 0) { //si es menor, o igual que cero, entro al if
                            System.out.println("Las IDS son mayores que cero. Intente nuevamente");
                        }

                        //si no es un dato numerico, se pide de nuevo
                    } catch (IllegalArgumentException e) {
                        System.out.println("El valor ingresado no es válido. Intente nuevamente.");

                    }
                }while (limiteInferior <= 0);

                //hago lo mismo para el dato superior

                do {
                    System.out.print("Ingrese el limite inferior del rango a desplegar: ");
                    String limiteSuperiorStr = ingreso.nextLine();

                    try {
                        limiteSuperior = Integer.parseInt(limiteSuperiorStr);
                        if (limiteSuperior > 151) {
                            System.out.println("Solo se considera hasta la ID 151. Intente nuevamente");
                        }else{
                            if (limiteInferior > limiteSuperior){
                                System.out.println("El limite inferior no puede ser mayor que el limite superior");
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("El valor ingresado no es válido. Intente nuevamente.");

                    }
                }while (limiteSuperior > 151);
            }

            //si escogio la opcion 3, entro a este if
            if (opcionSecundaria.equalsIgnoreCase("3")){

                System.out.println("""
                        ADVERTENCIA: Usted ingresara un tipo de pokemon en especifico, si este coincide con alguno de los
                        dos tipos que puede poseer un pokemon, se desplegara ese pokemon
                        """);
                System.out.print("Ingrese el tipo de Pokemon que desea desplegar: ");
                tipo = ingreso.nextLine();
            }

            switch (opcionSecundaria) {
                case "1" -> sistema.rangePokemon(limiteInferior,limiteSuperior);
                case "2" -> sistema.abcPokemon();
                case "3" -> sistema.typePokemon(tipo);
                case "4" -> sistema.firstEvPokemon();
                case "5" -> System.out.println("Regresando al menu anterior...");
                default -> System.out.println("Opcion no valida, intente nuevamente");

            }
        }
    }

}
