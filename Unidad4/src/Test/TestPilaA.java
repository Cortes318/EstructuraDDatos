package Test;

import EntradaSalida.ToolsList;
import PilaEstatica.PilaA;

import javax.swing.*;

public class TestPilaA {
    public static void main(String[] args) {
        String menu = "Push,Pop,Peek,Free,Salir";
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
        PilaA <Integer> pila = new PilaA<Integer>((byte) 10);

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
                        ToolsList.imprimeErrorMsg("Pila Vacia");
                    else{
                        pila.pop();
                        if(!pila.isEmpty())
                            ToolsList.imprimePantalla("Pila Vacia");
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
                case "Free":
                    if(pila.isEmpty())
                        ToolsList.imprimeErrorMsg("Pila Vacia");
                    else{
                        pila = new PilaA<Integer>((byte)10);
                        ToolsList.imprimePantalla("Pila vaciada");
                    }
                    break;
               case "Salir":;  break;
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }

}

