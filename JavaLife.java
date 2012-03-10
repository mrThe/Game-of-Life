/**
 * @author mr.The
 * @skype mr-the
 * @twitter @mr_The
 */

package javalife;
import javax.swing.*;

/**
 * Main class.
 */
public class JavaLife {
     TorArray data;
     boolean calc=false;
     int cell_size=10;
     
     
    public static void main(String[] args)  {
        JFrame f = new JFrame("Game of Life");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(630,630); //canvas size

        f.validate();
        f.setVisible(true);
        f.toFront();
        
        GCanvas canvas = new GCanvas();
        f.getContentPane().add(canvas);
        
        JavaLife jl = new JavaLife(); 
        jl.init(canvas, 60, 60); // array size

        for(;;) { // main cycle
            
            if(jl.calc)
                jl.calc(); //recalc
            jl.draw(canvas); //redraw
            
            try {
                Thread.sleep(50); //pause
            } catch (Exception e) {}
        }
   
    }
    
    public void init(GCanvas canvas, int w, int h) {
        canvas.setCellSize(cell_size);
        
        data = new TorArray(w, h);
        GMouseListener mouseListener = new GMouseListener();
        mouseListener.setCellSize(cell_size);
        mouseListener.setLife(this);
        
        GKeyListener keyListener = new GKeyListener();
        keyListener.setLife(this);


        canvas.addMouseListener(mouseListener);
        canvas.addMouseMotionListener(mouseListener);
        canvas.addKeyListener(keyListener);

        cleanArray();
        
    }
    
    public void cleanArray() {
        for(int i=0; i<data.getWidth(); i++) {
            for(int j=0; j<data.getHeight(); j++) {
                data.setCell(i, j, 0);
            }
        }
    }
    
    public void calc() {
        TorArray temp = new TorArray(data.getWidth(), data.getHeight());

        for(int i=0; i<data.getWidth(); i++) {
            for(int j=0; j<data.getHeight(); j++) {
                int count = data.getCellsCount(i, j);
                //rule 1 // рождаемость
                if(data.getCell(i, j)==0 && count==3) temp.setCell(i, j, 1);
                
                //rule 2 перенаселённость
                else if(data.getCell(i, j)==1 &&  count>3) temp.setCell(i, j, 0);
                
                //rule 3 одиночество
                else if(data.getCell(i, j)==1 &&  count<2) temp.setCell(i, j, 0);
                
                else temp.setCell(i, j, data.getCell(i, j));
                
            }
        }
        
        data=temp;
    }
    
    
    public void draw(GCanvas canvas) {
        canvas.setLife(this);
        
        canvas.repaint();
    }


}
