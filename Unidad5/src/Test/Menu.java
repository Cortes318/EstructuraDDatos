package Test;

import EntradaSalidas.ToolsList;
import MetodoOrdenamiento.MetodosOrdenamiento2;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Menu {
    public static void main(String[] args) {
        List<String> menu = Arrays.asList(
                "Inserta Tamaño Del Array", "Vaciar Array", "Almacena Datos Aleatorios",
                "Impresion De Datos", "Burbuja Señal", "Doble Burbuja", "Shell IncreDecre", "Sele Directa",
                "Inser Directa", "Binaria", "HeapSort", "Quicksort Recursivo", "Radix", "Intercalacion",
                "Mezcla Directa", "Salir"
        );
        menuOrdenamiento(menu);
    }

    public static String boton(List<String> menu) {
        String[] valores = menu.toArray(new String[0]);
        String opcion = (String) JOptionPane.showInputDialog(null, "SELECCIONA UNA OPCIÓN", "M E N U",
                JOptionPane.QUESTION_MESSAGE, null,
                valores, valores[0]);
        return opcion;
    }

    public static void menuOrdenamiento(List<String> menu) {
        MetodosOrdenamiento2<Integer> Ordenamiento = new MetodosOrdenamiento2<>();

        String sel = "";
        do {
            sel = boton(menu);
            switch (sel) {
                case "Inserta Tamaño Del Array":
                    int tam = ToolsList.leerInt("Ingrese el tamaño del array");
                    Ordenamiento.AlgoritmosArrayImpl(tam);
                    break;
                case "Vaciar Array":
                    Ordenamiento.vaciarArray();
                    ToolsList.imprimePantalla("El array ha sido vaciado");
                    break;
                case "Almacena Datos Aleatorios":
                    Ordenamiento.almacenaAleatorios();
                    ToolsList.imprimePantalla("Se han almacenado valores aleatorios en el array");
                    break;
                case "Impresion De Datos":
                    String datos = Ordenamiento.impresionDatos();
                    ToolsList.imprimePantalla("Datos del array: " + datos);
                    break;
                case "Burbuja Señal":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.burbujaSeñal();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo de burbuja señal\n" +
                                "Datos ordenados: " + Ordenamiento.impresionDatos() +
                                "\nDatos desordenados: " + datos);
                    }
                    break;
                case "Doble Burbuja":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.dobleBurbuja();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo doble burbuja\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "Shell IncreDecre":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.shellIncreDecre();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo Shell IncreDecre\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "Sele Directa":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.seleDirecta();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo Sele Directa\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "Inser Directa":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.inserDirecta();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo de Insercion Directa\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "Binaria":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.binaria();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo de Ordenamiento Binario\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "HeapSort":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.heapSort();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo de HeapSort\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "Quicksort Recursivo":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.quicksortRecursivo();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo de Quicksort Recursivo\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "Radix":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.radix();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo Radix Sort\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "Intercalacion":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.intercalacion();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo de Intercalacion\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "Mezcla Directa":
                    if (Ordenamiento.arrayVacio()) {
                        ToolsList.imprimePantalla("Array VACIO!!!!");
                    } else {
                        datos = Ordenamiento.impresionDatos();
                        Ordenamiento.mezclaDirecta();
                        ToolsList.imprimePantalla("Se ha aplicado el algoritmo de Mezcla Directa\n" +
                                "Datos Desordenados: " + datos +
                                "\nDatos Ordenados: " + Ordenamiento.impresionDatos());
                    }
                    break;
                case "Salir":
                    ToolsList.imprimePantalla("Saliendo del programa...");
                    break;
                default:
                    ToolsList.imprimePantalla("Opción inválida");
                    break;
            }
        } while (!sel.equals("Salir"));
    }
}
