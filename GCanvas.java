/**
 * @author mr.The
 * @skype mr-the
 * @twitter @mr_The
 */

package javalife;

import java.awt.*;

/**
 * Draw Canwas.
*/
class GCanvas extends Canvas {
    private Color color = new Color(200, 200, 200);
    JavaLife life;
    int cell_size=10;

    public void setCellSize(int cell_size) {
        this.cell_size = cell_size;
    }

    public void setLife(JavaLife life) {
        this.life = life;
    }

    public void setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }

    public Color getColor() {
        return color;
    }
    
    @Override
    public void paint(Graphics g)  {           
        Dimension size = size(); 
        g.setColor(getColor());
        
        g.fillRect(0,0, size.width, size.height); 

        g.setColor(new Color(0, 0, 0));
        for(int i=0; i<life.data.getWidth(); i++) {
            for(int j=0; j<life.data.getHeight(); j++) {
                if(life.data.getCell(i, j) ==1)
                        g.fillOval(i*cell_size, j*cell_size, cell_size, cell_size); 

            }
        }
           //System.out.println("repaint");
    }
    
    /**
     *  Double buffering
     */
    @Override
     public void update(Graphics g) {
        Graphics offgc;
        Image offscreen = null;
        Rectangle box = g.getClipRect();

        // create the offscreen buffer and associated Graphics
        offscreen = createImage(box.width, box.height);
        offgc = offscreen.getGraphics();
        // clear the exposed area
        offgc.setColor(getBackground());
        offgc.fillRect(0, 0, box.width, box.height);
        offgc.setColor(getForeground());
        // do normal redraw
        offgc.translate(-box.x, -box.y);
        paint(offgc);
        // transfer offscreen to window
        g.drawImage(offscreen, box.x, box.y, this);
    }
 
}
