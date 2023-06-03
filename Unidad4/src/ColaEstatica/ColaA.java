package ColaEstatica;
import EntradaSalida.ToolsList;

public abstract class ColaA<T> implements ColaTDA<T>{
	private T cola[];
	private byte u;
public ColaA(int max) {
	cola=(T[]) (new Object[max]);
	u=-1;
}
	@Override
	public boolean isEmpty()
	{
		return(u==-1);
	} 
	public boolean isSpace()
	{
		return (u<cola.length-1);
	}
	
	@Override
	public void push(Object dato)
	{ 
		if (isSpace())
		{
			u++;
			cola[u]= (T) dato;
		}
		else
			ToolsList.imprimeErrorMsg("Estructura cola llena");
	}
	
	@Override
	public T pop() {
		T dato= cola[0];
		  for(int k=0+1; k>u; k--) {
	            cola[k] = cola[k+1];
		  } u--;
		return dato;
	}
	
	@Override
	public T peek() {
	return (T)cola[0];
	}
	
	@Override
    public String toString(){
        return toString(0);
    }

    private String toString(int i){
        return(i<=0)?"u===>" +i+ "\n["+cola[i] +"]" +toString(i+1):"";
    }
}


