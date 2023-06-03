package DobleLiga;

import OperacionesListas.InterTDA;
import PilaEstatica.Nodo;

public class DatosDesordenadosDobleLiga<T>  implements InterTDA<T>{
 private Nodito puntero;
 private Nodito f;
 
 public DatosDesordenadosDobleLiga() {
	 puntero=null;
	 f=null;
 }
	@Override
	public boolean isListaVacia() {
		return(puntero==null);
	}

	@Override
	public void inserFrente(Object dato) {
		Nodito p= new Nodito(dato);
		if(isListaVacia()) { 
			puntero=p;
			f=puntero;
		}
		else{
			p.der=puntero;
		    puntero.izq=p;
		    puntero=p;
		}
	}

	@Override
	public void inserFinal(Object dato) {
		Nodito p=new Nodito(dato);
		if (isListaVacia()) puntero=p;
		else {
			f.der=p;
			p.izq=f;
					
			
		}
		f=p;
	}

	@Override
	
		public void eliminaLista(Object dato) {
		    Nodito i = puntero;
		    while(i!=null && !(dato.equals((Object)i.getInfo()))) {
		        i=i.getDer();
		    }
		    if (i != null) {
		        if (i == puntero) {
		            puntero = puntero.getDer();
		        }
		        else {
		            i.getIzq().setDer(i.getDer());
		        }
		        if (i == f) {
		            f = f.getIzq();
		        }
		        else {
		            i.getDer().setIzq(i.getIzq());
		        }
		    }
		}
	
	
	@Override
    public Nodito busqSecLista(T dato) {
        Nodito<T> i=puntero;
        while(i!= null && !(dato.equals((Object)i.getInfo()))){
            i=i.der;
        }
        return (i);
    }

	 
    @Override
public String imprimeLista() {
    String cad = "\n Derecha a Izquierda \n";
    for (Nodito j = puntero;j!=null;j = j.der){
        cad+= j.info + "==>";
    }
    return cad;
}

public String imprimeLista(int a){
    String cad = "g Izquierda a Derecha \n";
    for (Nodito j = f;j!=null;j = j.izq){
        cad+= j.info + "==>";
    }
    return cad;
}

	@Override
	public void vaciaLista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Modificar(Nodo existe) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Nodo busSecLista(Object dato) {
		// TODO Auto-generated method stub
		return null;
	}
}
