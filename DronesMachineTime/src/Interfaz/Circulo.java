package Interfaz;

import java.awt.Graphics;

public class Circulo 
{
    private int indiceX = 0;
    private int indiceY = 0;
    private static final int d = 60;
    
    public Circulo(int x, int y)
    {
        setIndiceX(x);
        setIndiceY(y);
    }
    
    public void draw(Graphics g)
    {
        g.drawOval(getIndiceX(), getIndiceY(), d, d);
    }

    public int getIndiceX() {
        return indiceX;
    }

    public void setIndiceX(int indiceX) {
        this.indiceX = indiceX;
    }

    public int getIndiceY() {
        return indiceY;
    }

    public void setIndiceY(int indiceY) {
        this.indiceY = indiceY;
    }
    
    
    
}
