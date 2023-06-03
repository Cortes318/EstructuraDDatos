package Test;

	import EntradaSalida.ToolsList;
	import ColaEstatica.ColaC;

	import javax.swing.*;

	public class TestColaC {    
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
	        ColaC<Integer> cola = new ColaC<Integer>();

	        String sel="";
	        do {
	            sel=boton(menu);
	            switch(sel){
	                case "Push":
	                    cola.push(ToolsList.leerInt("Ingresa un valor"));
	                    ToolsList.imprimePantalla(cola.toString());
	                    break;
	                case "Pop":
	                    if(cola.isEmpty())
	                        ToolsList.imprimeErrorMsg("Pila vacia");
	                    else{
	                        cola.pop();
	                        if(!cola.isEmpty())
	                            ToolsList.imprimePantalla("Elemento Eliminado");
	                        else
	                            ToolsList.imprimePantalla(cola.toString());
	                    }
	                    break;
	                case "Peek":
	                    if(cola.isEmpty())
	                        ToolsList.imprimeErrorMsg("Pila Vacia");
	                    else {
	                        ToolsList.imprimePantalla("Dato en el tope de la cola==>" + "" + cola.peek());
	                    }
	                    break;
	                case "Size":
	                    ToolsList.imprimePantalla("Tamaño de la cola==>" + cola.Size());
	                    break;
	                case "Free":
	                    if(cola.isEmpty())
	                        ToolsList.imprimeErrorMsg("Pila Vacia");
	                    else{
	                        cola.vaciar();
	                        ToolsList.imprimePantalla("Pila vaciada");
	                    }
	                    break;
	                case "Salir":;  break;
	            }
	        }while(!sel.equalsIgnoreCase("Salir"));
	    }


}
