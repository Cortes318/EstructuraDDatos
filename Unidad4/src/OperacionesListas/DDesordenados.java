package OperacionesListas;

public interface DDesordenados <T>{

    public boolean validaVacio();

    public void agregar(T dato);

    public void modificar(T dato);

    public void elimina(T dato);

    public byte buscar(T dato);

    public void vaciar();

    public String visualizar();

}