package Busqueda;

import EntradaSalidas.ToolasList;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestBusqueda {
    public static void main(String[] args) {
        List<String> menu = Arrays.asList(
            "Datos Desordenados",
            "Datos Ordenados",
            "Salir"
        );
        String seleccionDatos = mostrarMenu(menu);
        
        List<String> menuBusqueda;
        if (seleccionDatos.equals("Datos Desordenados")) {
            menuBusqueda = Arrays.asList(
                "Búsqueda Hash",
                "Búsqueda Lineal",
                "Búsqueda KMP",
                "Salir"
            );
        } else {
            menuBusqueda = Arrays.asList(
                "Búsqueda Binaria",
                "Búsqueda Salto",
                "Búsqueda Interpolación",
                "Búsqueda Exponencial",
                "Búsqueda Fibonacci",
                "Salir"
            );
        }
        
        menuBusqueda(menuBusqueda);
    }

    public static String mostrarMenu(List<String> menu) {
        String[] opciones = menu.toArray(new String[0]);
        String opcion = (String) JOptionPane.showInputDialog(
            null,
            "SELECCIONA UNA OPCIÓN",
            "M E N U",
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );
        return opcion;
    }

    public static void menuBusqueda(List<String> menu) {
        String seleccion;
        Busqueda busqueda = new Busqueda();
        Random rand = new Random();

        do {
            seleccion = mostrarMenu(menu);

            switch (seleccion) {
                case "Búsqueda Hash":
                    int[] arrHash = obtenerValoresDesordenados();
                    int objetivoHash = obtenerObjetivo();
                    int indiceHash = busqueda.busquedaHash(arrHash, objetivoHash);
                    ToolasList.imprimePantalla("Búsqueda Hash - Índice encontrado: " + indiceHash);
                    break;
                case "Búsqueda Lineal":
                    int[] arrLineal = obtenerValoresDesordenados();
                    int objetivoLineal = obtenerObjetivo();
                    int indiceLineal = busqueda.busquedaLineal(arrLineal, objetivoLineal);
                    ToolasList.imprimePantalla("Búsqueda Lineal - Índice encontrado: " + indiceLineal);
                    break;
                case "Búsqueda Binaria":
                    int[] arrBinaria = obtenerValoresOrdenados();
                    int objetivoBinaria = obtenerObjetivo();
                    int indiceBinaria = busqueda.busquedaBinaria(arrBinaria, objetivoBinaria);
                    ToolasList.imprimePantalla("Búsqueda Binaria - Índice encontrado: " + indiceBinaria);
                    break;
                case "Búsqueda KMP":
                    String textoKMP = obtenerTexto();
                    String patronKMP = obtenerPatron();
                    int indiceKMP = busqueda.busquedaKMP(textoKMP, patronKMP);
                    ToolasList.imprimePantalla("Búsqueda KMP - Índice encontrado: " + indiceKMP);
                    break;
                case "Búsqueda Salto":
                    int[] arrSalto = obtenerValoresOrdenados();
                    int objetivoSalto = obtenerObjetivo();
                    int indiceSalto = busqueda.busquedaSalto(arrSalto, objetivoSalto);
                    ToolasList.imprimePantalla("Búsqueda Salto - Índice encontrado: " + indiceSalto);
                    break;
                case "Búsqueda Interpolación":
                    int[] arrInterpolacion = obtenerValoresOrdenados();
                    int objetivoInterpolacion = obtenerObjetivo();
                    int indiceInterpolacion = busqueda.busquedaInterpolacion(arrInterpolacion, objetivoInterpolacion);
                    ToolasList.imprimePantalla("Búsqueda Interpolación - Índice encontrado: " + indiceInterpolacion);
                    break;
                case "Búsqueda Exponencial":
                    int[] arrExponencial = obtenerValoresOrdenados();
                    int objetivoExponencial = obtenerObjetivo();
                    int indiceExponencial = busqueda.busquedaExponencial(arrExponencial, objetivoExponencial);
                    ToolasList.imprimePantalla("Búsqueda Exponencial - Índice encontrado: " + indiceExponencial);
                    break;
                case "Búsqueda Fibonacci":
                    int[] arrFibonacci = obtenerValoresOrdenados();
                    int objetivoFibonacci = obtenerObjetivo();
                    int indiceFibonacci = busqueda.busquedaFibonacci(arrFibonacci, objetivoFibonacci);
                    ToolasList.imprimePantalla("Búsqueda Fibonacci - Índice encontrado: " + indiceFibonacci);
                    break;
                case "Salir":
                    ToolasList.imprimePantalla("Saliendo del programa...");
                    break;
                default:
                    ToolasList.imprimePantalla("Opción inválida");
                    break;
            }
        } while (!seleccion.equals("Salir"));
    }

    public static int[] obtenerValoresOrdenados() {
        String input = JOptionPane.showInputDialog("Ingresa los valores ordenados separados por comas:");
        String[] valoresStr = input.split(",");
        int[] valores = new int[valoresStr.length];
        for (int i = 0; i < valoresStr.length; i++) {
            valores[i] = Integer.parseInt(valoresStr[i].trim());
        }
        return valores;
    }

    public static int[] obtenerValoresDesordenados() {
        String input = JOptionPane.showInputDialog("Ingresa el tamaño de la matriz de valores desordenados:");
        int tamaño = Integer.parseInt(input);
        String inputMin = JOptionPane.showInputDialog("Ingresa el valor mínimo para generar los números aleatorios:");
        int min = Integer.parseInt(inputMin);
        String inputMax = JOptionPane.showInputDialog("Ingresa el valor máximo para generar los números aleatorios:");
        int max = Integer.parseInt(inputMax);

        int[] valores = new int[tamaño];
        Random rand = new Random();
        for (int i = 0; i < tamaño; i++) {
            valores[i] = rand.nextInt(max - min + 1) + min;
        }
        return valores;
    }

    public static int obtenerObjetivo() {
        String input = JOptionPane.showInputDialog("Ingresa el valor objetivo:");
        return Integer.parseInt(input);
    }

    public static String obtenerTexto() {
        String input = JOptionPane.showInputDialog("Ingresa el texto:");
        return input;
    }

    public static String obtenerPatron() {
        String input = JOptionPane.showInputDialog("Ingresa el patrón:");
        return input;
    }
}
