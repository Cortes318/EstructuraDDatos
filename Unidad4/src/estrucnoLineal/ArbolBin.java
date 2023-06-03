package estrucnoLineal;

public class ArbolBin<T> {
    private Nodito raiz;

    public ArbolBin() {
        raiz = null;
    }

    public Nodito getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodito raiz) {
        this.raiz = raiz;
    }

    public boolean arbolVacio() {
        return raiz == null;
    }

    public void vaciarArbol() {
        raiz = null;
    }

    public void insertarArbol(T info) {
        Nodito p = new Nodito(info);
        if (arbolVacio()) {
            raiz = p;
        } else {
            Nodito padre = buscaPadre(raiz, p);
            if (p.hashCode() >= padre.hashCode())
                padre.der = p;
            else
                padre.izq = p;
        }
    }

    public Nodito buscaPadre(Nodito actual, Nodito p) {
        Nodito padre = null;
        while (actual != null) {
            padre = actual;
            if ((int) p.info >= (int) padre.info)
                actual = padre.der;
            else
                actual = padre.izq;
        }
        return padre;
    }

    public String preorden(Nodito r) {
        if (r != null) {
            return r.info + "." + preorden(r.izq) + "." + preorden(r.der);
        } else return "";
    }

    public String inorden(Nodito r) {
        if (r != null) {
            return inorden(r.izq) + " - " + r.getInfo() + " - " + inorden(r.der);

        } else return "";
    }

    public String inorden2(Nodito r) {
        if (r != null) {
            return inorden2(r.der) + " - " + r.getInfo() + " - " + inorden2(r.izq);
        } else return "";
    }

    public String postorden(Nodito r) {
        if (r != null) {
            return r.getInfo() + " - " + postorden(r.izq) + " - " + postorden(r.der);
        } else return "";
    }
    
    public int altura(Nodito nodo) {
        if (nodo == null)
            return -1;
        else {
            int alturaIzq = altura(nodo.izq);
            int alturaDer = altura(nodo.der);
            return Math.max(alturaIzq, alturaDer) + 1;
        }
    }
    
    public void terminales(Nodito nodo) {
        if (nodo != null) {
            if (nodo.izq == null && nodo.der == null)
                System.out.println(nodo.info);
            terminales(nodo.izq);
            terminales(nodo.der);
        }
    }
    
    public void interiores(Nodito nodo) {
        if (nodo != null) {
            if (nodo.izq != null || nodo.der != null)
                System.out.println(nodo.info);
            interiores(nodo.izq);
            interiores(nodo.der);
        }
    }

    public Nodito buscar(T dato) {
        return buscarNodo(raiz, dato);
    }

    private Nodito buscarNodo(Nodito nodo, T dato) {
        if (nodo == null || dato.equals(nodo.info)) {
            return nodo;
        }
        Nodito nodoEncontrado = buscarNodo(nodo.izq, dato);
        if (nodoEncontrado == null) {
            nodoEncontrado = buscarNodo(nodo.der, dato);
        }
        return nodoEncontrado;
    }

    public void visualizar() {
        visualizarArbol(raiz, 0);
    }

    private void visualizarArbol(Nodito nodo, int nivel) {
        if (nodo != null) {
            visualizarArbol(nodo.der, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            System.out.println(nodo.info);
            visualizarArbol(nodo.izq, nivel + 1);
        }
    }

    public class Nodito {
        private T info;
        private Nodito izq;
        private Nodito der;

        public Nodito(T info) {
            this.info = info;
            izq = null;
            der = null;
        }

        public T getInfo() {
            return info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public Nodito getIzq() {
            return izq;
        }

        public void setIzq(Nodito izq) {
            this.izq = izq;
        }

        public Nodito getDer() {
            return der;
        }

        public void setDer(Nodito der) {
            this.der = der;
        }
    }
}
