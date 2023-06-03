
package Test;

import EntradaSalida.ToolsList;
import PilaEstatica.Nodo;
import DobleLiga.Nodito;
import DobleLiga.DatosDesordenadosDobleLiga;

import javax.swing.*;

public class TestDobleLiga {
    public static void main(String[] args) {
        String menu = "Insertar Inicio,Insertar Final,Eliminar,Buscar,Imprimir Derecha,Imprimir Izquierda,Salir";
        menu3(menu);

    }

    public static String boton(String menu) {
        String valores[]=menu.split(",");
        int n;
        n = JOptionPane.showOptionDialog(null," SELECCIONA DANDO CLICK ", " MENU DOBLE LIGA",
                JOptionPane.NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,
                valores,valores[0]);
        return ( valores[n]);
    }
    public static void menu3(String menu)
    {
        DatosDesordenadosDobleLiga lista = new DatosDesordenadosDobleLiga();

        String sel="";
        do {
            sel=boton(menu);
            switch(sel){
                case "Insertar Inicio":
                    lista.inserFrente(ToolsList.leerString("InsertaNombre"));
                    ToolsList.imprimePantalla("Datos:"+lista.imprimeLista());
                    break;
                case "Insertar Final":
                    lista.inserFinal(ToolsList.leerString("InsertaNombre"));
                    ToolsList.imprimePantalla("Datos:"+lista.imprimeLista());
                    break;
                case "Buscar":

                    if(lista.isListaVacia())
                        ToolsList.imprimeErrorMsg("Lista vacia");
                    else {
                        Nodito pos = lista.busqSecLista(ToolsList.leerString("Buscar nombre:"));
                        if (pos == null)
                            ToolsList.imprimeErrorMsg("El dato no existe");
                        else
                            ToolsList.imprimePantalla("El dato " + pos.getInfo() + " existe" + "\nEn la direccion: " + pos.getIzq());
                    }

                	break;
                
                case "Eliminar":
                    if (lista.isListaVacia()) {
                        ToolsList.imprimeErrorMsg("La lista está vacía.");
                    } else {
                        ToolsList.imprimePantalla("Datos:" + lista.imprimeLista());
                        String puntero = ToolsList.leerString("Inserta el dato a eliminar");
                        lista.eliminaLista(puntero);
                        if (lista.isListaVacia()) {
                            ToolsList.imprimePantalla("Lista vacía después de eliminar " + puntero);
                        } else {
                            ToolsList.imprimePantalla("Datos después de eliminar " + puntero + ": " + lista.imprimeLista());
                        } 
                    }
                    break;     
                case "Imprimir Derecha":
                    ToolsList.imprimePantalla("Datos:"+lista.imprimeLista());
                    break;
                case "Imprimir Izquierda":
                    ToolsList.imprimePantalla("Datos:"+lista.imprimeLista((int) 1));
                    break;
                case "Salir":;  break;
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }
}