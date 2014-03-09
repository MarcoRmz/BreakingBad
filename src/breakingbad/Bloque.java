/*
 * Clase Bloque
 *
 * @author Marco Ramírez A01191344
 * @author Alfredo Altamirano A01191157
 * @date 03/08/14
 * @version 1.0
 */

package breakingbad;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bloque extends Base {

    private boolean danado = false;
    private int tipo;
    
    /**
     * Metodo constructor que hereda los atributos de la clase
     * <code>Base</code>.
     *
     * @param posX es la <code>posiscion en x</code> del objeto Bloque.
     * @param posY es el <code>posiscion en y</code> del objeto Bloque.
     * @param anima es la <code>animacion</code> del objeto Bloque.
     */
    public Bloque(int posX, int posY, int tipo) {
        super(posX, posY, crearAnimacionBloque(tipo));
        this.tipo = tipo;
    }
    
    //crea la animacion del bloque
    private static Animacion crearAnimacionBloque(int tipo) {
        Image bloque1 = Toolkit.getDefaultToolkit().getImage("src/breakingbad/bloque" + tipo + "1.png");

        //Se crea la animación del bloque
        Animacion anima = new Animacion();
        anima.sumaCuadro(bloque1, 150);
        return anima;
    }

    /**
     * Se llama cuando se golpea el bloque.
     * Si el bloque no estaba dañado, se marca como dañado
     * Si ya estaba dañado, regresa que se debe destruir
     * @return si el bloque se debe destruir o no
     */
    public boolean hit() {
        if(!danado) {
            Image bloque2 = Toolkit.getDefaultToolkit().getImage("src/breakingbad/bloque" + tipo + "2.png");
            Animacion anima = new Animacion();
            anima.sumaCuadro(bloque2, 150);
            this.setAnimacion(anima);
            danado = true;
            return false;
        }
        return true;
    }

}
