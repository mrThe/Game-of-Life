/**
 * @author mr.The
 * @skype mr-the
 * @twitter @mr_The
 */

package javalife;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Keyboard Listener.
 * Pause(space) and clear(esc)
 */
public class GKeyListener implements KeyListener{
    JavaLife life;

    public void setLife(JavaLife life) {
        this.life = life;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode() == 32) {
            if(life.calc == true)
                life.calc=false;
            else
                life.calc=true;
        } else if(ke.getKeyCode() == 27) {
            life.cleanArray();
        }
        
        //System.out.println("Key "+ke.getKeyCode());
    }
    
}
