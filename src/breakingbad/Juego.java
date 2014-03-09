/*
 * Clase Juego
 *
 * @author Marco Ramírez A01191344
 * @author Alfredo Altamirano A01191157
 * @date 03/08/14
 * @version 1.0
 */

package breakingbad;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

public final class Juego extends JFrame implements Runnable {

    public static Juego instance;
    public static final int WIDTH = 1200, HEIGHT = 800;
    
    // Se declaran las variables.
    //Objetos de la clase Animacion para el manejo de la animación
    private Animacion animaBola;
    private Animacion animaCanasta;
    private Image dbImage;	// Imagen a proyectar
    private Escena escena; //la escena actual
    public static Escena intro, menu, juego, gameover;
    private Graphics dbg;

    //Variables de control de tiempo de la animación
    private long tiempoActual;

    private static final long serialVersionUID = 1L;
    
    public Juego() {
        instance = this;
        init();
        start();
    }
        
    /**
     * En este metodo se inicializan las variables o se crean los objetos a
     * usarse en el <code>JFrame</code> y se definen funcionalidades.
     */
    public void init() {
        setSize(WIDTH, HEIGHT);  //Declara el tamaño del applet
        setBackground(Color.BLUE);
        
        juego = new EscenaJuego();
        gameover = new EscenaGameOver();
        cambiarEscena(juego);
        
    }
    
    public static void cambiarEscena(Escena escena) {
        if(instance.escena != null) { //si hay una escena, se finaliza
            instance.removeKeyListener(escena);
            instance.removeMouseListener(escena);
        }
        instance.escena = escena; //se cambia a la siguiente escena y se registran los listeners
        instance.addKeyListener(escena);
        instance.addMouseListener(escena);
    }

    /**
     * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo para la animacion este metodo
     * es llamado despues del init <code>Applet</code>
     *
     */
    public void start() {
        // Declaras un hilo
        Thread th = new Thread(this);
        // Empieza el hilo
        th.start();
    }

    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se
     * incrementa la posicion en x o y dependiendo de la direccion, finalmente
     * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
     *
     */
    public void run() {
        //Guarda el tiempo actual del sistema
        tiempoActual = System.currentTimeMillis();

        while (true) {
            //Checa si la variable bool pausa o instrucciones o guarda es diferente a true para detener el juego
            //Determina el tiempo que ha transcurrido desde que el Applet inicio su ejecución
            long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;
            //Guarda el tiempo actual
            tiempoActual += tiempoTranscurrido;
            escena.actualiza(tiempoTranscurrido);
            repaint(); // Se actualiza el <code>Applet</code> repintando el contenido.
            try {
                // El thread se duerme.
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }
    }

   /**
     * Metodo <I>update</I> sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics g) {
        // Inicializan el DoubleBuffer
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

        // Actualiza la imagen de fondo.
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        // Actualiza el Foreground.
        dbg.setColor(getForeground());
        escena.dibuja(dbg);

        // Dibuja la imagen actualizada
        g.drawImage(dbImage, 0, 0, this);
    }

}
