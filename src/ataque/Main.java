// Clase Singleton que representa un gestor de juego
class GestorJuego {
    // Instancia única de GestorJuego
    private static GestorJuego instanciaUnica;

    // Variables del estado del juego
    private int nivelActual;
    private int puntuacionTotal;

    // Constructor privado para evitar la creación de más instancias
    private GestorJuego() {
        nivelActual = 1;
        puntuacionTotal = 0;
    }

    // Método estático para obtener la única instancia de GestorJuego
    public static synchronized GestorJuego obtenerInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new GestorJuego();
        }
        return instanciaUnica;
    }

    // Método para cambiar de nivel
    public void avanzarNivel() {
        nivelActual++;
        System.out.println("Nivel avanzado. Nivel actual: " + nivelActual);
    }

    // Método para añadir puntos a la puntuación total
    public void sumarPuntos(int puntos) {
        puntuacionTotal += puntos;
        System.out.println("Puntuacion total: " + puntuacionTotal);
    }

    // Método para mostrar el estado del juego
    public void mostrarEstado() {
        System.out.println("Nivel actual: " + nivelActual);
        System.out.println("Puntuacion total: " + puntuacionTotal);
    }
}

// Clase principal para probar el patrón Singleton
public class Main {
    public static void main(String[] args) {
        // Obtener la instancia única de GestorJuego
        GestorJuego gestor1 = GestorJuego.obtenerInstancia();
        gestor1.avanzarNivel();  // Cambiar de nivel
        gestor1.sumarPuntos(500);  // Añadir puntos

        // Intentar obtener otra instancia del GestorJuego
        GestorJuego gestor2 = GestorJuego.obtenerInstancia();
        gestor2.avanzarNivel();  // Cambiar de nivel
        gestor2.sumarPuntos(300);  // Añadir puntos

        // Mostrar el estado del juego desde ambas referencias
        gestor1.mostrarEstado();  // Estado desde gestor1
        gestor2.mostrarEstado();  // Estado desde gestor2 (es la misma instancia)
    }
}
