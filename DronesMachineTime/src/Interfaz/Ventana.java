package Interfaz;

import Programa.IConstants;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
/**
*
*█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
*█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
*█░░║║║╠─║─║─║║║║║╠─░░█
*█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
*█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
*
**/
public class Ventana extends JPanel implements MouseListener
{
    //Variables globales
    private int contador;
    private IConstants pConstants;
    
    /**
    * Constructor.
    *
    * @param Variables del programa
    **/ 
    public Ventana(IConstants pGlobales)
    {
        addMouseListener(this);
        this.contador = 0;
        this.pConstants = pGlobales;
    }
    
    /**
    * Pinto en la interfaz de modo dinamico, tiempo secuencial.
    * 
    * @param Objeto sobre el cual dibujo
    **/
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        for(Circulo pCirculo : pConstants.circulosList){
            pCirculo.draw(g);
           
        }

    }
    
    /**
    * Metodos mouse
    * !!!!!!!!!!!!
    **/
    @Override
    public void mouseClicked(MouseEvent e) 
    {
//        if(e.getButton() == 1){
//            getCirculosList().add(new Circulo(e.getX()-30, e.getY()-30));
//       
//                 
//            for (int i = 0; i < getCirculosList().size(); i++) {
//                System.out.println("codigo>>" + getCirculosList().get(i).getIndiceX() + " " + 
//                    getCirculosList().get(i).getIndiceY());
//            }
//            
//        
//            
//            repaint();
//        }
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}

//fin de la estructura del programa calculo de drones.................................................................100%   
}
