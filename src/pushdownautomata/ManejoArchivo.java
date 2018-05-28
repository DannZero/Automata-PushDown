package pushdownautomata;

import java.io.*;
import java.util.*;

/**
 *
 * @author Danniel Ponce de León
 */
public class ManejoArchivo {

    public static List<List<String>> obtenerColumnas(String path, String separador) {
        List<List<String>> columnas = new ArrayList<>();
        try (Scanner input = new Scanner(new BufferedReader(new FileReader(path)))) {
            String[] simbolos;
            while (input.hasNext()) {
                simbolos = input.nextLine().split(separador);
                columnas.add(Arrays.asList(simbolos));
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
        return columnas;
    }

    /*
     * Primer elemento: alfabetoEntrada
     * Segundo elemento: alfabetoPila
     */
    public static char[] obtenerAlfabetos(List<List<String>> archivo) {
        String alfabeto = "";
        //itera sobre cada linea de cada columna
        for (List<String> linea : archivo) {
            if (linea.get(0).matches("[a-z]")) {
                alfabeto = alfabeto + linea.get(0);
            }
        }
        return alfabeto.toCharArray();
    }

    public static List<String[]> obtenerFuncionTransicion(List<List<String>> archivo) {
        List<String[]> funcion = new ArrayList<>();
        for (List<String> linea : archivo) {
            //Agrego todas las tuplas como (2,lambda,parte izquierda,2,parte derecha)
            funcion.add(new String[]{"2", "lambda", linea.get(0), "2", linea.get(1)});
        }
        return funcion;
    }

    public static void main(String[] args) {
        List<List<String>> stringsArchivo = ManejoArchivo.obtenerColumnas("APD.txt", "->");
        AutomataPushDown apd = new AutomataPushDown(
                Arrays.asList(new String[]{"0", "1", "2"}), //Estados
                "0", //Estado inicial
                Arrays.asList(new String[]{"2"}), //Estados finales
                ManejoArchivo.obtenerAlfabetos(stringsArchivo), //Alfabeto entrada
                "aSPbTR".toCharArray(), //aLfabeto de pila
                ManejoArchivo.obtenerFuncionTransicion(stringsArchivo)); //funcion de transicion
        apd.imprimirAPD();
    }

}
