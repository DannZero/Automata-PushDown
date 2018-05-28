package pushdownautomata;

import java.util.*;

/**
 *
 * @author Daniel Ponce de León
 */
public class AutomataPushDown {

    public List<String> estados;
    public String estadoInicial;
    public List<String> estadosFinales;
    //simbolos del alfabeto de un solo char
    public char[] alfabetoEntrada;  //minusculas
    public char[] alfabetoPila;
    public List<String[]> funcionTransicion;

    public AutomataPushDown(List<String> estados, String estadoInicial,
            List<String> estadosFinales, char[] alfabetoEntrada,
            char[] alfabetoPila, List<String[]> funcionTransicion) {
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinales = estadosFinales;
        this.alfabetoEntrada = alfabetoEntrada;
        this.alfabetoPila = alfabetoPila;
        this.funcionTransicion = funcionTransicion;
    }

    public void imprimirAPD() {
        System.out.println(
                "Automata Pushdown: M = (Q, E, Y, d, q_0, F)"
                + "\nQ (estados)\t\t= " + this.estados
                + "\nq_0 (estado inicial)\t= " + this.estadoInicial
                + "\nF (estados finales)\t= " + this.estadosFinales
                + "\nE (alfabeto de entrada)\t= " + Arrays.toString(this.alfabetoEntrada)
                + "\nY (alfabeto de pila)\t= " + Arrays.toString(this.alfabetoPila)
        );
        System.out.print("d (funcion transicion)\t=\t");
        for (String[] tupla : funcionTransicion) {
            System.out.print("( " + tupla[0] + ", " + tupla[1] + ", " + tupla[2] + " ; " + tupla[3] + ", " + tupla[4] + " ), ");
        }
    }

}
