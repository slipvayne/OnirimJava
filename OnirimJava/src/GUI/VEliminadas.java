
package GUI;

import java.awt.*;
import java.io.Serializable;
import javax.swing.ImageIcon;
import projecto.ImageCreator;


public class VEliminadas implements Serializable{
    
    private final String BACK = "images\\BACK.png";
    private static ImageIcon ImageIcon_back;
    private int x;
    private int y;
    private int tamanho;
    
    
    public VEliminadas(int _x, int _y) {
        x = _x;
        y = _y;
        tamanho = 0;
        ImageIcon_back = (new ImageCreator( BACK )).createImageIcon();
    }
    
    
    public void desenhar(Graphics g, Component c) {
        
        Image img_back = ImageIcon_back.getImage();
        //g.drawImage(img_back, x, y, null);
        g.drawImage(img_back, x, y, 106, 160, null);
        
            
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
        g.setFont(font);
        //g.setColor(Color.WHITE);
        g.setColor(Color.LIGHT_GRAY);

        //g.drawString(String.valueOf(tamanho), 270, 100); 
        g.drawString(String.valueOf(tamanho), 640, 350);
                    
        Font f = new Font(Font.SERIF,Font.BOLD,30);
        g.setFont(f);
        //g.drawString("Eliminadas", 230, 200);
        g.drawString("Eliminadas", 580, 300);
    }
    
    
    public boolean contains(int _x, int _y) {
        return (_x > x && _x < (x + ImageIcon_back.getIconWidth()) && _y > y && _y < (y + ImageIcon_back.getIconHeight()));
    }

    public void update(int n) {
        tamanho = n;
    }
    
}
