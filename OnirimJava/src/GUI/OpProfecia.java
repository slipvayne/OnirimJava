
package GUI;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JButton;


public class OpProfecia {
    
    private ArrayList<JButton> botoes;
    private int x;
    private int y;
    
    public OpProfecia(int _x, int _y){
        x = _x;
        y = _y;
        
        //Criar botoes
        botoes = new ArrayList<JButton>();  
    }
    
    public void desenhar(Graphics g, Component c)
    {
        for(int i = 0;i<botoes.size();i++)
        {
            botoes.get(i).setLocation(this.x + i*10, this.y);
            botoes.get(i).paint(g);
        }
    }
    
}
