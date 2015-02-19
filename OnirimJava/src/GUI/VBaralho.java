
package GUI;

import java.awt.*;
import java.io.Serializable;
import javax.swing.ImageIcon;
import projecto.ImageCreator;


public class VBaralho implements Serializable{
    
    private final String IMG_BACK = "images\\BACK.png";
    private static ImageIcon ImageIcon_back;
    
    private int x;
    private int y;
    private int tamanho;
    
    
    public VBaralho(int _x, int _y){
        x = _x;
        y = _y;
        tamanho = 0;
        
        ImageIcon_back = (new ImageCreator( IMG_BACK )).createImageIcon();
    }
    
    
    public void desenhar(Graphics g, Component c){
                
        Image Image_back = ImageIcon_back.getImage();
        //g.drawImage(Image_back, x, y, null);
        g.drawImage(Image_back, x, y, 106, 160, null);
            
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
        g.setFont(font);
        //g.setColor(Color.WHITE);
        g.setColor(Color.LIGHT_GRAY);

        //g.drawString(String.valueOf(tamanho), 70, 100);
        g.drawString(String.valueOf(tamanho), 630, 550);
            
        Font f = new Font(Font.SERIF,Font.BOLD,30);
        g.setFont(f);
        //g.drawString("Baralho", 50, 200);
        g.drawString("Baralho", 600, 500);
        
    }
    
    
    public void update(int n) {
        tamanho = n;
    }
    
    public boolean contains(int _x, int _y) {
        return (_x > x && _x < (x + ImageIcon_back.getIconWidth()) && _y > y && _y < (y + ImageIcon_back.getIconHeight()));
    }
    
    
}
