package presentacion;

import dominio.Ludoteca;
import dominio.Videojuego;

public class Main {

    public static void main(String[] args) {

        Ludoteca ludoteca = new Ludoteca();

        Videojuego juego1 = new Videojuego(
            1, "Minecraft", "PC", 90, 120
        );

        Videojuego juego2 = new Videojuego(
            2, "Mario Kart 8 Deluxe", "Nintendo Switch", 95, 60
        );

        Videojuego juego3 = new Videojuego(
            3, "God of War", "PS4", 94, 35
        );

        Videojuego juego4 = new Videojuego(
            4, "Halo Infinite", "Xbox Series X", 85, 40
        );

        Videojuego juego5 = new Videojuego(
            5, "Stardew Valley", "PC", 92, 80
        );

        ludoteca.añadir(juego1);
        ludoteca.añadir(juego2);
        ludoteca.añadir(juego3);
        ludoteca.añadir(juego4);
        ludoteca.añadir(juego5);

        System.out.println("=== MI LUDOTECA v2.4 ===");
        ludoteca.listar();

        System.out.println("\nBusqueda de Minecraft:");
        Videojuego encontrado = ludoteca.buscarPorTitulo("Minecraft");
        if (encontrado != null) {
            encontrado.mostrarFicha();
        } else {
            System.out.println("Videojuego no encontrado.");
        }

        System.out.println("\nBusqueda de Terraria:");
        encontrado = ludoteca.buscarPorTitulo("Terraria");
        if (encontrado != null) {
            encontrado.mostrarFicha();
        } else {
            System.out.println("Videojuego no encontrado.");
        }

        // Pruebas nuevas de la v2.4 (REQ-07 y REQ-08)
        System.out.printf("\nPuntuacion media de la ludoteca: %.2f\n", ludoteca.calcularPuntuacionMedia());

        Videojuego mejor = ludoteca.obtenerMejorValorado();
        System.out.println("\nVideojuego mejor valorado:");
        if (mejor != null) {
            mejor.mostrarFicha();
        } else {
            System.out.println("La ludoteca esta vacia.");
        }

        // Comprobación de igualdad por código
        Videojuego mismoJuego = new Videojuego(
            1, "Minecraft", "PC", 95, 150
        );

        System.out.println("\nComprobacion de igualdad por codigo:");
        System.out.println("Mismo codigo: " + juego1.equals(mismoJuego));
        System.out.println("Codigos diferentes: " + juego1.equals(juego2));
        System.out.println(
            "Mismo hashCode para juegos iguales: "
            + (juego1.hashCode() == mismoJuego.hashCode())
        );
    }
}