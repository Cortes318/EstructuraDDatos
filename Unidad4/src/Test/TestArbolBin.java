package Test;
import estrucnoLineal.ArbolBin;

import javax.swing.*;

import EntradaSalida.ToolsList;

public class TestArbolBin {    
	public static void main(String[] args) {
    String menu = "Insertar,Recorridos,Buscar,Hojas,Altura,Ver,Salir";
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
        ArbolBin<Integer> Nodito = new ArbolBin<Integer>();

        String sel="";
        do {
            sel=boton(menu);
            switch(sel){
                case "Insertar": {
                	System.out.println("El tipo de T es"+Nodito.getClass().getName());
                	Nodito.insertarArbol(ToolsList.leerInt("Dato"));
                	
                }
                  
                case "Recorridos": {
                	ToolsList.imprimeMsg("\nInorden1:"+Nodito.preorden(Nodito.getRaiz()));
                }
                    
                case "Buscar":
                   
                case "Hojas":
                  
                case "Altura":
                 
                case "Ver":
                	
                case "Salir":
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }


}
