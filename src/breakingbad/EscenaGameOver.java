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

/**
 *  La escena de game over
 * @author Alfredo_Altamirano
 */
class EscenaGameOver extends Escena {

    private Image fondo; //el fondo de la escena de game over
    
    /**
     * Constructor de la escena de game over
     * inicializa la escena
     */
    public EscenaGameOver() {
        fondo = Toolkit.getDefaultToolkit().getImage("src/breakingbad/gameover.png");
    }
    
    @Override
    public void dibuja(Graphics g) {
        g.drawImage(fondo, 0, 0, null);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            Juego.cambiarEscena(new EscenaJuego());
        }
    }
}
