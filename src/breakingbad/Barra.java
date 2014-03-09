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

public class Barra extends Base {

    /**
     * Metodo constructor que hereda los atributos de la clase
     * <code>Base</code>.
     *
     * @param posX es la <code>posiscion en x</code> del objeto Bloque.
     * @param posY es el <code>posiscion en y</code> del objeto Bloque.
     */
    public Barra(int posX, int posY) {
        super(posX, posY, crearAnimacionBarra());
    }   
    
    //crea la animacion de la barra
    private static Animacion crearAnimacionBarra() {
        Image barra = Toolkit.getDefaultToolkit().getImage("src/breakingbad/barra.png");
        Image barra2 = Toolkit.getDefaultToolkit().getImage("src/breakingbad/barra2.png");
        Image barra3 = Toolkit.getDefaultToolkit().getImage("src/breakingbad/barra3.png");

        //Se crea la animación de bola
        Animacion anima = new Animacion();
        anima.sumaCuadro(barra, 400);
        anima.sumaCuadro(barra2, 400);
        anima.sumaCuadro(barra3, 400);
        return anima;
    }


}
