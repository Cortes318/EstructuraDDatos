package Test;

import estrucnoLineal.ArbolBin;

import javax.swing.*;

import EntradaSalida.ToolsList;

public class TestArbolBin {
    public static void main(String[] args) {
        String menu = "Insertar,Recorridos,Buscar,Hojas,Altura,Nodo terminales,Nodos interiores,Ver,Salir";
        menu3(menu);
    }

    public static String boton(String menu) {
        String valores[] = menu.split(",");
        int n;
        n = JOptionPane.showOptionDialog(null, "SELECCIONA DANDO CLICK", "M E N U",
                JOptionPane.NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                valores, valores[0]);
        return valores[n];
    }

    public static void menu3(String menu) {
        ArbolBin<Integer> arbol = new ArbolBin<Integer>();

        String sel = "";
        do {
            sel = boton(menu);
            switch (sel) {
                case "Insertar": {
                    System.out.println("El tipo de T es " + arbol.getClass().getName());
                    arbol.insertarArbol(ToolsList.leerInt("Dato"));
                    break;
                }
                case "Recorridos": {
                    ToolsList.imprimeMsg("\nInorden1: " + arbol.preorden(arbol.getRaiz()));
                    break;
                }
                case "Buscar": {
                    Integer dato = ToolsList.leerInt("Ingrese el elemento a buscar: ");
                    ArbolBin.Nodito nodoEncontrado = arbol.buscar(dato);
                    if (nodoEncontrado != null) {
                        System.out.println("Elemento encontrado: " + nodoEncontrado.getInfo());
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;
                }
                case "Hojas": {
                    System.out.println("Hojas del árbol:");
                    arbol.terminales(arbol.getRaiz());
                    break;
                }
                case "Altura": {
                    int altura = arbol.altura(arbol.getRaiz());
                    System.out.println("Altura del árbol: " + altura);
                    break;
                }
                case "Nodo terminales": {
                    System.out.println("Modo terminales:");
                    arbol.terminales(arbol.getRaiz());
                    break;
                }
                case "Nodos interiores": {
                    System.out.println("Nodos interiores:");
                    arbol.interiores(arbol.getRaiz());
                    break;
                }
                case "Ver": {
                    arbol.visualizar();
                    break;
                }
                case "Salir": {
                    ToolsList.imprimeMsg("Saliendo del programa");
                    break;
                }
            }
        } while (!sel.equals("Salir"));
    }
}
