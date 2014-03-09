/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakingbad;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Alfredo_Altamirano
 */
public final class EscenaJuego extends Escena {

    
    private long tiempoActual; //tiempo para manejar animaciones
    private final Barra barra; //lobjeto de la clase barra
    private final Bola bola; //objeto de la clase bola
    private final Bloque bloques[][]; //matriz de bloques que se rompen
    private final int VELOCIDAD_BARRA = 5; 
    private boolean derPres, izqPres; //verdadero si esta presionado el boton
    private int ROWS = 5, COLS = 16; //numero de filas y columnas de bloques
    private int numbloques = ROWS*COLS; //numero de bloques restantes
    private boolean pausa = false; //indica si esta pausado el juego
    private SoundClip breakAudio; //el audio de cuando se rompe un bloque
    private Image fondo;

    /**
     * Inicializa la escena de juego a un nuevo juego
     */
    public EscenaJuego() {
        fondo = Toolkit.getDefaultToolkit().getImage("src/breakingbad/gamebkg.png");
        barra = new Barra(Juego.WIDTH / 2, Juego.HEIGHT); //se inicializa la barra enmedio abajo
        barra.setPosX(barra.getPosX() - barra.getAncho()/2);
        barra.setPosY(barra.getPosY() - barra.getAlto());
        bola = new Bola(Juego.WIDTH / 2, Juego.HEIGHT *3/4); //se crea la bola en el centro
        bola.setVelocidadY(4); //se inicializa su velocidad
        bola.setVelocidadX(1);
        bloques = new Bloque[COLS][ROWS];
        breakAudio = new SoundClip("break.wav");
        tiempoActual = System.currentTimeMillis();
        inicializaBloques();
    }
    
    //inicializa la lista de bloques a bloques random
    private void inicializaBloques() {
        Random r = new Random();
        for(int i = 0; i < bloques.length; i++) {
            for(int j = 0; j < bloques[i].length; j++) {
                bloques[i][j] = new Bloque(0, 0, r.nextInt(3) + 1);
                bloques[i][j].setPosX(5 + (bloques[i][j].getAncho()+4)*i); //los acamoda dependiendo de
                bloques[i][j].setPosY(125 + (bloques[i][j].getAlto()+4)*j); //su posicion en el arreglo
            }
        }
    }

    @Override
    public void actualiza(long tiempoTranscurrido) {
        if(pausa) { //si esta pausado, no se actualiza
            return;
        }
        
        checaColision();
        
        //actualiza las animaciones
        bola.getAnimacion().actualiza(tiempoTranscurrido);
        barra.getAnimacion().actualiza(tiempoTranscurrido);
        if(numbloques == 0) { //si ya no hay bloques, se cambia a la escena de gameover
            Juego.cambiarEscena(Juego.gameover);
            return;
        }
        
        //se actualiza la bola dependiendo de su velocidad
        bola.setPosX((int) (bola.getPosX() + bola.getVelocidadX()));
        bola.setPosY(bola.getPosY() + bola.getVelocidadY());
        
        //se mueve la barra si se presionan las flechas
        if(derPres) {
            barra.setPosX(barra.getPosX() + VELOCIDAD_BARRA);
        }
        if(izqPres) {
            barra.setPosX(barra.getPosX() - VELOCIDAD_BARRA);
        }
    }

    public void checaColision() {
        //checa colision de barra con la ventana para que no se salga
        if (barra.getPosX() < 0) {
            barra.setPosX(0);
        } else if (barra.getPosX() + barra.getAncho() > Juego.WIDTH) {
            barra.setPosX(Juego.WIDTH - barra.getAncho());
        }
        
        //checa colision de la bola con la ventana para que no se salga y se ajusta para evitar otra colision
        if (bola.getPosX() < 0) {
            bola.setPosX(0);
            bola.setVelocidadX(-bola.getVelocidadX());
        } else if (bola.getPosX() + bola.getAncho() > Juego.WIDTH) {
            bola.setPosX(Juego.WIDTH - bola.getAncho());
            bola.setVelocidadX(-bola.getVelocidadX());
        }
        
        //colision de la bola arriba y abajo
        if(bola.getPosY() < 25) {
            bola.setPosY(25);
            bola.setVelocidadY(-bola.getVelocidadY());
        } else if (bola.getPosY() + bola.getAlto() > Juego.HEIGHT) { //vuelve a empezar
            bola.setPosX(Juego.WIDTH / 2);
            bola.setPosY(Juego.HEIGHT * 3/4);
            bola.setVelocidadY(4);
            bola.setVelocidadX(1);
        }

        //checa colision de barra con la bola y la rebota si colisionan
        if (barra.intersecta(bola)) {
            if(bola.getPosY() + bola.getAlto() > barra.getPosY() + 20) {
                bola.setVelocidadY(-bola.getVelocidadY()); //rebote
                bola.setPosY(barra.getPosY() - bola.getAlto() - 1 + 20); //acomoda la pelota para que no haya mas colisiones
                int dx = barra.getPosX() + barra.getAncho()/2 - bola.getPosX() - bola.getAncho()/2;
                if(dx < 0) { //la velocidad depende de en que posicion pega la pelota
                    bola.setVelocidadX(Math.abs(bola.getVelocidadX()));
                } else { 
                    bola.setVelocidadX(-Math.abs(bola.getVelocidadX()));
                }
                if(Math.abs(dx) > barra.getAncho()/2) { //si pega en una orilla de la barra, incrementa la velocidad
                    bola.setVelocidadX(bola.getVelocidadX() + (bola.getVelocidadX() > 0 ? 2 : -2));
                }
            }
        }
        
        List<Integer> removidos = new ArrayList<>(); //lista de bloques que se removeran
        //interseccion entre bola y bloque para cada bloque
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                Bloque bloque = bloques[i][j];
                if (bloque != null) {
                    if (bola.intersecta(bloque)) {
                        int dx = bloque.getPosX() + bloque.getAncho()/2 - bola.getPosX() - bola.getAncho()/2;
                        int dy = bloque.getPosY() + bloque.getAlto()/2 - bola.getPosY() - bola.getAlto()/2;
                        if (Math.abs(dx) < Math.abs(dy)) { //si pega por arriba/abajo
                            if(bola.getVelocidadY() < 0) { //si pega por abajo
                                bola.setPosY(bloque.getPosY() + 1 + bloque.getAlto());
                                bola.setVelocidadY(Math.abs(bola.getVelocidadY()));
                            } else { //por arriba
                                bola.setPosY(bloque.getPosY() - 1 - bola.getAlto()); //se ajusta la posicion
                                bola.setVelocidadY(-Math.abs(bola.getVelocidadY())); //rebota
                            }
                        } else { //si pega por un lado
                            if(bola.getVelocidadX() < 0) { //si pega por la derecha
                                bola.setPosX(bloque.getPosX() + bloque.getAncho() + 1);
                                bola.setVelocidadX(Math.abs(bola.getVelocidadX()));
                            } else { //por la izquierda
                                bola.setPosX(bloque.getPosX() - 1 - bola.getAncho());
                                bola.setVelocidadX(-Math.abs(bola.getVelocidadX()));
                            }
                            
                        }
                        breakAudio.stop();
                        breakAudio.play(); //se reproduce el sonido
                        if(bloques[i][j].hit()) { //se golpea el bloque y si se rompe, se decrementa el numero de bloques restantes
                            bloques[i][j] = null;
                            numbloques--;
                        }
                    }
                }
            }
        }
        
    }

    @Override
    public void dibuja(Graphics g) {
        g.drawImage(fondo, 0, 0, null);
        
        if(pausa) {
            g.drawString("PAUSA", 600, 400); //si esta pausado, se escribe pausa en la pantalla
        }
        
        barra.dibuja(g); //dibuja la barra
        
        //dibuja los bloques
        for (Bloque[] fila : bloques) {
            for (Bloque bloque : fila) {
                if(bloque != null) {
                    bloque.dibuja(g); 
                }
            }
        }
        
        //dibuja la bola
        bola.dibuja(g);
    }
        
    @Override
    public void keyPressed(KeyEvent e) {
        if(pausa) { //si esta pausado, no se procesa el evento
            return;
        }
        //se marca como no presionada la tecla para no mover la barra
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                derPres = true;
                break;
            case KeyEvent.VK_LEFT:
                izqPres = true;
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_P) { //se cambia la pausa al presionar p
            pausa = !pausa;
        }
        if(pausa) { //si esta pausado, no se procesa el evento
            return;
        }
        //se marca como presionada la tecla para mover la barra
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                derPres = false;
                break;
            case KeyEvent.VK_LEFT:
                izqPres = false;
                break;
        }
    }
        
}
