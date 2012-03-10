/**
 * @author mr.The
 * @skype mr-the
 * @twitter @mr_The
 */

package javalife;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.event.MouseInputAdapter;

/**
 * Mouse Listener.
 * Draw with mouse
*/
public class GMouseListener  extends MouseInputAdapter implements MouseMotionListener   {
    int oldx = -1;
    int oldy = -1;
    JavaLife life;
    int cell_size;

    public void setCellSize(int cell_size) {
        this.cell_size = cell_size;
    }

    public void setLife(JavaLife life) {
        this.life = life;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
       updateSize(e);
    }
    
    @Override
     public void mouseDragged(MouseEvent e) {
        updateSize(e);
    }
     
    @Override
    public void mouseReleased(MouseEvent e) {
        oldx=-1;
        oldy=-1;
   }
     
    void updateSize(MouseEvent e) {
        int x=e.getX()/cell_size;
        int y=e.getY()/cell_size;
        
        if((x==oldx && y==oldy)) {
          return;  
        }
            
        oldx=x;
        oldy=y;


        if(life.data.getCell(x, y) == 1)
                life.data.setCell(x, y, 0);
        else
            life.data.setCell(x, y, 1);

        //System.out.println("Mouse pressed; x:  " + x);
       
    }
   
}
