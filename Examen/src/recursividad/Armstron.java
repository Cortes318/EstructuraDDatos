package recursividad;

public class Armstron {

	    public static boolean esNumeroArmstrong(int numero) {
	        int n = contarDigitos(numero);
	        int suma = sumarPotenciasDigitos(numero, n);
	        return numero == suma;
	    }

	    private static int contarDigitos(int numero) {
	        if (numero == 0) {
	            return 0; 
	        }
	        return 1 + contarDigitos(numero / 10); 
	    }

	    private static int sumarPotenciasDigitos(int numero, int n) {
	        if (numero == 0) {
	            return 0; 
	        }
	        int ultimoDigito = numero % 10;
	        return (int) Math.pow(ultimoDigito, n) + sumarPotenciasDigitos(numero / 10, n); 
	    }
	}
