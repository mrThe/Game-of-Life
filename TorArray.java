/**
 * @author mr.The
 * @skype mr-the
 * @twitter @mr_The
 */

package javalife;

/**
 * 2d array to tor
 */
public class TorArray {
     public Integer data[][];
     private int width, height;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
     
    public TorArray(int width, int height) {
        data = new Integer[width][height];
        
        setWidth(width);
        setHeight(height);
    }
    
    private int calcX(int x) {
        if(x > getWidth() - 1) x = 0;
        if(x < 0) x = getWidth() - 1;
        
        return x;
    }
    
    private int calcY(int y) {
        if(y > getHeight() - 1) y = 0;
        if(y < 0) y = getHeight() - 1;
        
        return y;
    }
    
    public void setCell(int x, int y, int value) {
        x = calcX(x);
        y = calcY(y);
        
        data[x][y]=value;
    }
    
    public int getCell(int x, int y) {
        x = calcX(x);
        y = calcY(y);        
        
        return data[x][y];
    }
    
    public int getCellsCount(int i, int j) {
        int result=0;

        if( getCell(i-1, j+1) == 1 ) result++; 
        if( getCell(i-1, j-1) == 1 ) result++; 
        if( getCell(i-1, j) == 1 ) result++; 
        if( getCell(i, j-1) == 1 ) result++; 
        if( getCell(i+1, j+1) == 1 ) result++; 
        if( getCell(i+1, j-1) == 1 ) result++;
        if( getCell(i+1, j) == 1 ) result++;
        if( getCell(i, j+1) == 1 ) result++; 
        
        return result;
    }
    
    
}
