package Test;


import EntradaSalida.ToolsList;
import OperacionesListas.DatosDesordenados;
import PilaEstatica.Nodo;

import javax.swing.*;

public class TestDatosDesordenados {
    public static void main(String[] args) {
        String menu = "InsertarInicio,InsertarFinal,ValidaVacio,Eliminar,Imprimir,Buscar,Modificar,Ordenar,Salir";
        menu3(menu);
    }
    public static String boton(String menu) {
        String valores[]=menu.split(",");
        int n;
        n = JOptionPane.showOptionDialog(null," SELECCIONA DANDO CLICK ", " M E N U",
                JOptionPane.NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,
                valores,valores[0]);
        return ( valores[n]);
    }

    public static void menu3(String menu)
    {
        DatosDesordenados lista = new DatosDesordenados();

        String sel="";
        do {
            sel=boton(menu);
            switch(sel){
                case "InsertarInicio":
                    lista.inserFrente(ToolsList.leerInt("InsertaFrente"));
                    ToolsList.imprimePantalla("Datos:"+lista.imprimeLista());
                    break;
                case "InsertarFinal":
                    lista.inserFinal(ToolsList.leerInt("InsertaFinal"));
                    ToolsList.imprimePantalla("Datos:"+lista.imprimeLista());
                    break;
                case "ValidaVacio":
                    if(lista.isListaVacia()==true)
                        ToolsList.imprimePantalla("Lista vacia");
                    break;
                case "Buscar":
                    int n = ToolsList.leerInt("Dato a buscar:");

                    Nodo pos = lista.busSecLista(n);
                    Nodo posAnt = lista.busquedaAnt(pos);
                    if(pos==null)
                        ToolsList.imprimeErrorMsg("El dato no existe");
                    else
                        ToolsList.imprimePantalla("El dato " + pos.getInfo()+ " existe"+"\nEn la direccion: " + pos.getSig()
                        + "\nCon antecesor: " + posAnt.getInfo());
                    break;
                case "Eliminar":
                    if(lista.isListaVacia())
                        ToolsList.imprimeErrorMsg("Lista Vacia");
                    else {
                        int var = ToolsList.leerInt("Dato a buscar:");
                        Nodo dato = lista.busSecLista(var);
                        if(dato==null)
                            ToolsList.imprimeErrorMsg("El dato no existe");
                        else{
                        lista.eliminaDato(dato);
                        ToolsList.imprimePantalla("Dato Eliminado");
                        ToolsList.imprimePantalla("Datos:"+lista.imprimeLista());
                        }
                    }
                    break;
                case "Modificar":
                    if(lista.isListaVacia())
                        ToolsList.imprimeErrorMsg("Lista Vacia");
                    else {
                        int var = ToolsList.leerInt("Dato a modificar:");
                        Nodo dato = lista.busSecLista(var);
                        if(dato==null)
                            ToolsList.imprimeErrorMsg("El dato no existe");
                        else {
                            lista.modificar(dato);
                            ToolsList.imprimePantalla("Elemento modificado." + lista.imprimeLista());
                        }
                    }
                case "Ordenar":
                	if (lista.isListaVacia())
                		ToolsList.imprimeErrorMsg("Lista vacia");
                	else {
                		lista.ordenar();
                		ToolsList.imprimePantalla("datos: "+ lista.imprimeLista());
                		
                		
                	}
                    break;
                case "Imprimir":
                    ToolsList.imprimePantalla("Datos:"+lista.imprimeLista());
                    break;
                case "Salir":;  break;
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }


}