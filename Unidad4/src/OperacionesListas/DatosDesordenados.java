
package OperacionesListas;
import PilaEstatica.Nodo;
import EntradaSalida.ToolsList;
import javax.swing.*;

import DobleLiga.Nodito;

public class DatosDesordenados<T> implements InterTDA<T>{
    private Nodo inicio;
    private Nodo f;

    public DatosDesordenados(){
        inicio = null;
        f = null;
    }


    @Override
    public boolean isListaVacia() {
        return (inicio == null);
    }

    @Override
    public void inserFrente(T dato) {
        Nodo p = new Nodo(dato);
        if(isListaVacia()) {
            inicio = p;
            f = p;
        }else{
            p.sig = inicio;
            inicio = p;
        }

    }

    @Override
    public void inserFinal(T dato) {
        Nodo p = new Nodo(dato);
        if(isListaVacia()){

            inicio = p;
        }
        else{
            f.sig = p;
        }
        f = p;
    }

    @Override
    public void eliminaLista(Object dato) {
        inicio = null;
        f = null;
    }

    public void eliminaDato(Nodo var){
        if(var==inicio){
            inicio = inicio.sig;
            var = null;
        }
        else{
            Nodo antes = busquedaAnt(var);
            if(var ==f){
                f = antes;
                f.sig= null;
                var = null;
            }
            else
            {
                antes.sig = var.sig;
                var = null;
            }
        }
    }
    
    public void modificar(Nodo var){
        var.setInfo(ToolsList.leerInt("Nuevo dato"));
    }


    @Override
    public Nodo busSecLista(T dato) {
        Nodo<T> i=inicio;

        while(i.sig != null && dato!=i.getInfo()){

            i=i.getSig();
        }
        return (i!=null)?i:null;
    }


    public Nodo busquedaAnt (Nodo pos) {
        Nodo k = inicio;
        while(pos!=k.getSig())
            k=k.getSig();
        return k;
    }

    @Override
    public String imprimeLista() {
        String cad = "";
        for (Nodo i = inicio;i!=null;i=i.getSig()){
            cad+=i.getInfo()+"-->";
        }
        return cad;
    }
    
    public void ordenar() {
    	Nodo aux = new Nodo(0);
    	Nodo m,n;
    	for (m=inicio;m!= null;m=m.getSig()) 
    		for (n=m.sig; n!= null; n=n.getSig()) 
    			if ((Integer)m.getInfo()>(Integer)n.getInfo()) {
    				aux.info =m.info;
    				m.info=n.info;
    				n.info=aux.info;
    			}
    		}
    	
    

    @Override
    public void vaciaLista() {
        inicio = null;
    }

	@Override
	public void Modificar(Nodo existe) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Nodito busqSecLista(T dato) {
		// TODO Auto-generated method stub
		return null;
	}


	


}