package recursividad;
import javax.swing.JOptionPane;

public class MenuArmstrong {
    public static void main(String[] args) {
        int opcion;

        do {
            String menu = "Menú de Números de Armstrong\n"
                    + "1. Verificar si un número es de Armstrong\n"
                    + "0. Salir\n"
                    + "Ingrese una opción: ";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            switch (opcion) {
                case 1:
                    int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un número: "));
                    if (Armstron.esNumeroArmstrong(numero)) {
                        JOptionPane.showMessageDialog(null, numero + " es un número de Armstrong.");
                    } else {
                        JOptionPane.showMessageDialog(null, numero + " no es un número de Armstrong.");
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

        } while (opcion != 0);
    }
}

