/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package breakingbad;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Una escena del juego, tiene sus eventos independientes de otras escenas
 * @author Alfredo_Altamirano
 */
public abstract class Escena implements KeyListener, MouseListener {

   
     /**
     * Metodo usado para actualizar la posicion de objetos bola y canasta.
     * Actualiza animacion de objetos bola y canasta.
     * Actualiza vidas y bolas caidas.
     * @param tiempoTranscurrido el tiempo que transcurrio del frame anterior a este
     */
    public void actualiza(long tiempoTranscurrido) {
        
    }
    
     /**
     *  En este metodo se dibuja la imagen con la posicion actualizada, ademas
     * que cuando la imagen es cargada te despliega una advertencia.
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public abstract void dibuja(Graphics g);
    
    /**
     * Metodo <I>keyPressed</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar cualquier la
     * tecla.
     *
     * @param e es el <code>evento</code> generado al presionar las teclas.
     */
    public void keyPressed(KeyEvent e) {
        
    }

    /**
     * Metodo <I>keyTyped</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una tecla que
     * no es de accion.
     *
     * @param e es el <code>evento</code> que se genera en al presionar las
     * teclas.
     */
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Metodo <I>keyReleased</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla
     * presionada.
     *
     * @param e es el <code>evento</code> que se genera en al soltar las teclas.
     */
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Metodo <I>mousePressed</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar el mouse sobre
     * el objeto bola y variable click se vuelve verdadera
     *
     * @param e es el <code>evento</code> que se genera en al presionar el mouse
     * sobre la bola.
     */
    public void mousePressed(MouseEvent e) {
        
    }

    /**
     * Metodo <I>mouseReleased</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar el boton del
     * mouse y la variable bool se regresa a falsa.
     *
     * @param e es el <code>evento</code> que se genera en al soltar el boton
     * del mouse y click se vuelve falsa.
     */
    public void mouseReleased(MouseEvent e) {
        
    }

    /**
     * Metodo <I>mouseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar el boton del
     * mouse.
     *
     * @param e es el <code>evento</code> que se genera en al presionar el boton
     * del mouse.
     */
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Metodo <I>mouseEntered</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al entrar el mouse.
     *
     * @param e es el <code>evento</code> que se genera en al entrar el mouse.
     */
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Metodo <I>mouseExited</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al salir el mouse.
     *
     * @param e es el <code>evento</code> que se genera en al salir el mouse.
     */
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Metodo <I>mouseDragged</I> sobrescrito de la interface
     * <code>MouseMotionListener</code>.<P>
     * En este metodo maneja el evento que se genera al mover un objeto con el
     * mouse y se cambia la posicion del objeto respecto al mouse.
     *
     * @param e es el <code>evento</code> que se genera al mover el mouse.
     */
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Metodo <I>mouseMoved</I> sobrescrito de la interface
     * <code>MouseMotionListener</code>.<P>
     * En este metodo maneja el evento que se genera al mover el mouse.
     *
     * @param e es el <code>evento</code> que se genera en al mover el mouse
     */
    public void mouseMoved(MouseEvent e) {

    }
    
}
