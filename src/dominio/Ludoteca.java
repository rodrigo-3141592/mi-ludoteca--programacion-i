package dominio;

import java.util.ArrayList;

public class Ludoteca {

    private ArrayList<Videojuego> videojuegos;

    public Ludoteca() {
        videojuegos = new ArrayList<>();
    }

    public void añadir(Videojuego videojuego) {
        if (videojuego == null) {
            throw new IllegalArgumentException(
                "El videojuego no puede ser null."
            );
        }

        videojuegos.add(videojuego);
    }

    public void agregar(Videojuego videojuego) {
        añadir(videojuego);
    }

    public void listar() {
        if (videojuegos.isEmpty()) {
            System.out.println("La ludoteca está vacía.");
            return;
        }

        for (Videojuego juego : videojuegos) {
            juego.mostrarFicha();
        }
    }

    public Videojuego buscarPorTitulo(String titulo) {
        if (titulo == null) {
            return null;
        }

        for (Videojuego juego : videojuegos) {
            if (juego.getTitulo().equalsIgnoreCase(titulo.trim())) {
                return juego;
            }
        }

        return null;
    }

    public double calcularPuntuacionMedia() {
        if (videojuegos.isEmpty()) {
            return 0.0;
        }

        int suma = 0;
        for (Videojuego juego : videojuegos) {
            suma += juego.getPuntuacion();
        }

        return (double) suma / videojuegos.size();
    }

    public Videojuego obtenerMejorValorado() {
        if (videojuegos.isEmpty()) {
            return null;
        }

        Videojuego mejor = videojuegos.get(0);
        for (Videojuego juego : videojuegos) {
            if (juego.getPuntuacion() > mejor.getPuntuacion()) {
                mejor = juego;
            }
        }

        return mejor;
    }

    @Override
    public String toString() {
        String listado = "";

        for (Videojuego juego : videojuegos) {
            listado += juego + "\n";
        }

        return listado;
    }
}