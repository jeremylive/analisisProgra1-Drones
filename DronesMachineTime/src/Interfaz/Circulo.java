package Interfaz;

import java.awt.Graphics;
/**
*
*█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
*█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
*█░░║║║╠─║─║─║║║║║╠─░░█
*█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
*█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
*
**/
public class Circulo 
{
    //Variables globales
    private int indiceX = 0;
    private int indiceY = 0;
    private static final int d = 60;
    
    /**
    * Constructor.
    *
    * @param x y y donde se va dibujar el circulo representando a un nodo
    **/
    public Circulo(int x, int y)
    {
        this.setIndiceX(x);
        this.setIndiceY(y);
    }

    /**
    * Gets and Sets
    **/
    public int getIndiceX() 
    {
        return indiceX;
    }

    public void setIndiceX(int indiceX) 
    {
        this.indiceX = indiceX;
    }

    public int getIndiceY() 
    {
        return indiceY;
    }

    public void setIndiceY(int indiceY) 
    {
        this.indiceY = indiceY;
    }
    
    /**
    * Pinto.
    * 
    * @param grafico donde voy a pintar
    **/
    public void draw(Graphics g)
    {
        g.drawOval(getIndiceX(), getIndiceY(), d, d);
    }

//fin de la estructura del programa calculo de drones.................................................................100%       
}
