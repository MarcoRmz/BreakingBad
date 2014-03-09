/*
 * Clase Bola
 *
 * @author Marco Ramírez A01191344
 * @author Alfredo Altamirano A01191157
 * @date 03/08/14
 * @version 1.0
 */

package breakingbad;

import java.awt.Image;
import java.awt.Toolkit;

public class Bola extends Base {

    //Variable contador
    private static int CONT = 0;
    //Variable velocidad en X y Y
    private double velocidadX;
    private int velocidadY;

    /**
     * Metodo constructor que hereda los atributos de la clase
     * <code>Base</code>.
     *
     * @param posX es la <code>posiscion en x</code> del objeto Bola.
     * @param posY es el <code>posiscion en y</code> del objeto Bola.
     */
    public Bola(int posX, int posY) {
        super(posX, posY, crearAnimacionBola());
    }
    
    //crea ka animacion de la bola
    private static Animacion crearAnimacionBola() {
        Image bola = Toolkit.getDefaultToolkit().getImage("src/breakingbad/bola.png");
        Image bola2 = Toolkit.getDefaultToolkit().getImage("src/breakingbad/bola2.png");

        //Se crea la animación de bola
        Animacion animaBola = new Animacion();
        animaBola.sumaCuadro(bola, 150);
        animaBola.sumaCuadro(bola2, 150);
        return animaBola;
    }

    /**
     * Metodo <I>setVelocidad</I> sobrescrito de la clase <code>Bola</code>.<P>
     * En este metodo se modifica la velocidadX con el parametro recibido.
     *
     * @param vel contiene la nueva velocidad de tipo <code>int</code>
     * @void
     */
    public void setVelocidadX(double vel) {
        velocidadX = vel;
    }

     /**
     * Metodo <I>setVelocidad</I> sobrescrito de la clase <code>Bola</code>.<P>
     * En este metodo se modifica la velocidadY con el parametro recibido.
     *
     * @param vel contiene la nueva velocidad de tipo <code>int</code>
     * @void
     */
    public void setVelocidadY(int vel) {
        velocidadY = vel;
    }

    /**
     * Metodo <I>getVelocidad</I> sobrescrito de la clase <code>Bola</code>.<P>
     * En este metodo se regresa el valor de la velocidadX.
     *
     * @return  regresa la velocidad de tipo <code>int</code>
     */
    public double getVelocidadX() {
        return velocidadX;
    }

    /**
     * Metodo <I>getVelocidad</I> sobrescrito de la clase <code>Bola</code>.<P>
     * En este metodo se regresa el valor de la velocidadY.
     *
     * @return  regresa la velocidad de tipo <code>int</code>
     */
    public int getVelocidadY() {
        return velocidadY;
    }
}
