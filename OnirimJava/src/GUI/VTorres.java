
package GUI;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import projecto.ImageCreator;


public class VTorres implements Serializable{
    
    private final String BORDER = "images\\borda_torres.png";
    private static ImageIcon ImageIcon_border;
    
    private ArrayList<VCarta> cartas;
    private int x;
    private int y;
    
    
    public VTorres(int _x, int _y) {
        cartas = new ArrayList<VCarta>();
        ImageIcon_border = (new ImageCreator( BORDER )).createImageIcon();
        x = _x;
        y = _y;
        
    }
    
    
    public boolean contains(int _x, int _y) {
        return (_x > x && _x < (x + ImageIcon_border.getIconWidth()) && _y > y && _y < (y + ImageIcon_border.getIconHeight()));
    }
    
    
    public void addCarta(VCarta c){
        cartas.add(new VCarta( c.getNomeImg() ));
        
        if (cartas.size() > 1) {
            cartas.get(cartas.size() - 1).setX(cartas.get(cartas.size() - 2).getX_final() + cartas.get(cartas.size() - 1).getLarguraImg()/4);
        }else{
            cartas.get(cartas.size() - 1).setX(x + 9);
        }
        cartas.get(cartas.size() - 1).setY(y + 9);
    }
    
    
    public void desenhar(Graphics g, Component c){
        
        Image img_border = ImageIcon_border.getImage();
        g.drawImage(img_border, x, y, null);
        
        int i = 0;
        
        //if (cartas.size() > 12)
        //    i = cartas.size() - 12;
        if (cartas.size() > 7)
            i = cartas.size() - 7;
            
        for (; i < cartas.size(); i++) {
            cartas.get(i).desenhar(g, c);
        }
    }
    
    
    public void update(ArrayList<String> c){
        cartas.clear();
        int aux = x;
        int average = 0;
        
        
        //if (c.size() > 12)
        //    average = c.size() - 12;
        if (c.size() > 7)
            average = c.size() - 7;
            
        for (int i = 0; i + average < c.size(); i++) {
            cartas.add(new VCarta(c.get(i + average)));
            cartas.get(i).setX(aux + 9);
            cartas.get(i).setY(y + 9);
            aux += cartas.get(i).getLarguraImg()/3;
        }
    }
    
    
    
}
