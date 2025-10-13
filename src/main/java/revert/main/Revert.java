package revert.main;

import java.util.Stack;
import java.io.*;

public class Revert {

    private Stack<Character> pila = new Stack<>();

    public String inversionPalabra(String cadena) {
        for (char c : cadena.toCharArray()) {
            pila.push(c);
        }

        StringBuilder invertido = new StringBuilder();
        while (!pila.empty()) {
            invertido.append(pila.pop());
        }
        return invertido.toString();
    }

    public static void main(String[] args) {
        Revert r = new Revert();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Input.txt"));
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            reader.close();

            String resultado = r.inversionPalabra(contenido.toString());

            BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"));
            writer.write(resultado);
            writer.close();

            System.out.println("Archivo invertido correctamente");
        } catch (IOException e) {
            System.out.println("Error al leer o escribir archivos: " + e.getMessage());
        }
    }
}
