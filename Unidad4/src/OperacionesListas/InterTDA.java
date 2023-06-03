
package OperacionesListas;
import DobleLiga.Nodito;
import PilaEstatica.Nodo;

public interface InterTDA<T> {


    public boolean isListaVacia();
    public void inserFrente(T dato);
    public void inserFinal(T dato);
    public void eliminaLista(Object dato);
    public Nodito busqSecLista(T dato);
    public Nodo busSecLista(T dato);
    public String imprimeLista();
    public void vaciaLista();
	void Modificar(Nodo existe);
}