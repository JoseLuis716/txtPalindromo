package txtpalindromo;

import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class TxtPalindromo {

    public static void main(String[] args) throws IOException {
        //
        BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\josel\\Documents\\NetBeansProjects\\txtPalindromo\\src\\txtpalindromo\\archivo.txt"));
        String sCadena;
        String palabra = "";
        while ((sCadena = bf.readLine()) != null) {
            System.out.println(sCadena);
            palabra += sCadena;
        }
        String palabra2 = palabra.toLowerCase().replace(" ", "");
        String palindromo = "";

        char[] invertir = palabra2.toCharArray();

        for (int i = invertir.length - 1; i >= 0; i--) {
            palindromo += invertir[i];
        }
        JOptionPane.showMessageDialog(null, (palabra2.equals(palindromo) ? "'" + palabra + "' es un palíndromo" : "'" + palabra + "' NO es un palíndromo"));

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\josel\\Documents\\NetBeansProjects\\txtPalindromo\\src\\txtpalindromo\\archivo.txt");
            pw = new PrintWriter(fichero);
            String nombre = "";
            String strNombres = JOptionPane.showInputDialog("¿Cuantos nombres quieres escribir?");
            int Nombres = Integer.parseInt(strNombres);
            for (int i = 0; i < Nombres; i++) {
                nombre = JOptionPane.showInputDialog("Escribe un nombre");
                nombre = nombre.toUpperCase();
                pw.println(nombre);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Se ha introducido un dato erroneo, el txt se quedará en blanco", "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            try {
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
                JOptionPane.showMessageDialog(null, "Cambios realizados", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
