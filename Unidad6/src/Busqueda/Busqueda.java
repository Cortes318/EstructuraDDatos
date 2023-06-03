package Busqueda;

import java.util.Arrays;
import java.util.HashMap;

public class Busqueda {
	public static int busquedaHash(int[] arr, int objetivo) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        if (map.containsKey(objetivo)) {
            return map.get(objetivo);
        } else {
            return -1;
        }
    }
	
    public static int busquedaLineal(int[] arr, int objetivo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }

    
    public static int busquedaBinaria(int[] arr, int objetivo) {
        int inicio = 0;
        int fin = arr.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (arr[medio] == objetivo) {
                return medio;
            } else if (objetivo < arr[medio]) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }
        return -1;
    }

    
    public static int busquedaKMP(String texto, String patron) {
        int[] lps = crearTablaLPS(patron);
        int i = 0, j = 0;
        while (i < texto.length()) {
            if (texto.charAt(i) == patron.charAt(j)) {
                i++;
                j++;
                if (j == patron.length()) {
                    return i - j;
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return -1;
    }

   
    private static int[] crearTablaLPS(String patron) {
        int[] lps = new int[patron.length()];
        int i = 1, len = 0;
        while (i < patron.length()) {
            if (patron.charAt(i) == patron.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }

   
    public static int busquedaSalto(int[] arr, int objetivo) {
        int salto = (int) Math.floor(Math.sqrt(arr.length));
        int previo = 0;
        while (arr[Math.min(salto, arr.length) - 1] < objetivo) {
            previo = salto;
            salto += (int) Math.floor(Math.sqrt(arr.length));
            if (previo >= arr.length) {
                return -1;
            }
        }
        while (arr[previo] < objetivo) {
            previo++;
            if (previo == Math.min(salto, arr.length)) {
                return -1;
            }
        }
        if (arr[previo] == objetivo) {
            return previo;
        }
        return -1;
    }

    public static int busquedaInterpolacion(int[] arr, int objetivo) {
        int inicio = 0;
        int fin = arr.length - 1;
        while (inicio <= fin && objetivo >= arr[inicio] && objetivo <= arr[fin]) {
            int posicion = inicio + (int) (((double) (fin - inicio) / (arr[fin] - arr[inicio])) * (objetivo - arr[inicio]));
            if (arr[posicion] == objetivo) {
                return posicion;
            } else if (arr[posicion] < objetivo) {
                inicio = posicion + 1;
            } else {
                fin = posicion - 1;
            }
        }
        return -1;
    }

   
    public static int busquedaExponencial(int[] arr, int objetivo) {
        if (arr[0] == objetivo) {
            return 0;
        }
        int i = 1;
        while (i < arr.length && arr[i] <= objetivo) {
            i = i * 2;
        }
        return Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length), objetivo);
    }

    public static int busquedaFibonacci(int[] arr, int objetivo) {
        int fibMMMinus2 = 0;
        int fibMMMinus1 = 1;
        int fibM = fibMMMinus2 + fibMMMinus1;
        while (fibM < arr.length) {
            fibMMMinus2 = fibMMMinus1;
            fibMMMinus1 = fibM;
            fibM = fibMMMinus2 + fibMMMinus1;
        }
        int offset = -1;
        while (fibM > 1) {
            int i = Math.min(offset + fibMMMinus2, arr.length - 1);
            if (arr[i] < objetivo) {
                fibM = fibMMMinus1;
                fibMMMinus1 = fibMMMinus2;
                fibMMMinus2 = fibM - fibMMMinus1;
                offset = i;
            } else if (arr[i] > objetivo) {
                fibM = fibMMMinus2;
                fibMMMinus1 = fibMMMinus1 - fibMMMinus2;
                fibMMMinus2 = fibM - fibMMMinus1;
            } else {
                return i;
            }
        }
        if (fibMMMinus1 == 1 && arr[offset + 1] == objetivo) {
            return offset + 1;
        }
        return -1;
    }

}