package test;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        String menu = "ArreglosOrdenados,ArreglosDesordenados,Salir";
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



        String sel="";
        do {
            sel=boton(menu);
            switch(sel){
                case "ArreglosDesordenados":
                    String menu1="Agregar,Imprimir,Busqueda,Modificar,Eliminar,Ordenar,Salir";
                    DatosDesordenados.menu3(menu1);
                    break;
                case "ArreglosOrdenados":
                    String menu2 = "Agregar,Imprimir,Busqueda,Modificar,Eliminar,Salir";
                    DatosOrdenados.menu3(menu2);
                    break;
                case "Salir":;  break;
            }//switch
        }while(!sel.equalsIgnoreCase("Salir"));
    }
}
