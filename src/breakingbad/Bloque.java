/*
 * Clase Bloque
 *
 * @author Marco Ramírez A01191344
 * @author Alfredo Altamirano A01191157
 * @date 03/08/14
 * @version 1.0
 */

package breakingbad;

import java.io.PrintWriter;
import java.util.Scanner;

public class Bloque extends Base {

    //Constantes strings
    private static final String STR1 = "CAPTURADO";
    private static final String STR2 = "PAUSADO";

    /**
     * Metodo constructor que hereda los atributos de la clase
     * <code>Base</code>.
     *
     * @param posX es la <code>posiscion en x</code> del objeto Bloque.
     * @param posY es el <code>posiscion en y</code> del objeto Bloque.
     * @param anima es la <code>animacion</code> del objeto Bloque.
     */
    public Bloque(int posX, int posY, Animacion anima) {
        super(posX, posY, anima);
    }

    /**
     * Metodo <I>getStr1</I> sobrescrito de la clase <code>Bloque</code>.<P>
     * En este metodo se regresa el valor de STR1.
     *
     * @return  regresa el valor de STR1 de tipo <code>String</code>
     */
    public String getStr1() {
        return STR1;
    }

    /**
     * Metodo <I>init</I> sobrescrito de la clase <code>Bloque</code>.<P>
     * En este metodo se regresa el valor de STR2.
     *
     * @return  regresa el valor de STR2 de tipo <code>String</code>
     */
    public String getStr2() {
        return STR2;
    }

    //hereda javadoc de base
    public void guardar(PrintWriter writer) {
        super.guardar(writer);
    }

    //hereda javadoc de base
    public void cargar(Scanner scanner) {
        super.cargar(scanner);
    }
}
