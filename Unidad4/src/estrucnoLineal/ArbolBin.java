package estrucnoLineal;

public class ArbolBin<T> {
	private Nodito raiz;
	 
	public ArbolBin() {
		raiz=null;
	}
    
	public Nodito getRaiz() {
		return raiz;
	}
	 
	public void setRaiz(Nodito raiz) {
	 this.raiz=raiz;	
	}
	public boolean arbolVacio() {
		return raiz==null;
	}
	public void vaciarArbol() {
		raiz=null;
	}
	
	public void insertarArbol(T info) {
		Nodito p=new Nodito(info);
		if(arbolVacio()) {
			raiz=p;
		}
		else {
			Nodito padre=buscaPadre(raiz,p);
			if(p.hashCode()>=padre.hashCode())
				padre.der=p;
			else
				padre.izq=p;
		}
	}
	
	public Nodito buscaPadre(Nodito actual,Nodito p) {
		Nodito padre=null;
		while(actual!=null) {
			padre=actual;
			if((int)p.info>=(int)padre.info)
				actual=padre.der;
			else
				actual=padre.izq;
		}
		return padre;
	}
	public String preorden(Nodito r) {
		if(r!=null) {
			return r.info+"."+preorden(r.izq)+"."+preorden(r.der);
		}
		else return"";
	}
	public String inorden(Nodito r) {
		if(r!=null) {
			return inorden(r.izq)+" - "+r.getInfo()+" - "+inorden(r.der);
			
		}
		else return"";
	}
	public String inorden2(Nodito r) {
		if(r!=null) {
			return inorden2(r.der)+" - "+r.getInfo()+" - "+inorden2(r.izq);
		}
		else return"";
	}
	public String postorden(Nodito r) {
		if(r!=null) {
			return r.getInfo()+" - "+postorden(r.izq)+" - "+postorden(r.der);
		} else return"";
	}
}

