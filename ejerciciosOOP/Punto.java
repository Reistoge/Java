// Definir una clase Punto que representa un punto en el    
package ejerciciosOOP;

public class Punto {
    // Atributos de la clase: coordenadas x e y
    private double x;
    private double y;

    // Constructor de la clase: inicializa los valores de x e y con los parámetros
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Método de la clase: imprime en qué cuadrante se encuentra el punto
    public void imprimirCuadrante() {
        // Si x e y son positivas, el punto está en el primer cuadrante
        if (x > 0 && y > 0) {
            System.out.println("El punto está en el primer cuadrante.");
        }
        // Si x es negativa e y es positiva, el punto está en el segundo cuadrante
        else if (x < 0 && y > 0) {
            System.out.println("El punto está en el segundo cuadrante.");
        }
        // Si x e y son negativas, el punto está en el tercer cuadrante
        else if (x < 0 && y < 0) {
            System.out.println("El punto está en el tercer cuadrante.");
        }
        // Si x es positiva e y es negativa, el punto está en el cuarto cuadrante
        else if (x > 0 && y < 0) {
            System.out.println("El punto está en el cuarto cuadrante.");
        }
        // Si x o y son cero, el punto está sobre uno de los ejes
        else {
            System.out.println("El punto está sobre uno de los ejes.");
        }
    }
}
