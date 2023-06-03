package recursividad;

public class Rectangulo {

    public static void main(String[] args) {
        imprimirRectangulo(4, 4);
    }

    public static void imprimirRectangulo(int base, int altura) {
        imprimirRectanguloRecursivo(base, altura, 0, 0);
    }

    private static void imprimirRectanguloRecursivo(int base, int altura, int fila, int columna) {
        if (fila == altura) {
            return;
        }

        if (columna == base) {
            System.out.println(); 
            imprimirRectanguloRecursivo(base, altura, fila + 1, 0);
            return;
        }

        System.out.print("* "); 
        imprimirRectanguloRecursivo(base, altura, fila, columna + 1); 
}
}