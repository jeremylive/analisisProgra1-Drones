package Interfaz;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Ventana extends JPanel implements MouseListener
{
    ArrayList<Circulo> circulosList = null;
    
    public Ventana()
    {
        setCirculosList(new ArrayList<Circulo>());
        addMouseListener(this);
    }

    public ArrayList<Circulo> getCirculosList() 
    {
        return circulosList;
    }

    public void setCirculosList(ArrayList<Circulo> circulosList) 
    {
        this.circulosList = circulosList;
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        for(Circulo pCirculo : getCirculosList()){
            pCirculo.draw(g);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if(e.getButton() == 1){
            getCirculosList().add(new Circulo(e.getX()-30, e.getY()-30));
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
}
