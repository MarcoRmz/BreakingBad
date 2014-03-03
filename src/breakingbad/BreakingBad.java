/*
 * Juego en JFrame Breaking Bad
 *
 * @author Marco Ramírez A01191344
 * @author Alfredo Altamirano A01191157
 * @date 03/08/14
 * @version 1.0
 */

package breakingbad;

import javax.swing.JFrame;

public class BreakingBad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego app = new Juego();
        app.setVisible(true); 
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
