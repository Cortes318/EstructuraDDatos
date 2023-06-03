package MetodoOrdenamiento;

import java.util.Arrays;

public class MetodosOrdenamiento2<T> implements Ordenamiento<T>{ 

    private int[] arreglo;
    private byte indice;
 
    public void AlgoritmosArrayImpl(int n) {
        arreglo = new int[n];
        indice = -1;
    }

    private int generaRandom(int min, int max) {
        return (int) ((max - min + 1) * Math.random() + min);
    }
    @Override
    public boolean arrayVacio() {
        return indice == -1;
    }
    @Override
    public boolean espacioArray() {
        return indice < arreglo.length - 1;
    }
    @Override
    public void vaciarArray() {
        Arrays.fill(arreglo, 0);
        indice = -1;
    }

    @Override
    public void almacenaAleatorios() {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = generaRandom(10, 99);
        }
        indice = (byte) (arreglo.length - 1);
    }

    @Override
    public String impresionDatos() {
        if (arrayVacio()) {
            return "El arreglo está vacío.";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= indice; i++) {
                sb.append(arreglo[i]).append(" ");
            }
            return sb.toString();
        }
    }

    @Override
    public void burbujaSeñal() {
        int n = indice + 1;
        boolean intercambiado;

        do {
            intercambiado = false;

            for (int i = 0; i < n - 1; i++) {
                if (arreglo[i] > arreglo[i + 1]) {
                    swap(i, i + 1);
                    intercambiado = true;
                }
            }

            for (int i = n - 2; i >= 0; i--) {
                if (arreglo[i] > arreglo[i + 1]) {
                    swap(i, i + 1);
                    intercambiado = true;
                }
            }
        } while (intercambiado);
    }


    @Override
    public void dobleBurbuja() {
        int inicio = 0;
        int fin = indice;
        boolean intercambiado;

        do {
            intercambiado = false;

            for (int i = inicio; i < fin; i++) {
                if (arreglo[i] > arreglo[i + 1]) {
                    swap(i, i + 1);
                    intercambiado = true;
                }
            }

            if (!intercambiado) {
                break;
            }

            intercambiado = false;
            fin--;

            for (int i = fin - 1; i >= inicio; i--) {
                if (arreglo[i] > arreglo[i + 1]) {
                    swap(i, i + 1);
                    intercambiado = true;
                }
            }

            inicio++;
        } while (intercambiado);
    }

    @Override
    public void shellIncreDecre() {
        int n = arreglo.length;
        int intervalo = n / 2;

        while (intervalo > 0) {
            for (int i = intervalo; i < n; i++) {
                int temp = arreglo[i];
                int j = i;

                while (j >= intervalo && arreglo[j - intervalo] > temp) {
                    arreglo[j] = arreglo[j - intervalo];
                    j -= intervalo;
                }

                arreglo[j] = temp;
            }

            intervalo /= 2;
        }
    }

    @Override
    public void seleDirecta() {
        for (int i = 0; i < indice; i++) {
            int indiceMin = i;

            for (int j = i + 1; j <= indice; j++) {
                if (arreglo[j] < arreglo[indiceMin]) {
                    indiceMin = j;
                }
            }

            swap(indiceMin, i);
        }
    }

    @Override
    public void inserDirecta() {
        for (int i = 1; i <= indice; i++) {
            int key = arreglo[i];
            int j = i - 1;

            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            arreglo[j + 1] = key;
        }
    }

    @Override
    public void binaria() {
        int n = indice + 1;
        binariaRecursiva(0, n - 1);
    }

    private void binariaRecursiva(int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            binariaRecursiva(izquierda, medio);
            binariaRecursiva(medio + 1, derecha);
            fusionar(izquierda, medio, derecha);
        }
    }

    private void fusionar(int izquierda, int medio, int derecha) {
        int[] arregloTemp = new int[derecha - izquierda + 1];
        int i = izquierda;
        int j = medio + 1;
        int k = 0;

        while (i <= medio && j <= derecha) {
            if (arreglo[i] <= arreglo[j]) {
                arregloTemp[k] = arreglo[i];
                i++;
            } else {
                arregloTemp[k] = arreglo[j];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            arregloTemp[k] = arreglo[i];
            i++;
            k++;
        }

        while (j <= derecha) {
            arregloTemp[k] = arreglo[j];
            j++;
            k++;
        }

        for (i = izquierda; i <= derecha; i++) {
            arreglo[i] = arregloTemp[i - izquierda];
        }
    }


    @Override
    public void heapSort() {
        int n = indice + 1;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
    }

    private void heapify(int n, int i) {
        int mayor = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;

        if (izquierda < n && arreglo[izquierda] > arreglo[mayor]) {
            mayor = izquierda;
        }

        if (derecha < n && arreglo[derecha] > arreglo[mayor]) {
            mayor = derecha;
        }

        if (mayor != i) {
            swap(i, mayor);
            heapify(n, mayor);
        }
    }

    @Override
    public void quicksortRecursivo() {
        quicksortRecursivo(0, indice);
    }

    private void quicksortRecursivo(int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(izquierda, derecha);
            quicksortRecursivo(izquierda, indiceParticion - 1);
            quicksortRecursivo(indiceParticion + 1, derecha);
        }
    }

    private int particion(int izquierda, int derecha) {
        int pivote = arreglo[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (arreglo[j] < pivote) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, derecha);
        return i + 1;
    }

    @Override
    public void radix() {
        int maximo = obtenerMaximo();
        int n = indice + 1;

        for (int exp = 1; maximo / exp > 0; exp *= 10) {
            countingSort(exp, n);
        }
    }

    private int obtenerMaximo() {
        int maximo = arreglo[0];

        for (int i = 1; i <= indice; i++) {
            if (arreglo[i] > maximo) {
                maximo = arreglo[i];
            }
        }

        return maximo;
    }

    private void countingSort(int exp, int n) {
        int[] resultado = new int[n];
        int[] conteo = new int[10];

        Arrays.fill(conteo, 0);

        for (int i = 0; i < n; i++) {
            conteo[(arreglo[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            resultado[conteo[(arreglo[i] / exp) % 10] - 1] = arreglo[i];
            conteo[(arreglo[i] / exp) % 10]--;
        }

        System.arraycopy(resultado, 0, arreglo, 0, n);
    }

    @Override
    public void intercalacion() {
        int n = indice + 1;
        int[] arregloTemp = new int[n];
        intercalacionRecursiva(0, n - 1, arregloTemp);
    }

    private void intercalacionRecursiva(int izquierda, int derecha, int[] arregloTemp) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            intercalacionRecursiva(izquierda, medio, arregloTemp);
            intercalacionRecursiva(medio + 1, derecha, arregloTemp);
            intercalar(izquierda, medio, derecha, arregloTemp);
        }
    }

    private void intercalar(int izquierda, int medio, int derecha, int[] arregloTemp) {
        for (int i = izquierda; i <= derecha; i++) {
            arregloTemp[i] = arreglo[i];
        }

        int i = izquierda;
        int j = medio + 1;
        int k = izquierda;

        while (i <= medio && j <= derecha) {
            if (arregloTemp[i] <= arregloTemp[j]) {
                arreglo[k] = arregloTemp[i];
                i++;
            } else {
                arreglo[k] = arregloTemp[j];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            arreglo[k] = arregloTemp[i];
            i++;
            k++;
        }

        while (j <= derecha) {
            arreglo[k] = arregloTemp[j];
            j++;
            k++;
        }
    }

    @Override
    public void mezclaDirecta() {
        int n = indice + 1;
        int[] arregloTemp = new int[n];
        mezclaDirectaRecursiva(arregloTemp, 0, n - 1);
    }

    private void mezclaDirectaRecursiva(int[] arregloTemp, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            mezclaDirectaRecursiva(arregloTemp, izquierda, medio);
            mezclaDirectaRecursiva(arregloTemp, medio + 1, derecha);
            mezclar(arregloTemp, izquierda, medio, derecha);
        }
    }

    private void mezclar(int[] arregloTemp, int izquierda, int medio, int derecha) {
        for (int i = izquierda; i <= derecha; i++) {
            arregloTemp[i] = arreglo[i];
        }

        int i = izquierda;
        int j = medio + 1;
        int k = izquierda;

        while (i <= medio && j <= derecha) {
            if (arregloTemp[i] <= arregloTemp[j]) {
                arreglo[k] = arregloTemp[i];
                i++;
            } else {
                arreglo[k] = arregloTemp[j];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            arreglo[k] = arregloTemp[i];
            i++;
            k++;
        }
    }

    private void swap(int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }
}