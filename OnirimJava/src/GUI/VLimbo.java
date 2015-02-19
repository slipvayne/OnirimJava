
package GUI;

import java.awt.*;
import java.io.Serializable;
import javax.swing.ImageIcon;
import projecto.ImageCreator;


public class VLimbo implements Serializable{
    
    private final String BACK = "images\\BACK.png";
    private static ImageIcon ImageIcon_back;
    private int x;
    private int y;
    private int tamanho;
    
    
    public VLimbo(int _x, int _y) {
        x = _x;
        y = _y;
        tamanho = 0;
        ImageIcon_back = (new ImageCreator( BACK)).createImageIcon();
    }
    
    
    public void desenhar(Graphics g, Component c){
        
        if(tamanho>0){
            Image img_back = ImageIcon_back.getImage();
            g.drawImage(img_back, x, y, null);
        }
        
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
        g.setFont(font);
        g.setColor(Color.WHITE);

        g.drawString(String.valueOf(tamanho), 275, 100);
            
        Font f = new Font(Font.SERIF,Font.BOLD,30);
        g.setFont(f);
        g.drawString("Limbo", 250, 200);
           
    }
    
    public void update(int n) {
        tamanho = n;
    }
    
    
}
