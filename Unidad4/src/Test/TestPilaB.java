package Test;


import EntradaSalida.ToolsList;

import PilaEstatica.PilaB;

import javax.swing.*;

public class TestPilaB{
    public static void main(String[] args) {
        String menu = "Push,Pop,Peek,Size,Free,Salir";
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
        PilaB<Integer> pila = new PilaB<Integer>();

        String sel="";
        do {
            sel=boton(menu);
            switch(sel){
                case "Push":
                    pila.push(ToolsList.leerInt("Ingresa un valor"));
                    ToolsList.imprimePantalla(pila.toString());
                    break;
                case "Pop":
                    if(pila.isEmpty())
                        ToolsList.imprimeErrorMsg("Pila vacia");
                    else{
                        pila.pop();
                        if(!pila.isEmpty())
                            ToolsList.imprimePantalla("Elemento Eliminado");
                        else
                            ToolsList.imprimePantalla(pila.toString());
                    }
                    break;
                case "Peek":
                    if(pila.isEmpty())
                        ToolsList.imprimeErrorMsg("Pila Vacia");
                    else {
                        ToolsList.imprimePantalla("Dato en el tope de la pila==>" + "" + pila.peek());
                    }
                    break;
                case "Size":
                    ToolsList.imprimePantalla("Tamaño de la pila==>" + pila.Size());
                    break;
                case "Free":
                    if(pila.isEmpty())
                        ToolsList.imprimeErrorMsg("Pila Vacia");
                    else{
                        pila.freePila();
                        ToolsList.imprimePantalla("Pila vaciada");
                    }
                    break;
                case "Salir":;  break;
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }

}
